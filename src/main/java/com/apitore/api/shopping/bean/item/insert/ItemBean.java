/**
 * @author Aasatecx
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

/**
 * 商品画像情報
 */
@XmlRootElement(name="item")
public class ItemBean{

	@XmlElement(name="itemUrl")
	public String itemUrl;

	@XmlElement(name="itemNumber")
	public String itemNumber;

	@XmlElement(name="itemName")
	public String itemName;

	@XmlElement(name="itemPrice")
	public int itemPrice;

	@XmlElement(name="genreId")
	public int genreId;

	@XmlElement(name="catalogId")
	public String catalogId;

	@XmlElement(name="catalogIdExemptionReason")
	public int catalogIdExemptionReason;

	@XmlElement(name="whiteBgImageUrl")
	public String whiteBgImageUrl;

	@XmlElementWrapper(name="images")
	@XmlElement(name="image")
	public List<ImageBean> images;

	@XmlElement(name="descriptionForPC")
	public String descriptionForPC;

	@XmlElement(name="descriptionForMobile")
	public String descriptionForMobile;

	@XmlElement(name="descriptionForSmartPhone")
	public String descriptionForSmartPhone;

	@XmlElement(name="movieUrl")
	public String movieUrl;

	@XmlElementWrapper(name="options")
	@XmlElement(name="option")
	public List<OptionBean> options;

	@XmlElementWrapper(name="tagIds")
	@XmlElement(name="tagId")
	public List<TagIdBean> tagIds;

	@XmlElement(name="catchCopyForPC")
	public String catchCopyForPC;

	@XmlElement(name="catchCopyForMobile")
	public String catchCopyForMobile;

	@XmlElement(name="descriptionBySalesMethod")
	public String descriptionBySalesMethod;

	@XmlElement(name="isSaleButton")
	public boolean isSaleButton;

	@XmlElement(name="isDocumentButton")
	public boolean isDocumentButton;

	@XmlElement(name="isInquiryButton")
	public boolean isInquiryButton;

	@XmlElement(name="isStockNoticeButton")
	public boolean isStockNoticeButton;

	@XmlElement(name="displayMakerContents")
	public boolean displayMakerContents;

	@XmlElement(name="itemLayout")
	public int itemLayout;

	@XmlElement(name="isIncludedTax")
	public boolean isIncludedTax;

	@XmlElement(name="isIncludedPostage")
	public boolean isIncludedPostage;

	@XmlElement(name="isIncludedCashOnDeliveryPostage")
	public boolean isIncludedCashOnDeliveryPostage;

	@XmlElement(name="displayPrice")
	public int displayPrice;

	@XmlElement(name="orderLimit")
	public int orderLimit;

	@XmlElement(name="postage")
	public int postage;

	@XmlElement(name="postageSegment1")
	public int postageSegment1;

	@XmlElement(name="postageSegment2")
	public int postageSegment2;

	@XmlElement(name="isNoshiEnable")
	public boolean isNoshiEnable;

	@XmlElement(name="isTimeSale")
	public boolean isTimeSale;

	@XmlElement(name="timeSaleStartDateTime")
	public DateTime timeSaleStartDateTime;

	@XmlElement(name="timeSaleEndDateTime")
	public DateTime timeSaleEndDateTime;

	@XmlElement(name="isUnavailableForSearch")
	public boolean isUnavailableForSearch;

	@XmlElement(name="limitedPasswd")
	public String limitedPasswd;

	@XmlElement(name="isAvailableForMobile")
	public boolean isAvailableForMobile;

	@XmlElement(name="isDepot")
	public boolean isDepot;

	@XmlElement(name="detailSellType")
	public int detailSellType;

	@XmlElement(name="releaseDate")
	public Date releaseDate;

	@XmlElement(name="point")
	public PointBean point;

	@XmlElement(name="itemInventory")
	public ItemInventoryBean itemInventory;

	@XmlElement(name="asurakuDeliveryId")
	public String asurakuDeliveryId;

	@XmlElement(name="deliverySetId")
	public int deliverySetId;

	@XmlElement(name="sizeChartLinkCode")
	public String sizeChartLinkCode;

	@XmlElement(name="reviewDisp")
	public int reviewDisp;

	@XmlElement(name="medicine")
	public MedicineBean medicine;

	@XmlElement(name="displayPriceId")
	public int displayPriceId;

	@XmlElementWrapper(name="categories")
	@XmlElement(name="categoryInfo")
	public List<CategoryInfoBean> categories;

	@XmlElement(name="itemWeight")
	public int itemWeight;

	@XmlElement(name="layoutCommonId")
	public int layoutCommonId;

	@XmlElement(name="layoutMapId")
	public int layoutMapId;

	@XmlElement(name="textSmallId")
	public int textSmallId;

	@XmlElement(name="lossLeaderId")
	public int lossLeaderId;

	@XmlElement(name="textLargeId")
	public int textLargeId;

	@XmlElement(name="shopAreaSoryoPatternId")
	public int shopAreaSoryoPatternId;

	@XmlElement(name="taxRate")
	public double taxRate;

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public void setCatalogIdExemptionReason(int catalogIdExemptionReason) {
		this.catalogIdExemptionReason = catalogIdExemptionReason;
	}

	public void setMedicine(MedicineBean medicine) {
		this.medicine = medicine;
	}

	public void setItemLayout(int itemLayout) {
		this.itemLayout = itemLayout;
	}

	public void setItemInventory(ItemInventoryBean itemInventory) {
		this.itemInventory = itemInventory;
	}

	public void setItemWeight(int itemWeight) {
		this.itemWeight = itemWeight == 0 ? 999999999 : itemWeight;
	}

}