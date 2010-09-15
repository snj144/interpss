//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.15 at 01:46:12 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Base bus record for all bus type
 * 
 * <p>Java class for BusXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}CimRdfRecordType">
 *       &lt;sequence>
 *         &lt;element name="baseVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusXmlType", propOrder = {
    "baseVoltage"
})
@XmlSeeAlso({
    ScSimpleBusXmlType.class,
    LoadflowBusXmlType.class,
    BusRecordXmlType.class
})
public abstract class BusXmlType
    extends CimRdfRecordType
{

    @XmlElement(required = true)
    protected VoltageXmlType baseVoltage;

    /**
     * Gets the value of the baseVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getBaseVoltage() {
        return baseVoltage;
    }

    /**
     * Sets the value of the baseVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setBaseVoltage(VoltageXmlType value) {
        this.baseVoltage = value;
    }

}
