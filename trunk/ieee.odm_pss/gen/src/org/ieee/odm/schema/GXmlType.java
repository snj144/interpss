//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.26 at 02:44:35 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="g" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="unit" use="required" type="{http://www.ieee.org/odm/Schema/2008}YUnitType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GXmlType")
public class GXmlType {

    @XmlAttribute(required = true)
    protected double g;
    @XmlAttribute(required = true)
    protected YUnitType unit;

    /**
     * Gets the value of the g property.
     * 
     */
    public double getG() {
        return g;
    }

    /**
     * Sets the value of the g property.
     * 
     */
    public void setG(double value) {
        this.g = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link YUnitType }
     *     
     */
    public YUnitType getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link YUnitType }
     *     
     */
    public void setUnit(YUnitType value) {
        this.unit = value;
    }

}
