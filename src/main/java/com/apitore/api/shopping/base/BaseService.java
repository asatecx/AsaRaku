package com.apitore.api.shopping.base;
import java.nio.charset.Charset;
import java.util.Base64;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
@Service
public class BaseService {

	@Value("${rakuten.webapi.serviceSecret}")
	private String SERVICE_SECRET;

	@Value("${rakuten.webapi.licenseKey}")
	private String LICENSE_KEY;

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

	public String doHttpGET(String uri, List<NameValuePair> params) {
		String result = "";
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			try {
				String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
				HttpGet httpGet = new HttpGet(uri + "?" + str);
				httpGet.addHeader("Authorization", getHeader());
				response = client.execute(httpGet);
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity);
				System.out.println("★★★レスポンス★★★：" + result);
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
		return result;
	}


    public String doHttpPOST(String uri, Map<String, Object> param) {
    	String result = "";
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = null;
            try {
                HttpPost httpPost = new HttpPost(uri);
//              httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
                httpPost.addHeader("Authorization", getHeader());
                System.out.println("★★★パラメータ★★★：" + new Gson().toJson(param));
                httpPost.setEntity(new StringEntity(new Gson().toJson(param),
                        ContentType.create("application/json", "UTF-8")));

                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
                System.out.println("★★★レスポンス★★★：" + result);
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
        return result;
    }


//    public String doHttpPOST(String uri, List<NameValuePair> params) {
//    	String result = "";
//        try {
//            CloseableHttpClient client = HttpClients.createDefault();
//            CloseableHttpResponse response = null;
//            try {
//            	ObjectMapper objectMapper = new ObjectMapper();
//            	Map<String, Object> data = new HashMap<String, Object>();
//                data.put("dateType", "1");
//                data.put("startDatetime", "2017-12-14T00:00:00+0900");
//                data.put("endDatetime", "2018-01-14T00:00:00+0900");
//                data.put("PaginationRequestModel", "2017-12-14T00:00:00+0900");
////                data.put("startDatetime", "2017-12-14T00:00:00+0900");
//
//                HttpPost httpPost = new HttpPost(uri);
//                httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
//                httpPost.addHeader("Authorization", getHeader());
//                httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data),
//                        ContentType.create("text/json", "UTF-8")));
//
//                response = client.execute(httpPost);
//                HttpEntity entity = response.getEntity();
//                result = EntityUtils.toString(entity);
//                System.out.println(result);
//            } finally {
//                if (response != null) {
//                    response.close();
//                }
//                if (client != null) {
//                    client.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

}
