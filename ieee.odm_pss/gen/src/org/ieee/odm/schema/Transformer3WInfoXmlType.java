//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.26 at 09:51:00 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Transformer3WInfoXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transformer3WInfoXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}TransformerInfoXmlType">
 *       &lt;sequence>
 *         &lt;element name="starVMag" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="starVAng" type="{http://www.ieee.org/odm/Schema/2008}AngleXmlType" minOccurs="0"/>
 *         &lt;element name="tertRatedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="ratedPower23" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerXmlType" minOccurs="0"/>
 *         &lt;element name="ratedPower31" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerXmlType" minOccurs="0"/>
 *         &lt;element name="tertLossFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transformer3WInfoXmlType", propOrder = {
    "starVMag",
    "starVAng",
    "tertRatedVoltage",
    "ratedPower23",
    "ratedPower31",
    "tertLossFactor"
})
public class Transformer3WInfoXmlType
    extends TransformerInfoXmlType
{

    protected VoltageXmlType starVMag;
    protected AngleXmlType starVAng;
    protected VoltageXmlType tertRatedVoltage;
    protected ApparentPowerXmlType ratedPower23;
    protected ApparentPowerXmlType ratedPower31;
    protected Double tertLossFactor;

    /**
     * Gets the value of the starVMag property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getStarVMag() {
        return starVMag;
    }

    /**
     * Sets the value of the starVMag property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setStarVMag(VoltageXmlType value) {
        this.starVMag = value;
    }

    /**
     * Gets the value of the starVAng property.
     * 
     * @return
     *     possible object is
     *     {@link AngleXmlType }
     *     
     */
    public AngleXmlType getStarVAng() {
        return starVAng;
    }

    /**
     * Sets the value of the starVAng property.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleXmlType }
     *     
     */
    public void setStarVAng(AngleXmlType value) {
        this.starVAng = value;
    }

    /**
     * Gets the value of the tertRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getTertRatedVoltage() {
        return tertRatedVoltage;
    }

    /**
     * Sets the value of the tertRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setTertRatedVoltage(VoltageXmlType value) {
        this.tertRatedVoltage = value;
    }

    /**
     * Gets the value of the ratedPower23 property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getRatedPower23() {
        return ratedPower23;
    }

    /**
     * Sets the value of the ratedPower23 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setRatedPower23(ApparentPowerXmlType value) {
        this.ratedPower23 = value;
    }

    /**
     * Gets the value of the ratedPower31 property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getRatedPower31() {
        return ratedPower31;
    }

    /**
     * Sets the value of the ratedPower31 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setRatedPower31(ApparentPowerXmlType value) {
        this.ratedPower31 = value;
    }

    /**
     * Gets the value of the tertLossFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTertLossFactor() {
        return tertLossFactor;
    }

    /**
     * Sets the value of the tertLossFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTertLossFactor(Double value) {
        this.tertLossFactor = value;
    }

}
