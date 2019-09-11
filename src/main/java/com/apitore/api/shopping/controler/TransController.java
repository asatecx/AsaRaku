package com.apitore.api.shopping.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apitore.api.shopping.service.ItemService;
import com.apitore.api.shopping.service.NavigationService;
import com.apitore.api.shopping.service.RakutenPayOrderService;
import com.apitore.api.shopping.service.ShopManagementService;
import com.google.common.collect.Lists;

/**
 * @author ASATECX
 */
@Controller
@RequestMapping(value = "/")
public class TransController {

	@Autowired
	ShopManagementService shopManagementService;

	@Autowired
	NavigationService navigationService;

	@Autowired
	ItemService itemService;

	@Autowired
	RakutenPayOrderService rakutenPayOrderService;

    @RequestMapping("/index")
    public String toIndex(ModelAndView mv, HttpSession session) {
        return "Search";
    }


//    @RequestMapping("/Search")
//    public ModelAndView  toAdmin(ModelAndView mv, HttpSession session) {
//        mv.setViewName("XXXX");
//        return mv;
//    }

	@RequestMapping("/testget")
	public String toAdmin(ModelAndView mv, HttpSession session) {
		List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("categoryMapId", "30469"));

		String res = shopManagementService.dsgn_category_list_get(params);
		session.setAttribute("apiResult", res);
		System.out.println(res);
		return "ResResult";
	}

	@RequestMapping("/testget2")
	public String testget2(ModelAndView mv, HttpSession session) {
		List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("genreId", "30469"));

		String res = navigationService.genre_get(params);
		session.setAttribute("apiResult", res);
		System.out.println(res);
		return "ResResult";
	}

	@RequestMapping("/testget3")
	public String testget3(ModelAndView mv, HttpSession session) {
		List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("itemName", "aaa"));

		String res = itemService.search(params);
		session.setAttribute("apiResult", res);
		System.out.println(res);
		return "ResResult";
	}

	@RequestMapping("/testget4")
	public String testget4(ModelAndView mv, HttpSession session) {
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> orderNumberList = new ArrayList<String>();
		orderNumberList.add("502763-20171027-00006701");
		orderNumberList.add("502763-20171027-00006702");
		param.put("orderNumberList", orderNumberList);

		String res = rakutenPayOrderService.getOrder(param);
		session.setAttribute("apiResult", res);
		return "ResResult";
	}
}
