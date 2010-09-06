//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.05 at 07:56:06 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SteamTurbineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SteamTurbineXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}TurbineModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="K" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="TCH" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="FHP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="TRH" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="FIP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="TCO" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="FLP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SteamTurbineXmlType", propOrder = {
    "k",
    "tch",
    "fhp",
    "trh",
    "fip",
    "tco",
    "flp"
})
public class SteamTurbineXmlType
    extends TurbineModelXmlType
{

    @XmlElement(name = "K")
    protected Double k;
    @XmlElement(name = "TCH")
    protected TimePeriodXmlType tch;
    @XmlElement(name = "FHP")
    protected Double fhp;
    @XmlElement(name = "TRH")
    protected TimePeriodXmlType trh;
    @XmlElement(name = "FIP")
    protected Double fip;
    @XmlElement(name = "TCO")
    protected TimePeriodXmlType tco;
    @XmlElement(name = "FLP")
    protected Double flp;

    /**
     * Gets the value of the k property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getK() {
        return k;
    }

    /**
     * Sets the value of the k property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setK(Double value) {
        this.k = value;
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

    /**
     * Gets the value of the fhp property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFHP() {
        return fhp;
    }

    /**
     * Sets the value of the fhp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFHP(Double value) {
        this.fhp = value;
    }

    /**
     * Gets the value of the trh property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTRH() {
        return trh;
    }

    /**
     * Sets the value of the trh property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTRH(TimePeriodXmlType value) {
        this.trh = value;
    }

    /**
     * Gets the value of the fip property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFIP() {
        return fip;
    }

    /**
     * Sets the value of the fip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFIP(Double value) {
        this.fip = value;
    }

    /**
     * Gets the value of the tco property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTCO() {
        return tco;
    }

    /**
     * Sets the value of the tco property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTCO(TimePeriodXmlType value) {
        this.tco = value;
    }

    /**
     * Gets the value of the flp property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFLP() {
        return flp;
    }

    /**
     * Sets the value of the flp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFLP(Double value) {
        this.flp = value;
    }

}
