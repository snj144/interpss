//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.10 at 08:49:57 PM GMT-05:00 
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
 *         &lt;element name="faultType" type="{http://www.ieee.org/odm/Schema/2008}AcscFaultTypeEnumType"/>
 *         &lt;element name="faultCategory" type="{http://www.ieee.org/odm/Schema/2008}AcscFaultCategoryEnumType"/>
 *         &lt;element name="refBusBranch" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="zLG" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="zLL" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="branchReclosure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reclosureTime" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
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
    "refBusBranch",
    "zlg",
    "zll",
    "distance",
    "branchReclosure",
    "reclosureTime"
})
public class AcscFaultXmlType {

    @XmlElement(required = true)
    protected AcscFaultTypeEnumType faultType;
    @XmlElement(required = true)
    protected AcscFaultCategoryEnumType faultCategory;
    @XmlElement(required = true)
    protected IDRefRecordXmlType refBusBranch;
    @XmlElement(name = "zLG")
    protected ZXmlType zlg;
    @XmlElement(name = "zLL")
    protected ZXmlType zll;
    protected Double distance;
    protected Boolean branchReclosure;
    protected TimePeriodXmlType reclosureTime;

    /**
     * Gets the value of the faultType property.
     * 
     * @return
     *     possible object is
     *     {@link AcscFaultTypeEnumType }
     *     
     */
    public AcscFaultTypeEnumType getFaultType() {
        return faultType;
    }

    /**
     * Sets the value of the faultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcscFaultTypeEnumType }
     *     
     */
    public void setFaultType(AcscFaultTypeEnumType value) {
        this.faultType = value;
    }

    /**
     * Gets the value of the faultCategory property.
     * 
     * @return
     *     possible object is
     *     {@link AcscFaultCategoryEnumType }
     *     
     */
    public AcscFaultCategoryEnumType getFaultCategory() {
        return faultCategory;
    }

    /**
     * Sets the value of the faultCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcscFaultCategoryEnumType }
     *     
     */
    public void setFaultCategory(AcscFaultCategoryEnumType value) {
        this.faultCategory = value;
    }

    /**
     * Gets the value of the refBusBranch property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRefBusBranch() {
        return refBusBranch;
    }

    /**
     * Sets the value of the refBusBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRefBusBranch(IDRefRecordXmlType value) {
        this.refBusBranch = value;
    }

    /**
     * Gets the value of the zlg property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZLG() {
        return zlg;
    }

    /**
     * Sets the value of the zlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZLG(ZXmlType value) {
        this.zlg = value;
    }

    /**
     * Gets the value of the zll property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZLL() {
        return zll;
    }

    /**
     * Sets the value of the zll property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZLL(ZXmlType value) {
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
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getReclosureTime() {
        return reclosureTime;
    }

    /**
     * Sets the value of the reclosureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setReclosureTime(TimePeriodXmlType value) {
        this.reclosureTime = value;
    }

}
