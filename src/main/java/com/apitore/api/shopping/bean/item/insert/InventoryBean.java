/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 在庫情報
 */
public class InventoryBean{

	@XmlElement(name="inventoryCount")
	public int inventoryCount;

	@XmlElement(name="childNoVertical")
	public String childNoVertical;

	@XmlElement(name="childNoHorizontal")
	public String childNoHorizontal;

	@XmlElement(name="optionNameVertical")
	public String optionNameVertical;

	@XmlElement(name="optionNameHorizontal")
	public String optionNameHorizontal;

	@XmlElement(name="isBackorderAvailable")
	public boolean isBackorderAvailable;

	@XmlElement(name="normalDeliveryDateId")
	public String normalDeliveryDateId;

	@XmlElement(name="backorderDeliveryDateId")
	public String backorderDeliveryDateId;

	@XmlElement(name="isBackorder")
	public boolean isBackorder;

	@XmlElement(name="isRestoreInventoryFlag")
	public boolean isRestoreInventoryFlag;

	@XmlElementWrapper(name="images")
	@XmlElement(name="image")
	public List<InventoryImageBean> images;

	@XmlElementWrapper(name="tagIds")
	@XmlElement(name="tagId")
	public List<InventoryTagIdBean> tagIds;

	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

}