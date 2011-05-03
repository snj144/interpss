//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.29 at 11:34:17 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for SVCControlModeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SVCControlModeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Voltage"/>
 *     &lt;enumeration value="ReactivePower"/>
 *     &lt;enumeration value="Off"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SVCControlModeEnumType {

    @XmlEnumValue("Voltage")
    VOLTAGE("Voltage"),
    @XmlEnumValue("ReactivePower")
    REACTIVE_POWER("ReactivePower"),
    @XmlEnumValue("Off")
    OFF("Off");
    private final String value;

    SVCControlModeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SVCControlModeEnumType fromValue(String v) {
        for (SVCControlModeEnumType c: SVCControlModeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}