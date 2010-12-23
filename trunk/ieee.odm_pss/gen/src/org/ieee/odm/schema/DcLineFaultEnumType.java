//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.23 at 11:13:49 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for DcLineFaultEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DcLineFaultEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fromBus_Bipole_Short_Circuit"/>
 *     &lt;enumeration value="toBus_Bipole_Short_Circuit"/>
 *     &lt;enumeration value="fault_on_Line"/>
 *     &lt;enumeration value="power_blocked"/>
 *     &lt;enumeration value="power_reversed"/>
 *     &lt;enumeration value="power_change_by_specification"/>
 *     &lt;enumeration value="current_change_by_specification"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum DcLineFaultEnumType {

    @XmlEnumValue("fromBus_Bipole_Short_Circuit")
    FROM_BUS_BIPOLE_SHORT_CIRCUIT("fromBus_Bipole_Short_Circuit"),
    @XmlEnumValue("toBus_Bipole_Short_Circuit")
    TO_BUS_BIPOLE_SHORT_CIRCUIT("toBus_Bipole_Short_Circuit"),
    @XmlEnumValue("fault_on_Line")
    FAULT_ON_LINE("fault_on_Line"),
    @XmlEnumValue("power_blocked")
    POWER_BLOCKED("power_blocked"),
    @XmlEnumValue("power_reversed")
    POWER_REVERSED("power_reversed"),
    @XmlEnumValue("power_change_by_specification")
    POWER_CHANGE_BY_SPECIFICATION("power_change_by_specification"),
    @XmlEnumValue("current_change_by_specification")
    CURRENT_CHANGE_BY_SPECIFICATION("current_change_by_specification");
    private final String value;

    DcLineFaultEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DcLineFaultEnumType fromValue(String v) {
        for (DcLineFaultEnumType c: DcLineFaultEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
