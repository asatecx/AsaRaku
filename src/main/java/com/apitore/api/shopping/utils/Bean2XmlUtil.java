package com.apitore.api.shopping.utils;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Bean2XmlUtil {
	/**
     * 将javaBean转换为xml对象
     * @param clazz
     * @param bean
     * @return
     */
    public static String parseBeanToXml(Class<?> clazz,Object bean){
        StringWriter sw = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            sw = new StringWriter();
            //该值默认为false,true则不会创建即头信息,即<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            jaxbMarshaller.marshal(bean, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
