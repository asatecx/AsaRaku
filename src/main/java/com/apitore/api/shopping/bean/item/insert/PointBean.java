/**
 * @author Tang
 *
 */
package com.apitore.api.shopping.bean.item.insert;

import javax.xml.bind.annotation.XmlElement;

import org.joda.time.DateTime;

/**
 * ポイント情報
 */
public class PointBean{

	@XmlElement(name="pointRate")
	public int pointRate;

	@XmlElement(name="pointRateStart")
	public DateTime pointRateStart;

	@XmlElement(name="pointRateEnd")
	public DateTime pointRateEnd;


}