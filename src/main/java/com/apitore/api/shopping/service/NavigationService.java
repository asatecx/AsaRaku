package com.apitore.api.shopping.service;

import java.util.List;

import org.apache.http.NameValuePair;
import org.springframework.stereotype.Service;

import com.apitore.api.shopping.base.BaseService;
@Service
public class NavigationService extends BaseService{

	public String genre_get(List<NameValuePair> params){
		return doHttpGET("https://api.rms.rakuten.co.jp/es/1.0/navigation/genre/get", params);
	}
}
