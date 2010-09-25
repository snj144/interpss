//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.25 at 10:50:56 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for LFGenCodeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LFGenCodeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PQ"/>
 *     &lt;enumeration value="PV"/>
 *     &lt;enumeration value="Swing"/>
 *     &lt;enumeration value="NoneGen"/>
 *     &lt;enumeration value="OFF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LFGenCodeEnumType {

    PQ("PQ"),
    PV("PV"),
    @XmlEnumValue("Swing")
    SWING("Swing"),
    @XmlEnumValue("NoneGen")
    NONE_GEN("NoneGen"),
    OFF("OFF");
    private final String value;

    LFGenCodeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LFGenCodeEnumType fromValue(String v) {
        for (LFGenCodeEnumType c: LFGenCodeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
