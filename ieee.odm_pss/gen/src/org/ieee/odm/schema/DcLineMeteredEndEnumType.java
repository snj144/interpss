//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.08 at 09:51:23 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for DcLineMeteredEndEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DcLineMeteredEndEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="rectifier"/>
 *     &lt;enumeration value="inverter"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum DcLineMeteredEndEnumType {

    @XmlEnumValue("rectifier")
    RECTIFIER("rectifier"),
    @XmlEnumValue("inverter")
    INVERTER("inverter");
    private final String value;

    DcLineMeteredEndEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DcLineMeteredEndEnumType fromValue(String v) {
        for (DcLineMeteredEndEnumType c: DcLineMeteredEndEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
