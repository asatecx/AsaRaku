package com.apitore.api.shopping.service;

import java.util.List;

import org.apache.http.NameValuePair;
import org.springframework.stereotype.Service;

import com.apitore.api.shopping.base.BaseService;
@Service
public class ItemService extends BaseService{

	public String search(List<NameValuePair> params){
		return doHttpGET("https://api.rms.rakuten.co.jp/es/1.0/item/search", params);
	}

	public String insert(String xmlRequest){
		xmlRequest = "<request><itemInsertRequest>"+xmlRequest+"</itemInsertRequest></request>";
		return doHttpPOSTXML("https://api.rms.rakuten.co.jp/es/1.0/item/insert", xmlRequest);
	}
}
