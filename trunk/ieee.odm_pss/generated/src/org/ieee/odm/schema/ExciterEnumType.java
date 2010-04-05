//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.04 at 05:26:16 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ExciterEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExciterEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IEEE1992TypeAC1A"/>
 *     &lt;enumeration value="IEEE1981TypeAC2"/>
 *     &lt;enumeration value="IEEE1981ST1"/>
 *     &lt;enumeration value="BPAFJ"/>
 *     &lt;enumeration value="IEEE1968Type1"/>
 *     &lt;enumeration value="IEEEModified1968Type1"/>
 *     &lt;enumeration value="IEEE1981NewExcSystem"/>
 *     &lt;enumeration value="IEEETypeDC2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ExciterEnumType {

    @XmlEnumValue("IEEE1992TypeAC1A")
    IEEE_1992_TYPE_AC_1_A("IEEE1992TypeAC1A"),
    @XmlEnumValue("IEEE1981TypeAC2")
    IEEE_1981_TYPE_AC_2("IEEE1981TypeAC2"),
    @XmlEnumValue("IEEE1981ST1")
    IEEE_1981_ST_1("IEEE1981ST1"),
    BPAFJ("BPAFJ"),
    @XmlEnumValue("IEEE1968Type1")
    IEEE_1968_TYPE_1("IEEE1968Type1"),
    @XmlEnumValue("IEEEModified1968Type1")
    IEEE_MODIFIED_1968_TYPE_1("IEEEModified1968Type1"),
    @XmlEnumValue("IEEE1981NewExcSystem")
    IEEE_1981_NEW_EXC_SYSTEM("IEEE1981NewExcSystem"),
    @XmlEnumValue("IEEETypeDC2")
    IEEE_TYPE_DC_2("IEEETypeDC2");
    private final String value;

    ExciterEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExciterEnumType fromValue(String v) {
        for (ExciterEnumType c: ExciterEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
