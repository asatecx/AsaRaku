/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import javax.xml.bind.annotation.XmlElement;

/**
 * SKU画像情報
 */
public class InventoryImageBean{
	/**
	 * SKU画像URL
	 */
	@XmlElement(name="imageUrl")
	public String imageUrl;

}