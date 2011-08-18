//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.11 at 10:09:39 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicLoadModelSelectionXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicLoadModelSelectionXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="IEEEStaticLoad" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadIEEEStaticLoadXmlType" minOccurs="0"/>
 *         &lt;element name="ComplexLoad" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadComplexLoadXmlType" minOccurs="0"/>
 *         &lt;element name="InductionMotor" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadInductionMotorXmlType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DynamicLoadModelSelectionXmlType", propOrder = {
    "ieeeStaticLoad",
    "complexLoad",
    "inductionMotor"
})
public class DynamicLoadModelSelectionXmlType {

    @XmlElement(name = "IEEEStaticLoad")
    protected DynamicLoadIEEEStaticLoadXmlType ieeeStaticLoad;
    @XmlElement(name = "ComplexLoad")
    protected DynamicLoadComplexLoadXmlType complexLoad;
    @XmlElement(name = "InductionMotor")
    protected DynamicLoadInductionMotorXmlType inductionMotor;

    /**
     * Gets the value of the ieeeStaticLoad property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicLoadIEEEStaticLoadXmlType }
     *     
     */
    public DynamicLoadIEEEStaticLoadXmlType getIEEEStaticLoad() {
        return ieeeStaticLoad;
    }

    /**
     * Sets the value of the ieeeStaticLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicLoadIEEEStaticLoadXmlType }
     *     
     */
    public void setIEEEStaticLoad(DynamicLoadIEEEStaticLoadXmlType value) {
        this.ieeeStaticLoad = value;
    }

    /**
     * Gets the value of the complexLoad property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicLoadComplexLoadXmlType }
     *     
     */
    public DynamicLoadComplexLoadXmlType getComplexLoad() {
        return complexLoad;
    }

    /**
     * Sets the value of the complexLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicLoadComplexLoadXmlType }
     *     
     */
    public void setComplexLoad(DynamicLoadComplexLoadXmlType value) {
        this.complexLoad = value;
    }

    /**
     * Gets the value of the inductionMotor property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicLoadInductionMotorXmlType }
     *     
     */
    public DynamicLoadInductionMotorXmlType getInductionMotor() {
        return inductionMotor;
    }

    /**
     * Sets the value of the inductionMotor property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicLoadInductionMotorXmlType }
     *     
     */
    public void setInductionMotor(DynamicLoadInductionMotorXmlType value) {
        this.inductionMotor = value;
    }

}
