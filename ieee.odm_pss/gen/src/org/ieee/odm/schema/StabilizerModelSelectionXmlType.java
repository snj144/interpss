//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.01 at 07:21:18 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StabilizerModelSelectionXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StabilizerModelSelectionXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="IEEE1981Type" type="{http://www.ieee.org/odm/Schema/2008}PssIEEE1981TypeXmlType" minOccurs="0"/>
 *         &lt;element name="IEEE1992Type2A" type="{http://www.ieee.org/odm/Schema/2008}PssIEEE1992Type2AXmlType" minOccurs="0"/>
 *         &lt;element name="IEEEPSS1A" type="{http://www.ieee.org/odm/Schema/2008}PssIeeePss1AXmlType" minOccurs="0"/>
 *         &lt;element name="IEE2ST" type="{http://www.ieee.org/odm/Schema/2008}PssIEE2STXmlType" minOccurs="0"/>
 *         &lt;element name="IEEEDualInput" type="{http://www.ieee.org/odm/Schema/2008}PssIEEEDualInputXmlType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StabilizerModelSelectionXmlType", propOrder = {
    "ieee1981Type",
    "ieee1992Type2A",
    "ieeepss1A",
    "iee2ST",
    "ieeeDualInput"
})
public class StabilizerModelSelectionXmlType {

    @XmlElement(name = "IEEE1981Type")
    protected PssIEEE1981TypeXmlType ieee1981Type;
    @XmlElement(name = "IEEE1992Type2A")
    protected PssIEEE1992Type2AXmlType ieee1992Type2A;
    @XmlElement(name = "IEEEPSS1A")
    protected PssIeeePss1AXmlType ieeepss1A;
    @XmlElement(name = "IEE2ST")
    protected PssIEE2STXmlType iee2ST;
    @XmlElement(name = "IEEEDualInput")
    protected PssIEEEDualInputXmlType ieeeDualInput;

    /**
     * Gets the value of the ieee1981Type property.
     * 
     * @return
     *     possible object is
     *     {@link PssIEEE1981TypeXmlType }
     *     
     */
    public PssIEEE1981TypeXmlType getIEEE1981Type() {
        return ieee1981Type;
    }

    /**
     * Sets the value of the ieee1981Type property.
     * 
     * @param value
     *     allowed object is
     *     {@link PssIEEE1981TypeXmlType }
     *     
     */
    public void setIEEE1981Type(PssIEEE1981TypeXmlType value) {
        this.ieee1981Type = value;
    }

    /**
     * Gets the value of the ieee1992Type2A property.
     * 
     * @return
     *     possible object is
     *     {@link PssIEEE1992Type2AXmlType }
     *     
     */
    public PssIEEE1992Type2AXmlType getIEEE1992Type2A() {
        return ieee1992Type2A;
    }

    /**
     * Sets the value of the ieee1992Type2A property.
     * 
     * @param value
     *     allowed object is
     *     {@link PssIEEE1992Type2AXmlType }
     *     
     */
    public void setIEEE1992Type2A(PssIEEE1992Type2AXmlType value) {
        this.ieee1992Type2A = value;
    }

    /**
     * Gets the value of the ieeepss1A property.
     * 
     * @return
     *     possible object is
     *     {@link PssIeeePss1AXmlType }
     *     
     */
    public PssIeeePss1AXmlType getIEEEPSS1A() {
        return ieeepss1A;
    }

    /**
     * Sets the value of the ieeepss1A property.
     * 
     * @param value
     *     allowed object is
     *     {@link PssIeeePss1AXmlType }
     *     
     */
    public void setIEEEPSS1A(PssIeeePss1AXmlType value) {
        this.ieeepss1A = value;
    }

    /**
     * Gets the value of the iee2ST property.
     * 
     * @return
     *     possible object is
     *     {@link PssIEE2STXmlType }
     *     
     */
    public PssIEE2STXmlType getIEE2ST() {
        return iee2ST;
    }

    /**
     * Sets the value of the iee2ST property.
     * 
     * @param value
     *     allowed object is
     *     {@link PssIEE2STXmlType }
     *     
     */
    public void setIEE2ST(PssIEE2STXmlType value) {
        this.iee2ST = value;
    }

    /**
     * Gets the value of the ieeeDualInput property.
     * 
     * @return
     *     possible object is
     *     {@link PssIEEEDualInputXmlType }
     *     
     */
    public PssIEEEDualInputXmlType getIEEEDualInput() {
        return ieeeDualInput;
    }

    /**
     * Sets the value of the ieeeDualInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link PssIEEEDualInputXmlType }
     *     
     */
    public void setIEEEDualInput(PssIEEEDualInputXmlType value) {
        this.ieeeDualInput = value;
    }

}