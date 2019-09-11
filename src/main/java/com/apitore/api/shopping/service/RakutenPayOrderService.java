package com.apitore.api.shopping.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.apitore.api.shopping.base.BaseService;
@Service
public class RakutenPayOrderService extends BaseService{

	public String getOrder(Map<String, Object> param){
		return doHttpPOST("https://api.rms.rakuten.co.jp/es/2.0/order/getOrder/", param);
	}
}
