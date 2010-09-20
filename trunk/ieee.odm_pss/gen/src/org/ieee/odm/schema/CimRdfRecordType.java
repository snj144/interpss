//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.19 at 07:43:52 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CimRdfRecordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CimRdfRecordType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}IDRecordXmlType">
 *       &lt;sequence>
 *         &lt;element name="cimRdfRecords" type="{http://www.ieee.org/odm/Schema/2008}CimRdfListXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CimRdfRecordType", propOrder = {
    "cimRdfRecords"
})
@XmlSeeAlso({
    CimConnectionRecordType.class,
    BusXmlType.class
})
public class CimRdfRecordType
    extends IDRecordXmlType
{

    protected CimRdfListXmlType cimRdfRecords;

    /**
     * Gets the value of the cimRdfRecords property.
     * 
     * @return
     *     possible object is
     *     {@link CimRdfListXmlType }
     *     
     */
    public CimRdfListXmlType getCimRdfRecords() {
        return cimRdfRecords;
    }

    /**
     * Sets the value of the cimRdfRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link CimRdfListXmlType }
     *     
     */
    public void setCimRdfRecords(CimRdfListXmlType value) {
        this.cimRdfRecords = value;
    }

}
