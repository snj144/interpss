//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.20 at 12:17:33 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineZeroSeqXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineZeroSeqXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zLine" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType" minOccurs="0"/>
 *         &lt;element name="yLine" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="yFromSide" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="yToSide" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineZeroSeqXmlType", propOrder = {
    "zLine",
    "yLine",
    "yFromSide",
    "yToSide"
})
public class LineZeroSeqXmlType {

    protected ZXmlType zLine;
    protected YXmlType yLine;
    protected YXmlType yFromSide;
    protected YXmlType yToSide;

    /**
     * Gets the value of the zLine property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZLine() {
        return zLine;
    }

    /**
     * Sets the value of the zLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZLine(ZXmlType value) {
        this.zLine = value;
    }

    /**
     * Gets the value of the yLine property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getYLine() {
        return yLine;
    }

    /**
     * Sets the value of the yLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setYLine(YXmlType value) {
        this.yLine = value;
    }

    /**
     * Gets the value of the yFromSide property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getYFromSide() {
        return yFromSide;
    }

    /**
     * Sets the value of the yFromSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setYFromSide(YXmlType value) {
        this.yFromSide = value;
    }

    /**
     * Gets the value of the yToSide property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getYToSide() {
        return yToSide;
    }

    /**
     * Sets the value of the yToSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setYToSide(YXmlType value) {
        this.yToSide = value;
    }

}
