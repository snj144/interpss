//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.30 at 03:27:45 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for LoadCharacteristicTypeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoadCharacteristicTypeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IEEEStaticLoad"/>
 *     &lt;enumeration value="ComplexLoad"/>
 *     &lt;enumeration value="InductionMotor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LoadCharacteristicTypeEnumType {

    @XmlEnumValue("IEEEStaticLoad")
    IEEE_STATIC_LOAD("IEEEStaticLoad"),
    @XmlEnumValue("ComplexLoad")
    COMPLEX_LOAD("ComplexLoad"),
    @XmlEnumValue("InductionMotor")
    INDUCTION_MOTOR("InductionMotor");
    private final String value;

    LoadCharacteristicTypeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoadCharacteristicTypeEnumType fromValue(String v) {
        for (LoadCharacteristicTypeEnumType c: LoadCharacteristicTypeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
