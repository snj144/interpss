//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.03 at 11:11:57 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcscFaultXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcscFaultXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="faultType" type="{http://www.ieee.org/odm/Schema/2008}AcscFaultDataType"/>
 *         &lt;element name="faultCategory" type="{http://www.ieee.org/odm/Schema/2008}AcscFaultCategoryDataType"/>
 *         &lt;element name="busBranchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zLG" type="{http://www.ieee.org/odm/Schema/2008}ComplexXmlType" minOccurs="0"/>
 *         &lt;element name="zLL" type="{http://www.ieee.org/odm/Schema/2008}ComplexXmlType" minOccurs="0"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="branchReclosure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reclosureTime" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcscFaultXmlType", propOrder = {
    "faultType",
    "faultCategory",
    "busBranchId",
    "zlg",
    "zll",
    "distance",
    "branchReclosure",
    "reclosureTime"
})
public class AcscFaultXmlType {

    @XmlElement(required = true)
    protected AcscFaultDataType faultType;
    @XmlElement(required = true)
    protected AcscFaultCategoryDataType faultCategory;
    @XmlElement(required = true)
    protected String busBranchId;
    @XmlElement(name = "zLG")
    protected ComplexXmlType zlg;
    @XmlElement(name = "zLL")
    protected ComplexXmlType zll;
    protected Double distance;
    protected Boolean branchReclosure;
    protected Double reclosureTime;

    /**
     * Gets the value of the faultType property.
     * 
     * @return
     *     possible object is
     *     {@link AcscFaultDataType }
     *     
     */
    public AcscFaultDataType getFaultType() {
        return faultType;
    }

    /**
     * Sets the value of the faultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcscFaultDataType }
     *     
     */
    public void setFaultType(AcscFaultDataType value) {
        this.faultType = value;
    }

    /**
     * Gets the value of the faultCategory property.
     * 
     * @return
     *     possible object is
     *     {@link AcscFaultCategoryDataType }
     *     
     */
    public AcscFaultCategoryDataType getFaultCategory() {
        return faultCategory;
    }

    /**
     * Sets the value of the faultCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcscFaultCategoryDataType }
     *     
     */
    public void setFaultCategory(AcscFaultCategoryDataType value) {
        this.faultCategory = value;
    }

    /**
     * Gets the value of the busBranchId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusBranchId() {
        return busBranchId;
    }

    /**
     * Sets the value of the busBranchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusBranchId(String value) {
        this.busBranchId = value;
    }

    /**
     * Gets the value of the zlg property.
     * 
     * @return
     *     possible object is
     *     {@link ComplexXmlType }
     *     
     */
    public ComplexXmlType getZLG() {
        return zlg;
    }

    /**
     * Sets the value of the zlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexXmlType }
     *     
     */
    public void setZLG(ComplexXmlType value) {
        this.zlg = value;
    }

    /**
     * Gets the value of the zll property.
     * 
     * @return
     *     possible object is
     *     {@link ComplexXmlType }
     *     
     */
    public ComplexXmlType getZLL() {
        return zll;
    }

    /**
     * Sets the value of the zll property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexXmlType }
     *     
     */
    public void setZLL(ComplexXmlType value) {
        this.zll = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistance(Double value) {
        this.distance = value;
    }

    /**
     * Gets the value of the branchReclosure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBranchReclosure() {
        return branchReclosure;
    }

    /**
     * Sets the value of the branchReclosure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBranchReclosure(Boolean value) {
        this.branchReclosure = value;
    }

    /**
     * Gets the value of the reclosureTime property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getReclosureTime() {
        return reclosureTime;
    }

    /**
     * Sets the value of the reclosureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setReclosureTime(Double value) {
        this.reclosureTime = value;
    }

}
