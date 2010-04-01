//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.03.31 at 08:21:02 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReactivePowerUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReactivePowerUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PU"/>
 *     &lt;enumeration value="VAR"/>
 *     &lt;enumeration value="KVAR"/>
 *     &lt;enumeration value="MVAR"/>
 *     &lt;enumeration value="Ohm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReactivePowerUnitType")
@XmlEnum
public enum ReactivePowerUnitType {

    PU("PU"),
    VAR("VAR"),
    KVAR("KVAR"),
    MVAR("MVAR"),
    @XmlEnumValue("Ohm")
    OHM("Ohm");
    private final String value;

    ReactivePowerUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReactivePowerUnitType fromValue(String v) {
        for (ReactivePowerUnitType c: ReactivePowerUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
