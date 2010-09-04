//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.04 at 09:45:54 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseBranchDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseBranchDataXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseRecordXmlType">
 *       &lt;sequence>
 *         &lt;element name="z" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="totalShuntY" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="fromShuntY" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="toShuntY" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="fromTurnRatio" type="{http://www.ieee.org/odm/Schema/2008}TurnRatioXmlType" minOccurs="0"/>
 *         &lt;element name="toTurnRatio" type="{http://www.ieee.org/odm/Schema/2008}TurnRatioXmlType" minOccurs="0"/>
 *         &lt;element name="fromAngle" type="{http://www.ieee.org/odm/Schema/2008}AngleXmlType" minOccurs="0"/>
 *         &lt;element name="toAngle" type="{http://www.ieee.org/odm/Schema/2008}AngleXmlType" minOccurs="0"/>
 *         &lt;element name="meterLocation" type="{http://www.ieee.org/odm/Schema/2008}BranchMeterLocationEnumType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseBranchDataXmlType", propOrder = {
    "z",
    "totalShuntY",
    "fromShuntY",
    "toShuntY",
    "fromTurnRatio",
    "toTurnRatio",
    "fromAngle",
    "toAngle",
    "meterLocation"
})
@XmlSeeAlso({
    LoadflowBranchDataXmlType.class
})
public class BaseBranchDataXmlType
    extends BaseRecordXmlType
{

    protected ZXmlType z;
    protected YXmlType totalShuntY;
    protected YXmlType fromShuntY;
    protected YXmlType toShuntY;
    protected TurnRatioXmlType fromTurnRatio;
    protected TurnRatioXmlType toTurnRatio;
    protected AngleXmlType fromAngle;
    protected AngleXmlType toAngle;
    protected BranchMeterLocationEnumType meterLocation;

    /**
     * Gets the value of the z property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ() {
        return z;
    }

    /**
     * Sets the value of the z property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ(ZXmlType value) {
        this.z = value;
    }

    /**
     * Gets the value of the totalShuntY property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getTotalShuntY() {
        return totalShuntY;
    }

    /**
     * Sets the value of the totalShuntY property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setTotalShuntY(YXmlType value) {
        this.totalShuntY = value;
    }

    /**
     * Gets the value of the fromShuntY property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getFromShuntY() {
        return fromShuntY;
    }

    /**
     * Sets the value of the fromShuntY property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setFromShuntY(YXmlType value) {
        this.fromShuntY = value;
    }

    /**
     * Gets the value of the toShuntY property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getToShuntY() {
        return toShuntY;
    }

    /**
     * Sets the value of the toShuntY property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setToShuntY(YXmlType value) {
        this.toShuntY = value;
    }

    /**
     * Gets the value of the fromTurnRatio property.
     * 
     * @return
     *     possible object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public TurnRatioXmlType getFromTurnRatio() {
        return fromTurnRatio;
    }

    /**
     * Sets the value of the fromTurnRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public void setFromTurnRatio(TurnRatioXmlType value) {
        this.fromTurnRatio = value;
    }

    /**
     * Gets the value of the toTurnRatio property.
     * 
     * @return
     *     possible object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public TurnRatioXmlType getToTurnRatio() {
        return toTurnRatio;
    }

    /**
     * Sets the value of the toTurnRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public void setToTurnRatio(TurnRatioXmlType value) {
        this.toTurnRatio = value;
    }

    /**
     * Gets the value of the fromAngle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getFromAngle() {
        return fromAngle;
    }

    /**
     * Sets the value of the fromAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setFromAngle(AngleXmlType value) {
        this.fromAngle = value;
    }

    /**
     * Gets the value of the toAngle property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getToAngle() {
        return toAngle;
    }

    /**
     * Sets the value of the toAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setToAngle(AngleXmlType value) {
        this.toAngle = value;
    }

    /**
     * Gets the value of the meterLocation property.
     * 
     * @return
     *     possible object is
     *     {@link BranchMeterLocationEnumType }
     *     
     */
    public BranchMeterLocationEnumType getMeterLocation() {
        return meterLocation;
    }

    /**
     * Sets the value of the meterLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchMeterLocationEnumType }
     *     
     */
    public void setMeterLocation(BranchMeterLocationEnumType value) {
        this.meterLocation = value;
    }

}
