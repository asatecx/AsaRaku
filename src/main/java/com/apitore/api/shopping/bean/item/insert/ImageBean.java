/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import javax.xml.bind.annotation.XmlElement;

/**
 * 商品画像情報
 */
public class ImageBean{
	/**
	 * 商品画像URL
	 */
	@XmlElement(name="imageUrl")
	public String imageUrl;

	/**
	 * 商品画像名（ALT）
	 */
	@XmlElement(name="imageAlt")
	public String imageAlt;
}