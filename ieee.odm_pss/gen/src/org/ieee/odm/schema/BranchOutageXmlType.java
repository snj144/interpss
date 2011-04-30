//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.29 at 11:34:17 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BranchOutageXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BranchOutageXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="faultCategory" type="{http://www.ieee.org/odm/Schema/2008}AcscFaultCategoryEnumType" minOccurs="0"/>
 *         &lt;element name="fromBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="toBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="cirId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="startTime" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchOutageXmlType", propOrder = {
    "faultCategory",
    "fromBus",
    "toBus",
    "cirId",
    "startTime"
})
public class BranchOutageXmlType {

    protected AcscFaultCategoryEnumType faultCategory;
    @XmlElement(required = true)
    protected IDRefRecordXmlType fromBus;
    @XmlElement(required = true)
    protected IDRefRecordXmlType toBus;
    protected List<String> cirId;
    @XmlElement(required = true)
    protected TimePeriodXmlType startTime;

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
     * Gets the value of the fromBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getFromBus() {
        return fromBus;
    }

    /**
     * Sets the value of the fromBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setFromBus(IDRefRecordXmlType value) {
        this.fromBus = value;
    }

    /**
     * Gets the value of the toBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getToBus() {
        return toBus;
    }

    /**
     * Sets the value of the toBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setToBus(IDRefRecordXmlType value) {
        this.toBus = value;
    }

    /**
     * Gets the value of the cirId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cirId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCirId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCirId() {
        if (cirId == null) {
            cirId = new ArrayList<String>();
        }
        return this.cirId;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setStartTime(TimePeriodXmlType value) {
        this.startTime = value;
    }

}
