package com.apitore.api.shopping.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apitore.api.shopping.base.BaseService;
import com.apitore.api.shopping.controler.RakutenController;
import com.apitore.api.shopping.utils.UrlFormatter;
@Service
public class ZipInfoService extends BaseService{

	private final Logger LOG = LoggerFactory.getLogger(RakutenController.class);

	@Value("${zip.endpoint}")
	private String ENDPOINT;

	public ResponseEntity<Map<String, Object>> getZipInfoByZipCode() {

		try {
			Map<String, String> params = new HashMap<String, String>();
			//共通パラメータ設定
			params.put("zipcode", "2610011");
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
