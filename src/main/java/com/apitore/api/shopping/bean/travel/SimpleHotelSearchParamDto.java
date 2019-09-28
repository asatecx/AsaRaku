/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.travel;

/**
 * 共通パラメータ情報
 */
public class SimpleHotelSearchParamDto{

	private String largeClassCode;

	private String middleClassCode;

	private String smallClassCode;

	private String detailClassCode;

	private int hotelNo;

	private float latitude;

	private float longitude;

	private int searchRadius;

	private String squeezeCondition;

	private int carrier;

	private int datumType;

	private int page;

	private int hits;

	private int hotelThumbnailSize;

	private String responseType;

	private String sort;

	private int allReturnFlag;

	public void setLargeClassCode(String largeClassCode) {
		this.largeClassCode = largeClassCode;
	}

	public String getLargeClassCode() {
		return this.largeClassCode;
	}

	public void setMiddleClassCode(String middleClassCode) {
		this.middleClassCode = middleClassCode;
	}

	public String getMiddleClassCode() {
		return this.middleClassCode;
	}

	public void setSmallClassCode(String smallClassCode) {
		this.smallClassCode = smallClassCode;
	}

	public String getSmallClassCode() {
		return this.smallClassCode;
	}

	public void setDetailClassCode(String detailClassCode) {
		this.detailClassCode = detailClassCode;
	}

	public String getDetailClassCode() {
		return this.detailClassCode;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public int getHotelNo() {
		return this.hotelNo;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLatitude() {
		return this.latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLongitude() {
		return this.longitude;
	}

	public void setSearchRadius(int searchRadius) {
		this.searchRadius = searchRadius;
	}

	public int getSearchRadius() {
		return this.searchRadius;
	}

	public void setSqueezeCondition(String squeezeCondition) {
		this.squeezeCondition = squeezeCondition;
	}

	public String getSqueezeCondition() {
		return this.squeezeCondition;
	}

	public void setCarrier(int carrier) {
		this.carrier = carrier;
	}

	public int getCarrier() {
		return this.carrier;
	}

	public void setDatumType(int datumType) {
		this.datumType = datumType;
	}

	public int getDatumType() {
		return this.datumType;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPage() {
		return this.page;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getHits() {
		return this.hits;
	}

	public void setHotelThumbnailSize(int hotelThumbnailSize) {
		this.hotelThumbnailSize = hotelThumbnailSize;
	}

	public int getHotelThumbnailSize() {
		return this.hotelThumbnailSize;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseType() {
		return this.responseType;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSort() {
		return this.sort;
	}

	public void setAllReturnFlag(int allReturnFlag) {
		this.allReturnFlag = allReturnFlag;
	}

	public int getAllReturnFlag() {
		return this.allReturnFlag;
	}

}