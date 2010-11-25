//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.24 at 04:45:37 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovernorModelXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovernorModelXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basePower" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerXmlType" minOccurs="0"/>
 *         &lt;element ref="{http://www.ieee.org/odm/Schema/2008}turbine" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovernorModelXmlType", propOrder = {
    "name",
    "desc",
    "basePower",
    "turbine"
})
@XmlSeeAlso({
    GovSteamNRXmlType.class,
    GovSimpleTypeXmlType.class,
    GovHydroXmlType.class,
    GovHydroTurbineXmlType.class,
    GovIEEE1981Type3XmlType.class,
    GovIEEE1981Type1XmlType.class,
    GovIEEE1981Type2XmlType.class,
    GovHydroSteamGeneralModelXmlType.class
})
public abstract class GovernorModelXmlType {

    @XmlElement(required = true)
    protected String name;
    protected String desc;
    protected ApparentPowerXmlType basePower;
    protected TurbineModelXmlType turbine;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the basePower property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getBasePower() {
        return basePower;
    }

    /**
     * Sets the value of the basePower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setBasePower(ApparentPowerXmlType value) {
        this.basePower = value;
    }

    /**
     * Gets the value of the turbine property.
     * 
     * @return
     *     possible object is
     *     {@link TurbineModelXmlType }
     *     
     */
    public TurbineModelXmlType getTurbine() {
        return turbine;
    }

    /**
     * Sets the value of the turbine property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurbineModelXmlType }
     *     
     */
    public void setTurbine(TurbineModelXmlType value) {
        this.turbine = value;
    }

}
