//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.29 at 07:02:33 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovSteamNRXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovSteamNRXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}GovernorModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="K" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T2" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T3" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="PMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Pup" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Pdown" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TCH" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovSteamNRXmlType", propOrder = {
    "k",
    "t1",
    "t2",
    "t3",
    "pmax",
    "pmin",
    "pup",
    "pdown",
    "tch"
})
@XmlSeeAlso({
    GovSteamTDSRXmlType.class,
    GovSteamTCSRXmlType.class
})
public class GovSteamNRXmlType
    extends GovernorModelXmlType
{

    @XmlElement(name = "K")
    protected double k;
    @XmlElement(name = "T1", required = true)
    protected TimePeriodXmlType t1;
    @XmlElement(name = "T2", required = true)
    protected TimePeriodXmlType t2;
    @XmlElement(name = "T3", required = true)
    protected TimePeriodXmlType t3;
    @XmlElement(name = "PMAX")
    protected double pmax;
    @XmlElement(name = "PMIN")
    protected double pmin;
    @XmlElement(name = "Pup")
    protected double pup;
    @XmlElement(name = "Pdown")
    protected double pdown;
    @XmlElement(name = "TCH", required = true)
    protected TimePeriodXmlType tch;

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
     * Gets the value of the t2 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT2() {
        return t2;
    }

    /**
     * Sets the value of the t2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT2(TimePeriodXmlType value) {
        this.t2 = value;
    }

    /**
     * Gets the value of the t3 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT3() {
        return t3;
    }

    /**
     * Sets the value of the t3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT3(TimePeriodXmlType value) {
        this.t3 = value;
    }

    /**
     * Gets the value of the pmax property.
     * 
     */
    public double getPMAX() {
        return pmax;
    }

    /**
     * Sets the value of the pmax property.
     * 
     */
    public void setPMAX(double value) {
        this.pmax = value;
    }

    /**
     * Gets the value of the pmin property.
     * 
     */
    public double getPMIN() {
        return pmin;
    }

    /**
     * Sets the value of the pmin property.
     * 
     */
    public void setPMIN(double value) {
        this.pmin = value;
    }

    /**
     * Gets the value of the pup property.
     * 
     */
    public double getPup() {
        return pup;
    }

    /**
     * Sets the value of the pup property.
     * 
     */
    public void setPup(double value) {
        this.pup = value;
    }

    /**
     * Gets the value of the pdown property.
     * 
     */
    public double getPdown() {
        return pdown;
    }

    /**
     * Sets the value of the pdown property.
     * 
     */
    public void setPdown(double value) {
        this.pdown = value;
    }

    /**
     * Gets the value of the tch property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTCH() {
        return tch;
    }

    /**
     * Sets the value of the tch property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTCH(TimePeriodXmlType value) {
        this.tch = value;
    }

}
