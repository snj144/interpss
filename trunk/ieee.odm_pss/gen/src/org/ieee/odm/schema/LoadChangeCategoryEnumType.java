//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 08:28:58 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for LoadChangeCategoryEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoadChangeCategoryEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LowFrequence"/>
 *     &lt;enumeration value="LowVoltage"/>
 *     &lt;enumeration value="FixedTime"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LoadChangeCategoryEnumType {

    @XmlEnumValue("LowFrequence")
    LOW_FREQUENCE("LowFrequence"),
    @XmlEnumValue("LowVoltage")
    LOW_VOLTAGE("LowVoltage"),
    @XmlEnumValue("FixedTime")
    FIXED_TIME("FixedTime");
    private final String value;

    LoadChangeCategoryEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoadChangeCategoryEnumType fromValue(String v) {
        for (LoadChangeCategoryEnumType c: LoadChangeCategoryEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
