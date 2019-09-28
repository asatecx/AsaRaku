package com.apitore.api.shopping.base;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class BaseService {

	@Value("${rakuten.webapi.serviceSecret}")
	private String SERVICE_SECRET;

	@Value("${rakuten.webapi.licenseKey}")
	private String LICENSE_KEY;

	@Bean(name = "rakutenRestTemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	@Qualifier(value = "rakutenRestTemplate")
	private RestTemplate restTemplate;

	private final Base64.Encoder encoder = Base64.getEncoder();

	/**
	* 构造Basic Auth认证头信息
	*
	* @return
	*/
	private String getHeader() {
		String auth = SERVICE_SECRET + ":" + LICENSE_KEY;
		byte[] encodedAuth = encoder.encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "ESA " + new String(encodedAuth);
		return authHeader;
	}

	/**
	* HTTPGET
	*
	* @return
	*/
	public String doHttpGET(String uri, List<NameValuePair> params) {
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			try {
				String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
				HttpGet httpGet = new HttpGet(uri + "?" + str);
				httpGet.addHeader("Authorization", getHeader());
				response = client.execute(httpGet);
				HttpEntity entity = response.getEntity();
				System.out.println("★★★レスポンス★★★：" + EntityUtils.toString(entity));
				return EntityUtils.toString(entity);
			} finally {
				if (response != null) {
					response.close();
				}
				if (client != null) {
					client.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	* HTTPPOST
	*
	* @return
	*/
	public String doHttpPOST(String uri, Map<String, Object> param) {
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			try {
				HttpPost httpPost = new HttpPost(uri);
				httpPost.addHeader("Authorization", getHeader());
				System.out.println("★★★パラメータ★★★：" + new Gson().toJson(param));
				httpPost.setEntity(new StringEntity(new Gson().toJson(param),
						ContentType.create("application/json", "UTF-8")));

				response = client.execute(httpPost);
				HttpEntity entity = response.getEntity();
				System.out.println("★★★レスポンス★★★：" + EntityUtils.toString(entity));
				return EntityUtils.toString(entity);
			} finally {
				if (response != null) {
					response.close();
				}
				if (client != null) {
					client.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	* HTTPPOST
	*
	* @return
	*/
	public String doHttpPOSTXML(String uri, String xmlRequest) {
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			try {
				HttpPost httpPost = new HttpPost(uri);
				httpPost.addHeader("Authorization", getHeader());
				System.out.println("★★★パラメータ★★★：" + xmlRequest);
				httpPost.setEntity(new StringEntity(xmlRequest,
						ContentType.create("text/xml", "UTF-8")));

				response = client.execute(httpPost);
				HttpEntity entity = response.getEntity();

				System.out.println("★★★レスポンス★★★：" + EntityUtils.toString(entity));
				return EntityUtils.toString(entity);
			} finally {
				if (response != null) {
					response.close();
				}
				if (client != null) {
					client.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getResponse(String url, Map<String, String> params){
		Map<String, Object> response = null;
		int i = 0;
		while (i < 5) {
			try {
				response = restTemplate.getForObject(url, Map.class, params);
				break;
			} catch (RestClientException e) {
				e.printStackTrace();
				response = new HashMap<String, Object>();
				i++;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return response;
	}
}
