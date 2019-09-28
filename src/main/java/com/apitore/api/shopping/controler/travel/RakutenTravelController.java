package com.apitore.api.shopping.controler.travel;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apitore.api.shopping.bean.travel.CommonParamDto;
import com.apitore.api.shopping.bean.travel.SimpleHotelSearchParamDto;
import com.apitore.api.shopping.service.ZipInfoService;
import com.apitore.api.shopping.service.travel.GetAreaClassService;
import com.apitore.api.shopping.service.travel.SimpleHotelSearchService;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ASATECX
 */
@Controller
@RequestMapping(value = "/rakutenTravel")
public class RakutenTravelController {

	@Value("${rakuten.application.id}")
	private String RAKUTEN_APPLICATION_ID;

	@Value("${rakuten.affiliate.id}")
	private String RAKUTEN_AFFILIATE_ID;

	private CommonParamDto cp = new CommonParamDto();

	@Autowired
	SimpleHotelSearchService simpleHotelSearchService;

	@Autowired
	GetAreaClassService getAreaClassService;

	@Autowired
	ZipInfoService zipInfoService;

	@RequestMapping("/travel")
    public String toIndex(Model model, HttpSession session) {
		Map<String, Object> simpleHotelSearchResult = new HashMap<String, Object>();
		model.addAttribute("simpleHotelSearchResult", simpleHotelSearchResult);

		cp.setApplicationId(RAKUTEN_APPLICATION_ID);
		cp.setFormat("json");
		cp.setFormatVersion(2);
		ResponseEntity<Map<String, Object>> res = getAreaClassService.getAreaClass(cp);
		Map<String, Object> areaClass = (Map<String, Object>)res.getBody();

		ResponseEntity<Map<String, Object>> resZipInfo = zipInfoService.getZipInfoByZipCode();
		model.addAttribute("areaClass", areaClass);
        return "travel/TravelSearch";
    }

	@RequestMapping(value = "/Travel/SimpleHotelSearch", method = RequestMethod.POST)
	public String simpleHotelSearch(
			@RequestParam("largeClassCode") String largeClassCode,
			@RequestParam("middleClassCode") String middleClassCode,
			@RequestParam("smallClassCode") String smallClassCode,
			@RequestParam(value = "detailClassCode", required = false) String detailClassCode,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "sort", required = false, defaultValue = "standard") String sort,
			Model model,
			HttpSession session) {

		SimpleHotelSearchParamDto simpleHotelSearchParamDto = new SimpleHotelSearchParamDto();
		simpleHotelSearchParamDto.setLargeClassCode(largeClassCode);
		simpleHotelSearchParamDto.setMiddleClassCode(middleClassCode);
		simpleHotelSearchParamDto.setSmallClassCode(smallClassCode);
		simpleHotelSearchParamDto.setDetailClassCode(detailClassCode);

		ResponseEntity<Map<String, Object>> res = simpleHotelSearchService.simpleHotelSearch(cp, simpleHotelSearchParamDto);

		Map<String, Object> simpleHotelSearchResult = (Map<String, Object>)res.getBody();
		model.addAttribute("simpleHotelSearchResult", simpleHotelSearchResult);
		return "travel/TravelSearch";
	}

	@RequestMapping(value = "/private/Travel/SimpleHotelSearch", method = RequestMethod.GET)
	@ApiIgnore
	public String privateSimpleHotelSearch(
			@RequestParam("largeClassCode") String largeClassCode,
			@RequestParam("middleClassCode") String middleClassCode,
			@RequestParam("smallClassCode") String smallClassCode,
			@RequestParam("detailClassCode") String detailClassCode,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "sort", required = false, defaultValue = "standard") String sort,
			Model model,
			HttpSession session) {

		return simpleHotelSearch(
				largeClassCode,
				middleClassCode,
				smallClassCode,
				detailClassCode,
				page,
				sort,
				model,
				session);
	}

}
