//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.11 at 02:43:09 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TapAdjustmentXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TapAdjustmentXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adjustmentType" type="{http://www.ieee.org/odm/Schema/2008}TapAdjustmentEnumType"/>
 *         &lt;element name="tapLimit" type="{http://www.ieee.org/odm/Schema/2008}TapLimitXmlType"/>
 *         &lt;element name="tapAdjStepSize" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tapAdjStep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tapAdjOnFromSide" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;sequence>
 *           &lt;choice>
 *             &lt;element name="voltageAdjData" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;extension base="{http://www.ieee.org/odm/Schema/2008}AdjustmentDataXmlType">
 *                     &lt;sequence>
 *                       &lt;element name="desiredVoltageUnit" type="{http://www.ieee.org/odm/Schema/2008}VoltageUnitType"/>
 *                       &lt;element name="adjVoltageBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *                       &lt;element name="adjBusLocation" type="{http://www.ieee.org/odm/Schema/2008}TapAdjustBusLocationEnumType"/>
 *                     &lt;/sequence>
 *                   &lt;/extension>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *             &lt;element name="mvarFlowAdjData" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;extension base="{http://www.ieee.org/odm/Schema/2008}AdjustmentDataXmlType">
 *                     &lt;sequence>
 *                       &lt;element name="desiredMvarFlowUnit" type="{http://www.ieee.org/odm/Schema/2008}ReactivePowerUnitType"/>
 *                       &lt;element name="mvarMeasuredOnFormSide" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;/sequence>
 *                   &lt;/extension>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *           &lt;/choice>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="offLine" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TapAdjustmentXmlType", propOrder = {
    "adjustmentType",
    "tapLimit",
    "tapAdjStepSize",
    "tapAdjStep",
    "tapAdjOnFromSide",
    "voltageAdjData",
    "mvarFlowAdjData"
})
public class TapAdjustmentXmlType {

    @XmlElement(required = true)
    protected TapAdjustmentEnumType adjustmentType;
    @XmlElement(required = true)
    protected TapLimitXmlType tapLimit;
    protected Double tapAdjStepSize;
    protected Integer tapAdjStep;
    protected boolean tapAdjOnFromSide;
    protected TapAdjustmentXmlType.VoltageAdjData voltageAdjData;
    protected TapAdjustmentXmlType.MvarFlowAdjData mvarFlowAdjData;
    @XmlAttribute(required = true)
    protected boolean offLine;

    /**
     * Gets the value of the adjustmentType property.
     * 
     * @return
     *     possible object is
     *     {@link TapAdjustmentEnumType }
     *     
     */
    public TapAdjustmentEnumType getAdjustmentType() {
        return adjustmentType;
    }

    /**
     * Sets the value of the adjustmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TapAdjustmentEnumType }
     *     
     */
    public void setAdjustmentType(TapAdjustmentEnumType value) {
        this.adjustmentType = value;
    }

    /**
     * Gets the value of the tapLimit property.
     * 
     * @return
     *     possible object is
     *     {@link TapLimitXmlType }
     *     
     */
    public TapLimitXmlType getTapLimit() {
        return tapLimit;
    }

    /**
     * Sets the value of the tapLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TapLimitXmlType }
     *     
     */
    public void setTapLimit(TapLimitXmlType value) {
        this.tapLimit = value;
    }

    /**
     * Gets the value of the tapAdjStepSize property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTapAdjStepSize() {
        return tapAdjStepSize;
    }

    /**
     * Sets the value of the tapAdjStepSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTapAdjStepSize(Double value) {
        this.tapAdjStepSize = value;
    }

    /**
     * Gets the value of the tapAdjStep property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTapAdjStep() {
        return tapAdjStep;
    }

    /**
     * Sets the value of the tapAdjStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTapAdjStep(Integer value) {
        this.tapAdjStep = value;
    }

    /**
     * Gets the value of the tapAdjOnFromSide property.
     * 
     */
    public boolean isTapAdjOnFromSide() {
        return tapAdjOnFromSide;
    }

    /**
     * Sets the value of the tapAdjOnFromSide property.
     * 
     */
    public void setTapAdjOnFromSide(boolean value) {
        this.tapAdjOnFromSide = value;
    }

    /**
     * Gets the value of the voltageAdjData property.
     * 
     * @return
     *     possible object is
     *     {@link TapAdjustmentXmlType.VoltageAdjData }
     *     
     */
    public TapAdjustmentXmlType.VoltageAdjData getVoltageAdjData() {
        return voltageAdjData;
    }

    /**
     * Sets the value of the voltageAdjData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TapAdjustmentXmlType.VoltageAdjData }
     *     
     */
    public void setVoltageAdjData(TapAdjustmentXmlType.VoltageAdjData value) {
        this.voltageAdjData = value;
    }

    /**
     * Gets the value of the mvarFlowAdjData property.
     * 
     * @return
     *     possible object is
     *     {@link TapAdjustmentXmlType.MvarFlowAdjData }
     *     
     */
    public TapAdjustmentXmlType.MvarFlowAdjData getMvarFlowAdjData() {
        return mvarFlowAdjData;
    }

    /**
     * Sets the value of the mvarFlowAdjData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TapAdjustmentXmlType.MvarFlowAdjData }
     *     
     */
    public void setMvarFlowAdjData(TapAdjustmentXmlType.MvarFlowAdjData value) {
        this.mvarFlowAdjData = value;
    }

    /**
     * Gets the value of the offLine property.
     * 
     */
    public boolean isOffLine() {
        return offLine;
    }

    /**
     * Sets the value of the offLine property.
     * 
     */
    public void setOffLine(boolean value) {
        this.offLine = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}AdjustmentDataXmlType">
     *       &lt;sequence>
     *         &lt;element name="desiredMvarFlowUnit" type="{http://www.ieee.org/odm/Schema/2008}ReactivePowerUnitType"/>
     *         &lt;element name="mvarMeasuredOnFormSide" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "desiredMvarFlowUnit",
        "mvarMeasuredOnFormSide"
    })
    public static class MvarFlowAdjData
        extends AdjustmentDataXmlType
    {

        @XmlElement(required = true)
        protected ReactivePowerUnitType desiredMvarFlowUnit;
        protected boolean mvarMeasuredOnFormSide;

        /**
         * Gets the value of the desiredMvarFlowUnit property.
         * 
         * @return
         *     possible object is
         *     {@link ReactivePowerUnitType }
         *     
         */
        public ReactivePowerUnitType getDesiredMvarFlowUnit() {
            return desiredMvarFlowUnit;
        }

        /**
         * Sets the value of the desiredMvarFlowUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link ReactivePowerUnitType }
         *     
         */
        public void setDesiredMvarFlowUnit(ReactivePowerUnitType value) {
            this.desiredMvarFlowUnit = value;
        }

        /**
         * Gets the value of the mvarMeasuredOnFormSide property.
         * 
         */
        public boolean isMvarMeasuredOnFormSide() {
            return mvarMeasuredOnFormSide;
        }

        /**
         * Sets the value of the mvarMeasuredOnFormSide property.
         * 
         */
        public void setMvarMeasuredOnFormSide(boolean value) {
            this.mvarMeasuredOnFormSide = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}AdjustmentDataXmlType">
     *       &lt;sequence>
     *         &lt;element name="desiredVoltageUnit" type="{http://www.ieee.org/odm/Schema/2008}VoltageUnitType"/>
     *         &lt;element name="adjVoltageBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
     *         &lt;element name="adjBusLocation" type="{http://www.ieee.org/odm/Schema/2008}TapAdjustBusLocationEnumType"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "desiredVoltageUnit",
        "adjVoltageBus",
        "adjBusLocation"
    })
    public static class VoltageAdjData
        extends AdjustmentDataXmlType
    {

        @XmlElement(required = true)
        protected VoltageUnitType desiredVoltageUnit;
        @XmlElement(required = true)
        protected IDRefRecordXmlType adjVoltageBus;
        @XmlElement(required = true)
        protected TapAdjustBusLocationEnumType adjBusLocation;

        /**
         * Gets the value of the desiredVoltageUnit property.
         * 
         * @return
         *     possible object is
         *     {@link VoltageUnitType }
         *     
         */
        public VoltageUnitType getDesiredVoltageUnit() {
            return desiredVoltageUnit;
        }

        /**
         * Sets the value of the desiredVoltageUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link VoltageUnitType }
         *     
         */
        public void setDesiredVoltageUnit(VoltageUnitType value) {
            this.desiredVoltageUnit = value;
        }

        /**
         * Gets the value of the adjVoltageBus property.
         * 
         * @return
         *     possible object is
         *     {@link IDRefRecordXmlType }
         *     
         */
        public IDRefRecordXmlType getAdjVoltageBus() {
            return adjVoltageBus;
        }

        /**
         * Sets the value of the adjVoltageBus property.
         * 
         * @param value
         *     allowed object is
         *     {@link IDRefRecordXmlType }
         *     
         */
        public void setAdjVoltageBus(IDRefRecordXmlType value) {
            this.adjVoltageBus = value;
        }

        /**
         * Gets the value of the adjBusLocation property.
         * 
         * @return
         *     possible object is
         *     {@link TapAdjustBusLocationEnumType }
         *     
         */
        public TapAdjustBusLocationEnumType getAdjBusLocation() {
            return adjBusLocation;
        }

        /**
         * Sets the value of the adjBusLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link TapAdjustBusLocationEnumType }
         *     
         */
        public void setAdjBusLocation(TapAdjustBusLocationEnumType value) {
            this.adjBusLocation = value;
        }

    }

}