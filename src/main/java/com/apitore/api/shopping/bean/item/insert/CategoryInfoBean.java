/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import javax.xml.bind.annotation.XmlElement;

/**
 * カテゴリ情報
 */
public class CategoryInfoBean{

	@XmlElement(name="categorySetManageNumber")
	public String categorySetManageNumber;

	@XmlElement(name="categoryId")
	public int categoryId;

	@XmlElement(name="isPluralItemPage")
	public boolean isPluralItemPage;

}