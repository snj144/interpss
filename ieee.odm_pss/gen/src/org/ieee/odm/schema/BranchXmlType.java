//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.08 at 09:51:23 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="z" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="ratingLimit" type="{http://www.ieee.org/odm/Schema/2008}BranchRatingLimitXmlType" minOccurs="0"/>
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
@XmlType(name = "BranchXmlType", propOrder = {
    "z",
    "ratingLimit",
    "meterLocation"
})
@XmlSeeAlso({
    LineBranchXmlType.class,
    BranchRecordXmlType.class,
    XfrBranchXmlType.class,
    LoadflowBranchXmlType.class
})
public abstract class BranchXmlType
    extends BaseBranchXmlType
{

    protected ZXmlType z;
    protected BranchRatingLimitXmlType ratingLimit;
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
     * Gets the value of the ratingLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BranchRatingLimitXmlType }
     *     
     */
    public BranchRatingLimitXmlType getRatingLimit() {
        return ratingLimit;
    }

    /**
     * Sets the value of the ratingLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchRatingLimitXmlType }
     *     
     */
    public void setRatingLimit(BranchRatingLimitXmlType value) {
        this.ratingLimit = value;
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
