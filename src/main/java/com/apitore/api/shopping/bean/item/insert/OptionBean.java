/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Select/Checkbox用項目情報
 */
public class OptionBean{
	/**
	 * Select/Checkbox用項目名
	 */
	@XmlElement(name="optionName")
	public String optionName;

	/**
	 * 選択肢スタイル
	 */
	@XmlElement(name="optionStyle")
	public int optionStyle;

	/**
	 * Select/Checkbox用選択肢情報リスト
	 */
	@XmlElement(name="optionValues")
	public List<OptionValueBean> optionValues;
}