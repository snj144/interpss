//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.25 at 10:50:56 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TurbineGovernorModelListXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TurbineGovernorModelListXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IEEE1981Type1" type="{http://www.ieee.org/odm/Schema/2008}GovIEEE1981Type1XmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1981Type2" type="{http://www.ieee.org/odm/Schema/2008}GovIEEE1981Type2XmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1981Type3" type="{http://www.ieee.org/odm/Schema/2008}GovIEEE1981Type3XmlType" minOccurs="0"/>
 *         &lt;element name="hydroStreamGeneralModel" type="{http://www.ieee.org/odm/Schema/2008}GovHydroSteamGeneralModelXmlType" minOccurs="0"/>
 *         &lt;element name="hydroGovernerAndTurbine" type="{http://www.ieee.org/odm/Schema/2008}GovHydroTurbineXmlType" minOccurs="0"/>
 *         &lt;element name="hydroGoverner" type="{http://www.ieee.org/odm/Schema/2008}GovHydroXmlType" minOccurs="0"/>
 *         &lt;element name="SteamNRModel" type="{http://www.ieee.org/odm/Schema/2008}GovSteamNRXmlType" minOccurs="0"/>
 *         &lt;element name="SteamTDSRModel" type="{http://www.ieee.org/odm/Schema/2008}GovSteamTDSRXmlType" minOccurs="0"/>
 *         &lt;element name="SteamTCSRModel" type="{http://www.ieee.org/odm/Schema/2008}GovSteamTCSRXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TurbineGovernorModelListXmlType", propOrder = {
    "ieee1981Type1",
    "ieee1981Type2",
    "ieee1981Type3",
    "hydroStreamGeneralModel",
    "hydroGovernerAndTurbine",
    "hydroGoverner",
    "steamNRModel",
    "steamTDSRModel",
    "steamTCSRModel"
})
public class TurbineGovernorModelListXmlType {

    @XmlElement(name = "IEEE1981Type1")
    protected GovIEEE1981Type1XmlType ieee1981Type1;
    @XmlElement(name = "IEEE1981Type2")
    protected GovIEEE1981Type2XmlType ieee1981Type2;
    @XmlElement(name = "IEEE1981Type3")
    protected GovIEEE1981Type3XmlType ieee1981Type3;
    protected GovHydroSteamGeneralModelXmlType hydroStreamGeneralModel;
    protected GovHydroTurbineXmlType hydroGovernerAndTurbine;
    protected GovHydroXmlType hydroGoverner;
    @XmlElement(name = "SteamNRModel")
    protected GovSteamNRXmlType steamNRModel;
    @XmlElement(name = "SteamTDSRModel")
    protected GovSteamTDSRXmlType steamTDSRModel;
    @XmlElement(name = "SteamTCSRModel")
    protected GovSteamTCSRXmlType steamTCSRModel;

    /**
     * Gets the value of the ieee1981Type1 property.
     * 
     * @return
     *     possible object is
     *     {@link GovIEEE1981Type1XmlType }
     *     
     */
    public GovIEEE1981Type1XmlType getIEEE1981Type1() {
        return ieee1981Type1;
    }

    /**
     * Sets the value of the ieee1981Type1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovIEEE1981Type1XmlType }
     *     
     */
    public void setIEEE1981Type1(GovIEEE1981Type1XmlType value) {
        this.ieee1981Type1 = value;
    }

    /**
     * Gets the value of the ieee1981Type2 property.
     * 
     * @return
     *     possible object is
     *     {@link GovIEEE1981Type2XmlType }
     *     
     */
    public GovIEEE1981Type2XmlType getIEEE1981Type2() {
        return ieee1981Type2;
    }

    /**
     * Sets the value of the ieee1981Type2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovIEEE1981Type2XmlType }
     *     
     */
    public void setIEEE1981Type2(GovIEEE1981Type2XmlType value) {
        this.ieee1981Type2 = value;
    }

    /**
     * Gets the value of the ieee1981Type3 property.
     * 
     * @return
     *     possible object is
     *     {@link GovIEEE1981Type3XmlType }
     *     
     */
    public GovIEEE1981Type3XmlType getIEEE1981Type3() {
        return ieee1981Type3;
    }

    /**
     * Sets the value of the ieee1981Type3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovIEEE1981Type3XmlType }
     *     
     */
    public void setIEEE1981Type3(GovIEEE1981Type3XmlType value) {
        this.ieee1981Type3 = value;
    }

    /**
     * Gets the value of the hydroStreamGeneralModel property.
     * 
     * @return
     *     possible object is
     *     {@link GovHydroSteamGeneralModelXmlType }
     *     
     */
    public GovHydroSteamGeneralModelXmlType getHydroStreamGeneralModel() {
        return hydroStreamGeneralModel;
    }

    /**
     * Sets the value of the hydroStreamGeneralModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovHydroSteamGeneralModelXmlType }
     *     
     */
    public void setHydroStreamGeneralModel(GovHydroSteamGeneralModelXmlType value) {
        this.hydroStreamGeneralModel = value;
    }

    /**
     * Gets the value of the hydroGovernerAndTurbine property.
     * 
     * @return
     *     possible object is
     *     {@link GovHydroTurbineXmlType }
     *     
     */
    public GovHydroTurbineXmlType getHydroGovernerAndTurbine() {
        return hydroGovernerAndTurbine;
    }

    /**
     * Sets the value of the hydroGovernerAndTurbine property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovHydroTurbineXmlType }
     *     
     */
    public void setHydroGovernerAndTurbine(GovHydroTurbineXmlType value) {
        this.hydroGovernerAndTurbine = value;
    }

    /**
     * Gets the value of the hydroGoverner property.
     * 
     * @return
     *     possible object is
     *     {@link GovHydroXmlType }
     *     
     */
    public GovHydroXmlType getHydroGoverner() {
        return hydroGoverner;
    }

    /**
     * Sets the value of the hydroGoverner property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovHydroXmlType }
     *     
     */
    public void setHydroGoverner(GovHydroXmlType value) {
        this.hydroGoverner = value;
    }

    /**
     * Gets the value of the steamNRModel property.
     * 
     * @return
     *     possible object is
     *     {@link GovSteamNRXmlType }
     *     
     */
    public GovSteamNRXmlType getSteamNRModel() {
        return steamNRModel;
    }

    /**
     * Sets the value of the steamNRModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovSteamNRXmlType }
     *     
     */
    public void setSteamNRModel(GovSteamNRXmlType value) {
        this.steamNRModel = value;
    }

    /**
     * Gets the value of the steamTDSRModel property.
     * 
     * @return
     *     possible object is
     *     {@link GovSteamTDSRXmlType }
     *     
     */
    public GovSteamTDSRXmlType getSteamTDSRModel() {
        return steamTDSRModel;
    }

    /**
     * Sets the value of the steamTDSRModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovSteamTDSRXmlType }
     *     
     */
    public void setSteamTDSRModel(GovSteamTDSRXmlType value) {
        this.steamTDSRModel = value;
    }

    /**
     * Gets the value of the steamTCSRModel property.
     * 
     * @return
     *     possible object is
     *     {@link GovSteamTCSRXmlType }
     *     
     */
    public GovSteamTCSRXmlType getSteamTCSRModel() {
        return steamTCSRModel;
    }

    /**
     * Sets the value of the steamTCSRModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovSteamTCSRXmlType }
     *     
     */
    public void setSteamTCSRModel(GovSteamTCSRXmlType value) {
        this.steamTCSRModel = value;
    }

}
