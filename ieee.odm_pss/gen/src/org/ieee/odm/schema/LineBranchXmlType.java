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
 * <p>Java class for LineBranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineBranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="totalShuntY" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="fromShuntY" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="toShuntY" type="{http://www.ieee.org/odm/Schema/2008}YXmlType" minOccurs="0"/>
 *         &lt;element name="lineInfo" type="{http://www.ieee.org/odm/Schema/2008}LineBranchInfoXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineBranchXmlType", propOrder = {
    "totalShuntY",
    "fromShuntY",
    "toShuntY",
    "lineInfo"
})
@XmlSeeAlso({
    LineShortCircuitXmlType.class
})
public class LineBranchXmlType
    extends BranchXmlType
{

    protected YXmlType totalShuntY;
    protected YXmlType fromShuntY;
    protected YXmlType toShuntY;
    protected LineBranchInfoXmlType lineInfo;

    /**
     * Gets the value of the totalShuntY property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getTotalShuntY() {
        return totalShuntY;
    }

    /**
     * Sets the value of the totalShuntY property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setTotalShuntY(YXmlType value) {
        this.totalShuntY = value;
    }

    /**
     * Gets the value of the fromShuntY property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getFromShuntY() {
        return fromShuntY;
    }

    /**
     * Sets the value of the fromShuntY property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setFromShuntY(YXmlType value) {
        this.fromShuntY = value;
    }

    /**
     * Gets the value of the toShuntY property.
     * 
     * @return
     *     possible object is
     *     {@link YXmlType }
     *     
     */
    public YXmlType getToShuntY() {
        return toShuntY;
    }

    /**
     * Sets the value of the toShuntY property.
     * 
     * @param value
     *     allowed object is
     *     {@link YXmlType }
     *     
     */
    public void setToShuntY(YXmlType value) {
        this.toShuntY = value;
    }

    /**
     * Gets the value of the lineInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LineBranchInfoXmlType }
     *     
     */
    public LineBranchInfoXmlType getLineInfo() {
        return lineInfo;
    }

    /**
     * Sets the value of the lineInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineBranchInfoXmlType }
     *     
     */
    public void setLineInfo(LineBranchInfoXmlType value) {
        this.lineInfo = value;
    }

}
