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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XFormerDistBranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XFormerDistBranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="rating" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerXmlType"/>
 *         &lt;element name="fromSideRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType"/>
 *         &lt;element name="toSideRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType"/>
 *         &lt;element name="z1" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType"/>
 *         &lt;element name="z0" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="fromTurnRatio" type="{http://www.ieee.org/odm/Schema/2008}TurnRatioXmlType"/>
 *         &lt;element name="toSideTurnRatio" type="{http://www.ieee.org/odm/Schema/2008}TurnRatioXmlType"/>
 *         &lt;element name="fromSideConnection" type="{http://www.ieee.org/odm/Schema/2008}XformerConnectionXmlType" minOccurs="0"/>
 *         &lt;element name="toSideConnection" type="{http://www.ieee.org/odm/Schema/2008}XformerConnectionXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XFormerDistBranchXmlType", propOrder = {
    "rating",
    "fromSideRatedVoltage",
    "toSideRatedVoltage",
    "z1",
    "z0",
    "fromTurnRatio",
    "toSideTurnRatio",
    "fromSideConnection",
    "toSideConnection"
})
@XmlSeeAlso({
    W3XFormerDistBranchXmlType.class
})
public class XFormerDistBranchXmlType
    extends BaseBranchXmlType
{

    @XmlElement(required = true)
    protected ApparentPowerXmlType rating;
    @XmlElement(required = true)
    protected VoltageXmlType fromSideRatedVoltage;
    @XmlElement(required = true)
    protected VoltageXmlType toSideRatedVoltage;
    @XmlElement(required = true)
    protected ZXmlType z1;
    protected ZXmlType z0;
    @XmlElement(required = true)
    protected TurnRatioXmlType fromTurnRatio;
    @XmlElement(required = true)
    protected TurnRatioXmlType toSideTurnRatio;
    protected XformerConnectionXmlType fromSideConnection;
    protected XformerConnectionXmlType toSideConnection;

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setRating(ApparentPowerXmlType value) {
        this.rating = value;
    }

    /**
     * Gets the value of the fromSideRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getFromSideRatedVoltage() {
        return fromSideRatedVoltage;
    }

    /**
     * Sets the value of the fromSideRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setFromSideRatedVoltage(VoltageXmlType value) {
        this.fromSideRatedVoltage = value;
    }

    /**
     * Gets the value of the toSideRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getToSideRatedVoltage() {
        return toSideRatedVoltage;
    }

    /**
     * Sets the value of the toSideRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setToSideRatedVoltage(VoltageXmlType value) {
        this.toSideRatedVoltage = value;
    }

    /**
     * Gets the value of the z1 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ1() {
        return z1;
    }

    /**
     * Sets the value of the z1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ1(ZXmlType value) {
        this.z1 = value;
    }

    /**
     * Gets the value of the z0 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ0() {
        return z0;
    }

    /**
     * Sets the value of the z0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ0(ZXmlType value) {
        this.z0 = value;
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
     * Gets the value of the toSideTurnRatio property.
     * 
     * @return
     *     possible object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public TurnRatioXmlType getToSideTurnRatio() {
        return toSideTurnRatio;
    }

    /**
     * Sets the value of the toSideTurnRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TurnRatioXmlType }
     *     
     */
    public void setToSideTurnRatio(TurnRatioXmlType value) {
        this.toSideTurnRatio = value;
    }

    /**
     * Gets the value of the fromSideConnection property.
     * 
     * @return
     *     possible object is
     *     {@link XformerConnectionXmlType }
     *     
     */
    public XformerConnectionXmlType getFromSideConnection() {
        return fromSideConnection;
    }

    /**
     * Sets the value of the fromSideConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link XformerConnectionXmlType }
     *     
     */
    public void setFromSideConnection(XformerConnectionXmlType value) {
        this.fromSideConnection = value;
    }

    /**
     * Gets the value of the toSideConnection property.
     * 
     * @return
     *     possible object is
     *     {@link XformerConnectionXmlType }
     *     
     */
    public XformerConnectionXmlType getToSideConnection() {
        return toSideConnection;
    }

    /**
     * Sets the value of the toSideConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link XformerConnectionXmlType }
     *     
     */
    public void setToSideConnection(XformerConnectionXmlType value) {
        this.toSideConnection = value;
    }

}
