/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 商品在庫情報
 */
public class ItemInventoryBean{

	@XmlElement(name="inventoryType")
	public int inventoryType;

	@XmlElementWrapper(name="inventories")
	@XmlElement(name="inventory")
	public List<InventoryBean> inventories;

	@XmlElement(name="verticalName")
	public String verticalName;

	@XmlElement(name="horizontalName")
	public String horizontalName;

	@XmlElement(name="inventoryQuantityFlag")
	public int inventoryQuantityFlag;

	@XmlElement(name="inventoryDisplayFlag")
	public Integer inventoryDisplayFlag;

	public void setInventoryType(int inventoryType) {
		this.inventoryType = inventoryType;
	}

	public void setInventories(List<InventoryBean> inventories) {
		this.inventories = inventories;
	}

}