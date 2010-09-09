//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.09 at 02:24:39 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DcLineFaultXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DcLineFaultXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromACBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="toACBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="fromACRatedVol" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="toACRatedVol" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="faultType" type="{http://www.ieee.org/odm/Schema/2008}DcLineFaultEnumType"/>
 *         &lt;element name="startTime" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="durationTime" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *         &lt;element name="permanentFault" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="faultLocationFromFromSide" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="changedPower" type="{http://www.ieee.org/odm/Schema/2008}PowerXmlType" minOccurs="0"/>
 *         &lt;element name="changedCurrent" type="{http://www.ieee.org/odm/Schema/2008}CurrentXmlType" minOccurs="0"/>
 *         &lt;element name="faultZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DcLineFaultXmlType", propOrder = {
    "fromACBus",
    "toACBus",
    "fromACRatedVol",
    "toACRatedVol",
    "faultType",
    "startTime",
    "durationTime",
    "permanentFault",
    "faultLocationFromFromSide",
    "changedPower",
    "changedCurrent",
    "faultZ"
})
public class DcLineFaultXmlType {

    @XmlElement(required = true)
    protected IDRefRecordXmlType fromACBus;
    @XmlElement(required = true)
    protected IDRefRecordXmlType toACBus;
    protected VoltageXmlType fromACRatedVol;
    protected VoltageXmlType toACRatedVol;
    @XmlElement(required = true)
    protected DcLineFaultEnumType faultType;
    @XmlElement(required = true)
    protected TimePeriodXmlType startTime;
    protected TimePeriodXmlType durationTime;
    protected Boolean permanentFault;
    protected Double faultLocationFromFromSide;
    protected PowerXmlType changedPower;
    protected CurrentXmlType changedCurrent;
    protected ZXmlType faultZ;

    /**
     * Gets the value of the fromACBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getFromACBus() {
        return fromACBus;
    }

    /**
     * Sets the value of the fromACBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setFromACBus(IDRefRecordXmlType value) {
        this.fromACBus = value;
    }

    /**
     * Gets the value of the toACBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getToACBus() {
        return toACBus;
    }

    /**
     * Sets the value of the toACBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setToACBus(IDRefRecordXmlType value) {
        this.toACBus = value;
    }

    /**
     * Gets the value of the fromACRatedVol property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getFromACRatedVol() {
        return fromACRatedVol;
    }

    /**
     * Sets the value of the fromACRatedVol property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setFromACRatedVol(VoltageXmlType value) {
        this.fromACRatedVol = value;
    }

    /**
     * Gets the value of the toACRatedVol property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getToACRatedVol() {
        return toACRatedVol;
    }

    /**
     * Sets the value of the toACRatedVol property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setToACRatedVol(VoltageXmlType value) {
        this.toACRatedVol = value;
    }

    /**
     * Gets the value of the faultType property.
     * 
     * @return
     *     possible object is
     *     {@link DcLineFaultEnumType }
     *     
     */
    public DcLineFaultEnumType getFaultType() {
        return faultType;
    }

    /**
     * Sets the value of the faultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcLineFaultEnumType }
     *     
     */
    public void setFaultType(DcLineFaultEnumType value) {
        this.faultType = value;
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

    /**
     * Gets the value of the durationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getDurationTime() {
        return durationTime;
    }

    /**
     * Sets the value of the durationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setDurationTime(TimePeriodXmlType value) {
        this.durationTime = value;
    }

    /**
     * Gets the value of the permanentFault property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPermanentFault() {
        return permanentFault;
    }

    /**
     * Sets the value of the permanentFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPermanentFault(Boolean value) {
        this.permanentFault = value;
    }

    /**
     * Gets the value of the faultLocationFromFromSide property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFaultLocationFromFromSide() {
        return faultLocationFromFromSide;
    }

    /**
     * Sets the value of the faultLocationFromFromSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFaultLocationFromFromSide(Double value) {
        this.faultLocationFromFromSide = value;
    }

    /**
     * Gets the value of the changedPower property.
     * 
     * @return
     *     possible object is
     *     {@link PowerXmlType }
     *     
     */
    public PowerXmlType getChangedPower() {
        return changedPower;
    }

    /**
     * Sets the value of the changedPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerXmlType }
     *     
     */
    public void setChangedPower(PowerXmlType value) {
        this.changedPower = value;
    }

    /**
     * Gets the value of the changedCurrent property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentXmlType }
     *     
     */
    public CurrentXmlType getChangedCurrent() {
        return changedCurrent;
    }

    /**
     * Sets the value of the changedCurrent property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentXmlType }
     *     
     */
    public void setChangedCurrent(CurrentXmlType value) {
        this.changedCurrent = value;
    }

    /**
     * Gets the value of the faultZ property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getFaultZ() {
        return faultZ;
    }

    /**
     * Sets the value of the faultZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setFaultZ(ZXmlType value) {
        this.faultZ = value;
    }

}
