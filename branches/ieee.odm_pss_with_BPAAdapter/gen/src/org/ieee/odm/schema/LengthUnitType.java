//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.20 at 12:17:33 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for LengthUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LengthUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="Ft"/>
 *     &lt;enumeration value="KM"/>
 *     &lt;enumeration value="Mile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LengthUnitType {

    M("M"),
    @XmlEnumValue("Ft")
    FT("Ft"),
    KM("KM"),
    @XmlEnumValue("Mile")
    MILE("Mile");
    private final String value;

    LengthUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LengthUnitType fromValue(String v) {
        for (LengthUnitType c: LengthUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}