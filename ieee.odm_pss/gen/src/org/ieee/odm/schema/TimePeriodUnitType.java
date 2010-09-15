//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.15 at 01:46:12 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for TimePeriodUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TimePeriodUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sec"/>
 *     &lt;enumeration value="PU"/>
 *     &lt;enumeration value="Min"/>
 *     &lt;enumeration value="Hour"/>
 *     &lt;enumeration value="Cycle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TimePeriodUnitType {

    @XmlEnumValue("Sec")
    SEC("Sec"),
    PU("PU"),
    @XmlEnumValue("Min")
    MIN("Min"),
    @XmlEnumValue("Hour")
    HOUR("Hour"),
    @XmlEnumValue("Cycle")
    CYCLE("Cycle");
    private final String value;

    TimePeriodUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TimePeriodUnitType fromValue(String v) {
        for (TimePeriodUnitType c: TimePeriodUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
