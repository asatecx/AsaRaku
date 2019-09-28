/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import javax.xml.bind.annotation.XmlElement;

/**
 * タグID情報
 */
public class TagIdBean{
	/**
	 * タグID
	 */
	@XmlElement(name="tagId")
	public String tagId;

}