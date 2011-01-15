//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.09 at 02:27:16 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicLoadComplexLoadXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicLoadComplexLoadXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="modelDesc" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadEnumType" minOccurs="0"/>
 *         &lt;element name="largeMotPercent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="smallMotPercent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="transExcCurPercent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dischLightingPercent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="constPowerPercent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="remainPercent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="branchR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="branchX" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DynamicLoadComplexLoadXmlType", propOrder = {
    "modelDesc",
    "largeMotPercent",
    "smallMotPercent",
    "transExcCurPercent",
    "dischLightingPercent",
    "constPowerPercent",
    "remainPercent",
    "branchR",
    "branchX"
})
public class DynamicLoadComplexLoadXmlType {

    protected DynamicLoadEnumType modelDesc;
    protected double largeMotPercent;
    protected double smallMotPercent;
    protected double transExcCurPercent;
    protected double dischLightingPercent;
    protected double constPowerPercent;
    protected double remainPercent;
    @XmlElement(required = true)
    protected String branchR;
    @XmlElement(required = true)
    protected String branchX;

    /**
     * Gets the value of the modelDesc property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicLoadEnumType }
     *     
     */
    public DynamicLoadEnumType getModelDesc() {
        return modelDesc;
    }

    /**
     * Sets the value of the modelDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicLoadEnumType }
     *     
     */
    public void setModelDesc(DynamicLoadEnumType value) {
        this.modelDesc = value;
    }

    /**
     * Gets the value of the largeMotPercent property.
     * 
     */
    public double getLargeMotPercent() {
        return largeMotPercent;
    }

    /**
     * Sets the value of the largeMotPercent property.
     * 
     */
    public void setLargeMotPercent(double value) {
        this.largeMotPercent = value;
    }

    /**
     * Gets the value of the smallMotPercent property.
     * 
     */
    public double getSmallMotPercent() {
        return smallMotPercent;
    }

    /**
     * Sets the value of the smallMotPercent property.
     * 
     */
    public void setSmallMotPercent(double value) {
        this.smallMotPercent = value;
    }

    /**
     * Gets the value of the transExcCurPercent property.
     * 
     */
    public double getTransExcCurPercent() {
        return transExcCurPercent;
    }

    /**
     * Sets the value of the transExcCurPercent property.
     * 
     */
    public void setTransExcCurPercent(double value) {
        this.transExcCurPercent = value;
    }

    /**
     * Gets the value of the dischLightingPercent property.
     * 
     */
    public double getDischLightingPercent() {
        return dischLightingPercent;
    }

    /**
     * Sets the value of the dischLightingPercent property.
     * 
     */
    public void setDischLightingPercent(double value) {
        this.dischLightingPercent = value;
    }

    /**
     * Gets the value of the constPowerPercent property.
     * 
     */
    public double getConstPowerPercent() {
        return constPowerPercent;
    }

    /**
     * Sets the value of the constPowerPercent property.
     * 
     */
    public void setConstPowerPercent(double value) {
        this.constPowerPercent = value;
    }

    /**
     * Gets the value of the remainPercent property.
     * 
     */
    public double getRemainPercent() {
        return remainPercent;
    }

    /**
     * Sets the value of the remainPercent property.
     * 
     */
    public void setRemainPercent(double value) {
        this.remainPercent = value;
    }

    /**
     * Gets the value of the branchR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchR() {
        return branchR;
    }

    /**
     * Sets the value of the branchR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchR(String value) {
        this.branchR = value;
    }

    /**
     * Gets the value of the branchX property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchX() {
        return branchX;
    }

    /**
     * Sets the value of the branchX property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchX(String value) {
        this.branchX = value;
    }

}
