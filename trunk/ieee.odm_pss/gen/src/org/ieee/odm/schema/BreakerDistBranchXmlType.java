//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.08 at 05:19:50 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BreakerDistBranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BreakerDistBranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="r" type="{http://www.ieee.org/odm/Schema/2008}RXmlType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BreakerDistBranchXmlType", propOrder = {
    "r"
})
public class BreakerDistBranchXmlType
    extends BaseBranchXmlType
{

    @XmlElement(required = true)
    protected RXmlType r;

    /**
     * Gets the value of the r property.
     * 
     * @return
     *     possible object is
     *     {@link RXmlType }
     *     
     */
    public RXmlType getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     * @param value
     *     allowed object is
     *     {@link RXmlType }
     *     
     */
    public void setR(RXmlType value) {
        this.r = value;
    }

}
