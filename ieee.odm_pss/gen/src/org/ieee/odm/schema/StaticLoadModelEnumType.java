//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.29 at 06:10:04 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for StaticLoadModelEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StaticLoadModelEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Constant_Z"/>
 *     &lt;enumeration value="Constant_P"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum StaticLoadModelEnumType {

    @XmlEnumValue("Constant_Z")
    CONSTANT_Z("Constant_Z"),
    @XmlEnumValue("Constant_P")
    CONSTANT_P("Constant_P");
    private final String value;

    StaticLoadModelEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StaticLoadModelEnumType fromValue(String v) {
        for (StaticLoadModelEnumType c: StaticLoadModelEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
