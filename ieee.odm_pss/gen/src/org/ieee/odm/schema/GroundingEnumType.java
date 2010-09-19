//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.18 at 07:53:49 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for GroundingEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GroundingEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ungrounded"/>
 *     &lt;enumeration value="SolidGrounded"/>
 *     &lt;enumeration value="ZGrounded"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum GroundingEnumType {

    @XmlEnumValue("Ungrounded")
    UNGROUNDED("Ungrounded"),
    @XmlEnumValue("SolidGrounded")
    SOLID_GROUNDED("SolidGrounded"),
    @XmlEnumValue("ZGrounded")
    Z_GROUNDED("ZGrounded");
    private final String value;

    GroundingEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GroundingEnumType fromValue(String v) {
        for (GroundingEnumType c: GroundingEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
