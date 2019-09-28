/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.travel;

/**
 * 共通パラメータ情報
 */
public class CommonParamDto{

	private String applicationId;

	private String affiliateId;

	private String format;

	private String callback;

	private String elements;

	private int formatVersion;

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setAffiliateId(String affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getAffiliateId() {
		return this.affiliateId;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFormat() {
		return this.format;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getCallback() {
		return this.callback;
	}

	public void setElements(String elements) {
		this.elements = elements;
	}

	public String getElements() {
		return this.elements;
	}

	public void setFormatVersion(int formatVersion) {
		this.formatVersion = formatVersion;
	}

	public int getFormatVersion() {
		return this.formatVersion;
	}

}