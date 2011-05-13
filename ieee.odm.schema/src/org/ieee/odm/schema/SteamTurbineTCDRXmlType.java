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
 * <p>Java class for SteamTurbineTCDRXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SteamTurbineTCDRXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}SteamTurbineNRXmlType">
 *       &lt;sequence>
 *         &lt;element name="FVHP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="TRH1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="FHP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="TRH2" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
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
@XmlType(name = "SteamTurbineTCDRXmlType", propOrder = {
    "fvhp",
    "trh1",
    "fhp",
    "trh2",
    "fip",
    "tco",
    "flp"
})
public class SteamTurbineTCDRXmlType
    extends SteamTurbineNRXmlType
{

    @XmlElement(name = "FVHP", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double fvhp;
    @XmlElement(name = "TRH1", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected TimePeriodXmlType trh1;
    @XmlElement(name = "FHP", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double fhp;
    @XmlElement(name = "TRH2", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected TimePeriodXmlType trh2;
    @XmlElement(name = "FIP", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double fip;
    @XmlElement(name = "TCO", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected TimePeriodXmlType tco;
    @XmlElement(name = "FLP", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double flp;

    /**
     * Gets the value of the fvhp property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFVHP() {
        return fvhp;
    }

    /**
     * Sets the value of the fvhp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFVHP(Double value) {
        this.fvhp = value;
    }

    /**
     * Gets the value of the trh1 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTRH1() {
        return trh1;
    }

    /**
     * Sets the value of the trh1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTRH1(TimePeriodXmlType value) {
        this.trh1 = value;
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
     * Gets the value of the trh2 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTRH2() {
        return trh2;
    }

    /**
     * Sets the value of the trh2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTRH2(TimePeriodXmlType value) {
        this.trh2 = value;
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
