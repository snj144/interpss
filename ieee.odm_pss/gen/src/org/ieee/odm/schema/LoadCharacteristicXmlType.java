//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.15 at 12:57:40 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoadCharacteristicXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadCharacteristicXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicLocationEnumType"/>
 *         &lt;element name="locationId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="LoadXmlType" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicTypeEnumType"/>
 *         &lt;element name="LoadModel" type="{http://www.ieee.org/odm/Schema/2008}LoadCharacteristicModelListXmlType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadCharacteristicXmlType", propOrder = {
    "location",
    "locationId",
    "loadXmlType",
    "loadModel"
})
public class LoadCharacteristicXmlType {

    @XmlElement(required = true)
    protected LoadCharacteristicLocationEnumType location;
    @XmlElement(required = true)
    protected IDRefRecordXmlType locationId;
    @XmlElement(name = "LoadXmlType", required = true)
    protected LoadCharacteristicTypeEnumType loadXmlType;
    @XmlElement(name = "LoadModel", required = true)
    protected LoadCharacteristicModelListXmlType loadModel;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LoadCharacteristicLocationEnumType }
     *     
     */
    public LoadCharacteristicLocationEnumType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadCharacteristicLocationEnumType }
     *     
     */
    public void setLocation(LoadCharacteristicLocationEnumType value) {
        this.location = value;
    }

    /**
     * Gets the value of the locationId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getLocationId() {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setLocationId(IDRefRecordXmlType value) {
        this.locationId = value;
    }

    /**
     * Gets the value of the loadXmlType property.
     * 
     * @return
     *     possible object is
     *     {@link LoadCharacteristicTypeEnumType }
     *     
     */
    public LoadCharacteristicTypeEnumType getLoadXmlType() {
        return loadXmlType;
    }

    /**
     * Sets the value of the loadXmlType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadCharacteristicTypeEnumType }
     *     
     */
    public void setLoadXmlType(LoadCharacteristicTypeEnumType value) {
        this.loadXmlType = value;
    }

    /**
     * Gets the value of the loadModel property.
     * 
     * @return
     *     possible object is
     *     {@link LoadCharacteristicModelListXmlType }
     *     
     */
    public LoadCharacteristicModelListXmlType getLoadModel() {
        return loadModel;
    }

    /**
     * Sets the value of the loadModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadCharacteristicModelListXmlType }
     *     
     */
    public void setLoadModel(LoadCharacteristicModelListXmlType value) {
        this.loadModel = value;
    }

}
