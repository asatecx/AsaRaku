package com.apitore.api.shopping.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apitore.api.shopping.base.BaseService;
@Service
public class CommonService extends BaseService{
	@ResponseBody
	public Map<String, Object> getResponse(String url, Map<String, String> params){
		return super.getResponse(url, params);
	}
}
