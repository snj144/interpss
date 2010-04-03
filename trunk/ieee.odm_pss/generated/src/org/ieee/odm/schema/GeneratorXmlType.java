//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.03 at 12:10:58 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeneratorXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneratorXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locatedBus" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
 *         &lt;element name="genId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="ownerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="busRatedVoltage" type="{http://www.ieee.org/odm/Schema}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="generatorType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="equi_gen_unit"/>
 *               &lt;enumeration value="classicalModel"/>
 *               &lt;enumeration value="transientModel"/>
 *               &lt;enumeration value="subtransModel"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="generatorModel" type="{http://www.ieee.org/odm/Schema}GeneratorModelListXmlType"/>
 *         &lt;element name="pContribution" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="qContribution" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneratorXmlType", propOrder = {
    "locatedBus",
    "genId",
    "ownerName",
    "busRatedVoltage",
    "generatorType",
    "generatorModel",
    "pContribution",
    "qContribution"
})
public class GeneratorXmlType {

    @XmlElement(required = true)
    protected IDRefRecordXmlType locatedBus;
    protected IDRefRecordXmlType genId;
    protected String ownerName;
    protected VoltageXmlType busRatedVoltage;
    @XmlElement(required = true)
    protected String generatorType;
    @XmlElement(required = true)
    protected GeneratorModelListXmlType generatorModel;
    protected Double pContribution;
    protected Double qContribution;

    /**
     * Gets the value of the locatedBus property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getLocatedBus() {
        return locatedBus;
    }

    /**
     * Sets the value of the locatedBus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setLocatedBus(IDRefRecordXmlType value) {
        this.locatedBus = value;
    }

    /**
     * Gets the value of the genId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getGenId() {
        return genId;
    }

    /**
     * Sets the value of the genId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setGenId(IDRefRecordXmlType value) {
        this.genId = value;
    }

    /**
     * Gets the value of the ownerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Gets the value of the busRatedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getBusRatedVoltage() {
        return busRatedVoltage;
    }

    /**
     * Sets the value of the busRatedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setBusRatedVoltage(VoltageXmlType value) {
        this.busRatedVoltage = value;
    }

    /**
     * Gets the value of the generatorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneratorType() {
        return generatorType;
    }

    /**
     * Sets the value of the generatorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneratorType(String value) {
        this.generatorType = value;
    }

    /**
     * Gets the value of the generatorModel property.
     * 
     * @return
     *     possible object is
     *     {@link GeneratorModelListXmlType }
     *     
     */
    public GeneratorModelListXmlType getGeneratorModel() {
        return generatorModel;
    }

    /**
     * Sets the value of the generatorModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneratorModelListXmlType }
     *     
     */
    public void setGeneratorModel(GeneratorModelListXmlType value) {
        this.generatorModel = value;
    }

    /**
     * Gets the value of the pContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPContribution() {
        return pContribution;
    }

    /**
     * Sets the value of the pContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPContribution(Double value) {
        this.pContribution = value;
    }

    /**
     * Gets the value of the qContribution property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getQContribution() {
        return qContribution;
    }

    /**
     * Sets the value of the qContribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setQContribution(Double value) {
        this.qContribution = value;
    }

}
