//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.21 at 12:23:41 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovSteamTCSRXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovSteamTCSRXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}GovSteamNRXmlType">
 *       &lt;sequence>
 *         &lt;element name="TRH" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="TCO" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="FCH" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="FIP" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="FLP" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovSteamTCSRXmlType", propOrder = {
    "trh",
    "tco",
    "fch",
    "fip",
    "flp"
})
public class GovSteamTCSRXmlType
    extends GovSteamNRXmlType
{

    @XmlElement(name = "TRH", required = true)
    protected TimePeriodXmlType trh;
    @XmlElement(name = "TCO", required = true)
    protected TimePeriodXmlType tco;
    @XmlElement(name = "FCH")
    protected double fch;
    @XmlElement(name = "FIP")
    protected double fip;
    @XmlElement(name = "FLP")
    protected double flp;

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
     * Gets the value of the fch property.
     * 
     */
    public double getFCH() {
        return fch;
    }

    /**
     * Sets the value of the fch property.
     * 
     */
    public void setFCH(double value) {
        this.fch = value;
    }

    /**
     * Gets the value of the fip property.
     * 
     */
    public double getFIP() {
        return fip;
    }

    /**
     * Sets the value of the fip property.
     * 
     */
    public void setFIP(double value) {
        this.fip = value;
    }

    /**
     * Gets the value of the flp property.
     * 
     */
    public double getFLP() {
        return flp;
    }

    /**
     * Sets the value of the flp property.
     * 
     */
    public void setFLP(double value) {
        this.flp = value;
    }

}
