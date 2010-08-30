//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.30 at 08:25:32 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EquiMachineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EquiMachineXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}MachineModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="equiPgen" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="pGenUnit" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerUnitType" minOccurs="0"/>
 *         &lt;element name="DCLineBus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EquiMachineXmlType", propOrder = {
    "equiPgen",
    "pGenUnit",
    "dcLineBus"
})
public class EquiMachineXmlType
    extends MachineModelXmlType
{

    protected Double equiPgen;
    protected ApparentPowerUnitType pGenUnit;
    @XmlElement(name = "DCLineBus")
    protected Boolean dcLineBus;

    /**
     * Gets the value of the equiPgen property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getEquiPgen() {
        return equiPgen;
    }

    /**
     * Sets the value of the equiPgen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setEquiPgen(Double value) {
        this.equiPgen = value;
    }

    /**
     * Gets the value of the pGenUnit property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerUnitType }
     *     
     */
    public ApparentPowerUnitType getPGenUnit() {
        return pGenUnit;
    }

    /**
     * Sets the value of the pGenUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerUnitType }
     *     
     */
    public void setPGenUnit(ApparentPowerUnitType value) {
        this.pGenUnit = value;
    }

    /**
     * Gets the value of the dcLineBus property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDCLineBus() {
        return dcLineBus;
    }

    /**
     * Sets the value of the dcLineBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDCLineBus(Boolean value) {
        this.dcLineBus = value;
    }

}
