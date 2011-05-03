//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.20 at 12:17:33 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		EquivGen is intended for Loadflow study. For PQ bus, p, q are specified using the power field. For Swing bus, 
 * 		desiredVoltage and desiredAngle are used For PV bus power.re and designedVoltage are used.
 * 		It is used to define LoadflowBusXmlType equivGen and contribGen list
 * 		
 * 
 * <p>Java class for LoadflowGenDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadflowGenDataXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}CimConnectionRecordType">
 *       &lt;sequence>
 *         &lt;element name="power" type="{http://www.ieee.org/odm/Schema/2008}PowerXmlType" minOccurs="0"/>
 *         &lt;element name="desiredVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="desiredAngle" type="{http://www.ieee.org/odm/Schema/2008}AngleXmlType" minOccurs="0"/>
 *         &lt;element name="remoteVoltageControlBus" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="qLimit" type="{http://www.ieee.org/odm/Schema/2008}ReactivePowerLimitXmlType" minOccurs="0"/>
 *         &lt;element name="pLimit" type="{http://www.ieee.org/odm/Schema/2008}ActivePowerLimitXmlType" minOccurs="0"/>
 *         &lt;element name="voltageLimit" type="{http://www.ieee.org/odm/Schema/2008}VoltageLimitXmlType" minOccurs="0"/>
 *         &lt;element name="ratedPower" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerXmlType" minOccurs="0"/>
 *         &lt;element name="sourceZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="xfrZ" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="xfrTap" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="mvarVControlParticipateFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="mwControlParticipateFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" use="required" type="{http://www.ieee.org/odm/Schema/2008}LFGenCodeEnumType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadflowGenDataXmlType", propOrder = {
    "power",
    "desiredVoltage",
    "desiredAngle",
    "remoteVoltageControlBus",
    "qLimit",
    "pLimit",
    "voltageLimit",
    "ratedPower",
    "sourceZ",
    "xfrZ",
    "xfrTap",
    "mvarVControlParticipateFactor",
    "mwControlParticipateFactor"
})
public class LoadflowGenDataXmlType
    extends CimConnectionRecordType
{

    protected PowerXmlType power;
    protected VoltageXmlType desiredVoltage;
    protected AngleXmlType desiredAngle;
    protected IDRefRecordXmlType remoteVoltageControlBus;
    protected ReactivePowerLimitXmlType qLimit;
    protected ActivePowerLimitXmlType pLimit;
    protected VoltageLimitXmlType voltageLimit;
    protected ApparentPowerXmlType ratedPower;
    protected ZXmlType sourceZ;
    protected ZXmlType xfrZ;
    protected Double xfrTap;
    protected Double mvarVControlParticipateFactor;
    protected Double mwControlParticipateFactor;
    @XmlAttribute(required = true)
    protected LFGenCodeEnumType code;

    /**
     * Gets the value of the power property.
     * 
     * @return
     *     possible object is
     *     {@link PowerXmlType }
     *     
     */
    public PowerXmlType getPower() {
        return power;
    }

    /**
     * Sets the value of the power property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerXmlType }
     *     
     */
    public void setPower(PowerXmlType value) {
        this.power = value;
    }

    /**
     * Gets the value of the desiredVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getDesiredVoltage() {
        return desiredVoltage;
    }

    /**
     * Sets the value of the desiredVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setDesiredVoltage(VoltageXmlType value) {
        this.desiredVoltage = value;
    }

    /**
     * Gets the value of the desiredAngle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getDesiredAngle() {
        return desiredAngle;
    }

    /**
     * Sets the value of the desiredAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setDesiredAngle(AngleXmlType value) {
        this.desiredAngle = value;
    }

    /**
     * Gets the value of the remoteVoltageControlBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRemoteVoltageControlBus() {
        return remoteVoltageControlBus;
    }

    /**
     * Sets the value of the remoteVoltageControlBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRemoteVoltageControlBus(IDRefRecordXmlType value) {
        this.remoteVoltageControlBus = value;
    }

    /**
     * Gets the value of the qLimit property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePowerLimitXmlType }
     *     
     */
    public ReactivePowerLimitXmlType getQLimit() {
        return qLimit;
    }

    /**
     * Sets the value of the qLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePowerLimitXmlType }
     *     
     */
    public void setQLimit(ReactivePowerLimitXmlType value) {
        this.qLimit = value;
    }

    /**
     * Gets the value of the pLimit property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePowerLimitXmlType }
     *     
     */
    public ActivePowerLimitXmlType getPLimit() {
        return pLimit;
    }

    /**
     * Sets the value of the pLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerLimitXmlType }
     *     
     */
    public void setPLimit(ActivePowerLimitXmlType value) {
        this.pLimit = value;
    }

    /**
     * Gets the value of the voltageLimit property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageLimitXmlType }
     *     
     */
    public VoltageLimitXmlType getVoltageLimit() {
        return voltageLimit;
    }

    /**
     * Sets the value of the voltageLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageLimitXmlType }
     *     
     */
    public void setVoltageLimit(VoltageLimitXmlType value) {
        this.voltageLimit = value;
    }

    /**
     * Gets the value of the ratedPower property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getRatedPower() {
        return ratedPower;
    }

    /**
     * Sets the value of the ratedPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setRatedPower(ApparentPowerXmlType value) {
        this.ratedPower = value;
    }

    /**
     * Gets the value of the sourceZ property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getSourceZ() {
        return sourceZ;
    }

    /**
     * Sets the value of the sourceZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setSourceZ(ZXmlType value) {
        this.sourceZ = value;
    }

    /**
     * Gets the value of the xfrZ property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getXfrZ() {
        return xfrZ;
    }

    /**
     * Sets the value of the xfrZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setXfrZ(ZXmlType value) {
        this.xfrZ = value;
    }

    /**
     * Gets the value of the xfrTap property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getXfrTap() {
        return xfrTap;
    }

    /**
     * Sets the value of the xfrTap property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setXfrTap(Double value) {
        this.xfrTap = value;
    }

    /**
     * Gets the value of the mvarVControlParticipateFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMvarVControlParticipateFactor() {
        return mvarVControlParticipateFactor;
    }

    /**
     * Sets the value of the mvarVControlParticipateFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMvarVControlParticipateFactor(Double value) {
        this.mvarVControlParticipateFactor = value;
    }

    /**
     * Gets the value of the mwControlParticipateFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMwControlParticipateFactor() {
        return mwControlParticipateFactor;
    }

    /**
     * Sets the value of the mwControlParticipateFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMwControlParticipateFactor(Double value) {
        this.mwControlParticipateFactor = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link LFGenCodeEnumType }
     *     
     */
    public LFGenCodeEnumType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link LFGenCodeEnumType }
     *     
     */
    public void setCode(LFGenCodeEnumType value) {
        this.code = value;
    }

}