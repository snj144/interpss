//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.13 at 10:08:41 ���� CST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for GeneratorEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GeneratorEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EquivGenUnit"/>
 *     &lt;enumeration value="Classical"/>
 *     &lt;enumeration value="Transient"/>
 *     &lt;enumeration value="SubTransient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum GeneratorEnumType {

    @XmlEnumValue("Classical")
    CLASSICAL("Classical"),
    @XmlEnumValue("EquivGenUnit")
    EQUIV_GEN_UNIT("EquivGenUnit"),
    @XmlEnumValue("SubTransient")
    SUB_TRANSIENT("SubTransient"),
    @XmlEnumValue("Transient")
    TRANSIENT("Transient");
    private final String value;

    GeneratorEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GeneratorEnumType fromValue(String v) {
        for (GeneratorEnumType c: GeneratorEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
