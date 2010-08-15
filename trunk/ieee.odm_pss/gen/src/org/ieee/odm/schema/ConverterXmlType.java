//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.14 at 06:36:41 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConverterXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConverterXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="numberofBridges" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minFiringAngle" type="{http://www.ieee.org/odm/Schema/2008}AngleXmlType"/>
 *         &lt;element name="maxFiringAngle" type="{http://www.ieee.org/odm/Schema/2008}AngleXmlType"/>
 *         &lt;element name="firingAngleMeasuringBusId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="acSideRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType"/>
 *         &lt;element name="commutatingZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType"/>
 *         &lt;element name="commutatingCapacitor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="xformerTurnRatio" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="xformerTapSetting" type="{http://www.ieee.org/odm/Schema/2008}TapXmlType" minOccurs="0"/>
 *         &lt;element name="xformerTapLimit" type="{http://www.ieee.org/odm/Schema/2008}TapLimitXmlType" minOccurs="0"/>
 *         &lt;element name="xformerTapStepSize" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="dcSdieRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="refXfrFromBusId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="refXfrToBusId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="refXfrCirId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConverterXmlType", propOrder = {
    "busId",
    "numberofBridges",
    "minFiringAngle",
    "maxFiringAngle",
    "firingAngleMeasuringBusId",
    "acSideRatedVoltage",
    "commutatingZ",
    "commutatingCapacitor",
    "xformerTurnRatio",
    "xformerTapSetting",
    "xformerTapLimit",
    "xformerTapStepSize",
    "dcSdieRatedVoltage",
    "refXfrFromBusId",
    "refXfrToBusId",
    "refXfrCirId"
})
public class ConverterXmlType {

    @XmlElement(required = true)
    protected IDRefRecordXmlType busId;
    protected int numberofBridges;
    @XmlElement(required = true)
    protected AngleXmlType minFiringAngle;
    @XmlElement(required = true)
    protected AngleXmlType maxFiringAngle;
    protected IDRefRecordXmlType firingAngleMeasuringBusId;
    @XmlElement(required = true)
    protected VoltageXmlType acSideRatedVoltage;
    @XmlElement(required = true)
    protected ZXmlType commutatingZ;
    protected Double commutatingCapacitor;
    protected Double xformerTurnRatio;
    protected TapXmlType xformerTapSetting;
    protected TapLimitXmlType xformerTapLimit;
    protected Double xformerTapStepSize;
    protected VoltageXmlType dcSdieRatedVoltage;
    protected IDRefRecordXmlType refXfrFromBusId;
    protected IDRefRecordXmlType refXfrToBusId;
    protected String refXfrCirId;

    /**
     * Gets the value of the busId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getBusId() {
        return busId;
    }

    /**
     * Sets the value of the busId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setBusId(IDRefRecordXmlType value) {
        this.busId = value;
    }

    /**
     * Gets the value of the numberofBridges property.
     * 
     */
    public int getNumberofBridges() {
        return numberofBridges;
    }

    /**
     * Sets the value of the numberofBridges property.
     * 
     */
    public void setNumberofBridges(int value) {
        this.numberofBridges = value;
    }

    /**
     * Gets the value of the minFiringAngle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getMinFiringAngle() {
        return minFiringAngle;
    }

    /**
     * Sets the value of the minFiringAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setMinFiringAngle(AngleXmlType value) {
        this.minFiringAngle = value;
    }

    /**
     * Gets the value of the maxFiringAngle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getMaxFiringAngle() {
        return maxFiringAngle;
    }

    /**
     * Sets the value of the maxFiringAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setMaxFiringAngle(AngleXmlType value) {
        this.maxFiringAngle = value;
    }

    /**
     * Gets the value of the firingAngleMeasuringBusId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getFiringAngleMeasuringBusId() {
        return firingAngleMeasuringBusId;
    }

    /**
     * Sets the value of the firingAngleMeasuringBusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setFiringAngleMeasuringBusId(IDRefRecordXmlType value) {
        this.firingAngleMeasuringBusId = value;
    }

    /**
     * Gets the value of the acSideRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getAcSideRatedVoltage() {
        return acSideRatedVoltage;
    }

    /**
     * Sets the value of the acSideRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setAcSideRatedVoltage(VoltageXmlType value) {
        this.acSideRatedVoltage = value;
    }

    /**
     * Gets the value of the commutatingZ property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getCommutatingZ() {
        return commutatingZ;
    }

    /**
     * Sets the value of the commutatingZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setCommutatingZ(ZXmlType value) {
        this.commutatingZ = value;
    }

    /**
     * Gets the value of the commutatingCapacitor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCommutatingCapacitor() {
        return commutatingCapacitor;
    }

    /**
     * Sets the value of the commutatingCapacitor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCommutatingCapacitor(Double value) {
        this.commutatingCapacitor = value;
    }

    /**
     * Gets the value of the xformerTurnRatio property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getXformerTurnRatio() {
        return xformerTurnRatio;
    }

    /**
     * Sets the value of the xformerTurnRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setXformerTurnRatio(Double value) {
        this.xformerTurnRatio = value;
    }

    /**
     * Gets the value of the xformerTapSetting property.
     * 
     * @return
     *     possible object is
     *     {@link TapXmlType }
     *     
     */
    public TapXmlType getXformerTapSetting() {
        return xformerTapSetting;
    }

    /**
     * Sets the value of the xformerTapSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link TapXmlType }
     *     
     */
    public void setXformerTapSetting(TapXmlType value) {
        this.xformerTapSetting = value;
    }

    /**
     * Gets the value of the xformerTapLimit property.
     * 
     * @return
     *     possible object is
     *     {@link TapLimitXmlType }
     *     
     */
    public TapLimitXmlType getXformerTapLimit() {
        return xformerTapLimit;
    }

    /**
     * Sets the value of the xformerTapLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TapLimitXmlType }
     *     
     */
    public void setXformerTapLimit(TapLimitXmlType value) {
        this.xformerTapLimit = value;
    }

    /**
     * Gets the value of the xformerTapStepSize property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getXformerTapStepSize() {
        return xformerTapStepSize;
    }

    /**
     * Sets the value of the xformerTapStepSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setXformerTapStepSize(Double value) {
        this.xformerTapStepSize = value;
    }

    /**
     * Gets the value of the dcSdieRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getDcSdieRatedVoltage() {
        return dcSdieRatedVoltage;
    }

    /**
     * Sets the value of the dcSdieRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setDcSdieRatedVoltage(VoltageXmlType value) {
        this.dcSdieRatedVoltage = value;
    }

    /**
     * Gets the value of the refXfrFromBusId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRefXfrFromBusId() {
        return refXfrFromBusId;
    }

    /**
     * Sets the value of the refXfrFromBusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRefXfrFromBusId(IDRefRecordXmlType value) {
        this.refXfrFromBusId = value;
    }

    /**
     * Gets the value of the refXfrToBusId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRefXfrToBusId() {
        return refXfrToBusId;
    }

    /**
     * Sets the value of the refXfrToBusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRefXfrToBusId(IDRefRecordXmlType value) {
        this.refXfrToBusId = value;
    }

    /**
     * Gets the value of the refXfrCirId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefXfrCirId() {
        return refXfrCirId;
    }

    /**
     * Sets the value of the refXfrCirId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefXfrCirId(String value) {
        this.refXfrCirId = value;
    }

}
