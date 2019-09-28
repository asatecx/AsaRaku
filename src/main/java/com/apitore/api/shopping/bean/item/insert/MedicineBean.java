/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import javax.xml.bind.annotation.XmlElement;

/**
 * 薬事情報
 */
public class MedicineBean{

	@XmlElement(name="medCaption")
	public String medCaption;

	@XmlElement(name="medAttention")
	public String medAttention;

	public void setMedCaption(String medCaption) {
		this.medCaption = medCaption;
	}

	public void setMedAttention(String medAttention) {
		this.medAttention = medAttention;
	}

}