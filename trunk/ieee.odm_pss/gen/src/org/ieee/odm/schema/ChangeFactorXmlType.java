//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.16 at 12:21:47 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChangeFactorXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeFactorXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="factor" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="unit" type="{http://www.ieee.org/odm/Schema/2008}FactorUnitType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeFactorXmlType", propOrder = {
    "factor",
    "unit"
})
public class ChangeFactorXmlType {

    protected double factor;
    protected FactorUnitType unit;

    /**
     * Gets the value of the factor property.
     * 
     */
    public double getFactor() {
        return factor;
    }

    /**
     * Sets the value of the factor property.
     * 
     */
    public void setFactor(double value) {
        this.factor = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link FactorUnitType }
     *     
     */
    public FactorUnitType getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link FactorUnitType }
     *     
     */
    public void setUnit(FactorUnitType value) {
        this.unit = value;
    }

}
