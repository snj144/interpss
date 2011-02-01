//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.31 at 09:52:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovSimpleTypeXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovSimpleTypeXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}GovernorModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="K" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="Pmax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Pmin" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovSimpleTypeXmlType", propOrder = {
    "k",
    "t1",
    "pmax",
    "pmin"
})
public class GovSimpleTypeXmlType
    extends GovernorModelXmlType
{

    @XmlElement(name = "K")
    protected double k;
    @XmlElement(name = "T1", required = true)
    protected TimePeriodXmlType t1;
    @XmlElement(name = "Pmax")
    protected double pmax;
    @XmlElement(name = "Pmin")
    protected double pmin;

    /**
     * Gets the value of the k property.
     * 
     */
    public double getK() {
        return k;
    }

    /**
     * Sets the value of the k property.
     * 
     */
    public void setK(double value) {
        this.k = value;
    }

    /**
     * Gets the value of the t1 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT1() {
        return t1;
    }

    /**
     * Sets the value of the t1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT1(TimePeriodXmlType value) {
        this.t1 = value;
    }

    /**
     * Gets the value of the pmax property.
     * 
     */
    public double getPmax() {
        return pmax;
    }

    /**
     * Sets the value of the pmax property.
     * 
     */
    public void setPmax(double value) {
        this.pmax = value;
    }

    /**
     * Gets the value of the pmin property.
     * 
     */
    public double getPmin() {
        return pmin;
    }

    /**
     * Sets the value of the pmin property.
     * 
     */
    public void setPmin(double value) {
        this.pmin = value;
    }

}
