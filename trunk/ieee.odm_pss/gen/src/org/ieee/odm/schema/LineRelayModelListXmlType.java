//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 08:28:58 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineRelayModelListXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineRelayModelListXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TIOCR1" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="distanceRelay" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineRelayModelListXmlType", propOrder = {
    "tiocr1",
    "distanceRelay"
})
public class LineRelayModelListXmlType {

    @XmlElement(name = "TIOCR1")
    protected LineRelayModelListXmlType.TIOCR1 tiocr1;
    protected LineRelayModelListXmlType.DistanceRelay distanceRelay;

    /**
     * Gets the value of the tiocr1 property.
     * 
     * @return
     *     possible object is
     *     {@link LineRelayModelListXmlType.TIOCR1 }
     *     
     */
    public LineRelayModelListXmlType.TIOCR1 getTIOCR1() {
        return tiocr1;
    }

    /**
     * Sets the value of the tiocr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineRelayModelListXmlType.TIOCR1 }
     *     
     */
    public void setTIOCR1(LineRelayModelListXmlType.TIOCR1 value) {
        this.tiocr1 = value;
    }

    /**
     * Gets the value of the distanceRelay property.
     * 
     * @return
     *     possible object is
     *     {@link LineRelayModelListXmlType.DistanceRelay }
     *     
     */
    public LineRelayModelListXmlType.DistanceRelay getDistanceRelay() {
        return distanceRelay;
    }

    /**
     * Sets the value of the distanceRelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineRelayModelListXmlType.DistanceRelay }
     *     
     */
    public void setDistanceRelay(LineRelayModelListXmlType.DistanceRelay value) {
        this.distanceRelay = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DistanceRelay {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TIOCR1 {


    }

}
