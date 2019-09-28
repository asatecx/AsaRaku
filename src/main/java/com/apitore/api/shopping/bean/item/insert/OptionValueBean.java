/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import javax.xml.bind.annotation.XmlElement;

/**
 * Select/Checkbox用選択肢情報
 */
public class OptionValueBean{
	/**
	 * Select/Checkbox用選択肢
	 */
	@XmlElement(name="value")
	public String value;

}