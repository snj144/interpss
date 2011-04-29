//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.29 at 07:02:33 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for MachineControllerEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MachineControllerEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Exciter"/>
 *     &lt;enumeration value="Governor"/>
 *     &lt;enumeration value="Stabilizer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum MachineControllerEnumType {

    @XmlEnumValue("Exciter")
    EXCITER("Exciter"),
    @XmlEnumValue("Governor")
    GOVERNOR("Governor"),
    @XmlEnumValue("Stabilizer")
    STABILIZER("Stabilizer");
    private final String value;

    MachineControllerEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MachineControllerEnumType fromValue(String v) {
        for (MachineControllerEnumType c: MachineControllerEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
