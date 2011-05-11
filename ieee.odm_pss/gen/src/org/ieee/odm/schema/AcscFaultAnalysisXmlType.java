//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.10 at 08:49:57 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcscFaultAnalysisXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcscFaultAnalysisXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseAnalysisTypeXmlType">
 *       &lt;sequence>
 *         &lt;element name="fault" type="{http://www.ieee.org/odm/Schema/2008}AcscFaultXmlType"/>
 *         &lt;element name="preFaultBusVoltage" type="{http://www.ieee.org/odm/Schema/2008}PreFaultBusVoltageEnumType" minOccurs="0"/>
 *         &lt;element name="multiFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcscFaultAnalysisXmlType", propOrder = {
    "fault",
    "preFaultBusVoltage",
    "multiFactor"
})
public class AcscFaultAnalysisXmlType
    extends BaseAnalysisTypeXmlType
{

    @XmlElement(required = true)
    protected AcscFaultXmlType fault;
    protected PreFaultBusVoltageEnumType preFaultBusVoltage;
    protected Double multiFactor;

    /**
     * Gets the value of the fault property.
     * 
     * @return
     *     possible object is
     *     {@link AcscFaultXmlType }
     *     
     */
    public AcscFaultXmlType getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcscFaultXmlType }
     *     
     */
    public void setFault(AcscFaultXmlType value) {
        this.fault = value;
    }

    /**
     * Gets the value of the preFaultBusVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link PreFaultBusVoltageEnumType }
     *     
     */
    public PreFaultBusVoltageEnumType getPreFaultBusVoltage() {
        return preFaultBusVoltage;
    }

    /**
     * Sets the value of the preFaultBusVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreFaultBusVoltageEnumType }
     *     
     */
    public void setPreFaultBusVoltage(PreFaultBusVoltageEnumType value) {
        this.preFaultBusVoltage = value;
    }

    /**
     * Gets the value of the multiFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMultiFactor() {
        return multiFactor;
    }

    /**
     * Sets the value of the multiFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMultiFactor(Double value) {
        this.multiFactor = value;
    }

}
