package com.apitore.api.shopping.service.travel;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.apitore.api.shopping.base.BaseService;
import com.apitore.api.shopping.bean.travel.CommonParamDto;
import com.apitore.api.shopping.controler.RakutenController;
import com.apitore.api.shopping.utils.UrlFormatter;
@Service
public class GetAreaClassService extends BaseService{

	private final Logger LOG = LoggerFactory.getLogger(RakutenController.class);

	@Value("${rakuten.endpoint.getAreaClass}")
	private String ENDPOINT;

	private final String HITS = "30";

	public ResponseEntity<Map<String, Object>> getAreaClass(CommonParamDto cp) {

		try {
			Map<String, String> params = new HashMap<String, String>();
			//共通パラメータ設定
			params.put("applicationId", cp.getApplicationId());
			if (!ObjectUtils.isEmpty(cp.getAffiliateId()))
				params.put("affiliateId", cp.getAffiliateId());
			params.put("format", cp.getFormat());
			params.put("formatVersion", String.valueOf(cp.getFormatVersion()));
			params.put("hits", HITS);
			String url = UrlFormatter.format(ENDPOINT, params);
			Map<String, Object> response = super.getResponse(url, params);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			LOG.error("IllegalArgumentException", e);
			Map<String, Object> response = new HashMap<String, Object>();
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOG.error("Exception", e);
			Map<String, Object> response = new HashMap<String, Object>();
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
