//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.20 at 07:45:56 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SequenceBranchDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SequenceBranchDataXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="line" type="{http://www.ieee.org/odm/Schema/2008}SequenceLineDataXmlType" minOccurs="0"/>
 *         &lt;element name="xformer" type="{http://www.ieee.org/odm/Schema/2008}SequenceXformrtDataXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceBranchDataXmlType", propOrder = {
    "line",
    "xformer"
})
public class SequenceBranchDataXmlType {

    protected SequenceLineDataXmlType line;
    protected SequenceXformrtDataXmlType xformer;

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceLineDataXmlType }
     *     
     */
    public SequenceLineDataXmlType getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceLineDataXmlType }
     *     
     */
    public void setLine(SequenceLineDataXmlType value) {
        this.line = value;
    }

    /**
     * Gets the value of the xformer property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceXformrtDataXmlType }
     *     
     */
    public SequenceXformrtDataXmlType getXformer() {
        return xformer;
    }

    /**
     * Sets the value of the xformer property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceXformrtDataXmlType }
     *     
     */
    public void setXformer(SequenceXformrtDataXmlType value) {
        this.xformer = value;
    }

}
