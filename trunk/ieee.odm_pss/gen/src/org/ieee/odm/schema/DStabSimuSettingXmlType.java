//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.30 at 03:27:45 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DStabSimuSettingXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DStabSimuSettingXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dstabMethod" type="{http://www.ieee.org/odm/Schema/2008}DStabMethodEnumType"/>
 *         &lt;element name="totalTime" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="step" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="absMachineAngle" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="refMachine" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="netEqnSolveConfig" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="netEqnItrNoEvent" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="netEqnItrWithEvent" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="staticLoadModel" type="{http://www.ieee.org/odm/Schema/2008}StaticLoadModelXmlType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStabSimuSettingXmlType", propOrder = {
    "dstabMethod",
    "totalTime",
    "step",
    "absMachineAngle",
    "refMachine",
    "netEqnSolveConfig",
    "staticLoadModel"
})
public class DStabSimuSettingXmlType {

    @XmlElement(required = true)
    protected DStabMethodEnumType dstabMethod;
    @XmlElement(required = true)
    protected TimePeriodXmlType totalTime;
    @XmlElement(required = true)
    protected TimePeriodXmlType step;
    protected Boolean absMachineAngle;
    protected IDRefRecordXmlType refMachine;
    protected DStabSimuSettingXmlType.NetEqnSolveConfig netEqnSolveConfig;
    @XmlElement(required = true)
    protected StaticLoadModelXmlType staticLoadModel;

    /**
     * Gets the value of the dstabMethod property.
     * 
     * @return
     *     possible object is
     *     {@link DStabMethodEnumType }
     *     
     */
    public DStabMethodEnumType getDstabMethod() {
        return dstabMethod;
    }

    /**
     * Sets the value of the dstabMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link DStabMethodEnumType }
     *     
     */
    public void setDstabMethod(DStabMethodEnumType value) {
        this.dstabMethod = value;
    }

    /**
     * Gets the value of the totalTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTotalTime() {
        return totalTime;
    }

    /**
     * Sets the value of the totalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTotalTime(TimePeriodXmlType value) {
        this.totalTime = value;
    }

    /**
     * Gets the value of the step property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setStep(TimePeriodXmlType value) {
        this.step = value;
    }

    /**
     * Gets the value of the absMachineAngle property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAbsMachineAngle() {
        return absMachineAngle;
    }

    /**
     * Sets the value of the absMachineAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAbsMachineAngle(Boolean value) {
        this.absMachineAngle = value;
    }

    /**
     * Gets the value of the refMachine property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRefMachine() {
        return refMachine;
    }

    /**
     * Sets the value of the refMachine property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRefMachine(IDRefRecordXmlType value) {
        this.refMachine = value;
    }

    /**
     * Gets the value of the netEqnSolveConfig property.
     * 
     * @return
     *     possible object is
     *     {@link DStabSimuSettingXmlType.NetEqnSolveConfig }
     *     
     */
    public DStabSimuSettingXmlType.NetEqnSolveConfig getNetEqnSolveConfig() {
        return netEqnSolveConfig;
    }

    /**
     * Sets the value of the netEqnSolveConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link DStabSimuSettingXmlType.NetEqnSolveConfig }
     *     
     */
    public void setNetEqnSolveConfig(DStabSimuSettingXmlType.NetEqnSolveConfig value) {
        this.netEqnSolveConfig = value;
    }

    /**
     * Gets the value of the staticLoadModel property.
     * 
     * @return
     *     possible object is
     *     {@link StaticLoadModelXmlType }
     *     
     */
    public StaticLoadModelXmlType getStaticLoadModel() {
        return staticLoadModel;
    }

    /**
     * Sets the value of the staticLoadModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaticLoadModelXmlType }
     *     
     */
    public void setStaticLoadModel(StaticLoadModelXmlType value) {
        this.staticLoadModel = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="netEqnItrNoEvent" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="netEqnItrWithEvent" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "netEqnItrNoEvent",
        "netEqnItrWithEvent"
    })
    public static class NetEqnSolveConfig {

        protected Integer netEqnItrNoEvent;
        protected Integer netEqnItrWithEvent;

        /**
         * Gets the value of the netEqnItrNoEvent property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getNetEqnItrNoEvent() {
            return netEqnItrNoEvent;
        }

        /**
         * Sets the value of the netEqnItrNoEvent property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setNetEqnItrNoEvent(Integer value) {
            this.netEqnItrNoEvent = value;
        }

        /**
         * Gets the value of the netEqnItrWithEvent property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getNetEqnItrWithEvent() {
            return netEqnItrWithEvent;
        }

        /**
         * Sets the value of the netEqnItrWithEvent property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setNetEqnItrWithEvent(Integer value) {
            this.netEqnItrWithEvent = value;
        }

    }

}
