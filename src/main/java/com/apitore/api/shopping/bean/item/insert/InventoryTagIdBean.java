/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import javax.xml.bind.annotation.XmlElement;

/**
 * SKUタグID情報
 */
public class InventoryTagIdBean{
	/**
	 * SKUタグID
	 */
	@XmlElement(name="tagId")
	public String tagId;
}