//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.13 at 10:08:41 ���� CST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovBPAHydroTurbineGHXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovBPAHydroTurbineGHXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}GovIEEE1981Type3XmlType">
 *       &lt;sequence>
 *         &lt;element name="R" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Epsilon" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovBPAHydroTurbineGHXmlType", propOrder = {
    "r",
    "epsilon"
})
public class GovBPAHydroTurbineGHXmlType
    extends GovIEEE1981Type3XmlType
{

    @XmlElement(name = "R", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double r;
    @XmlElement(name = "Epsilon", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double epsilon;

    /**
     * Gets the value of the r property.
     * 
     */
    public double getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     */
    public void setR(double value) {
        this.r = value;
    }

    /**
     * Gets the value of the epsilon property.
     * 
     */
    public double getEpsilon() {
        return epsilon;
    }

    /**
     * Sets the value of the epsilon property.
     * 
     */
    public void setEpsilon(double value) {
        this.epsilon = value;
    }

}