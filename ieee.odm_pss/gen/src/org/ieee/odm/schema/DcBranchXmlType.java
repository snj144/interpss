//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.23 at 11:13:49 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		
 * 
 * <p>Java class for DcBranchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DcBranchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="feeder" type="{http://www.ieee.org/odm/Schema/2008}DcFeederXmlType"/>
 *         &lt;element name="homeRun" type="{http://www.ieee.org/odm/Schema/2008}DcFeederXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DcBranchXmlType", propOrder = {
    "feeder",
    "homeRun"
})
public class DcBranchXmlType
    extends BaseBranchXmlType
{

    @XmlElement(required = true)
    protected DcFeederXmlType feeder;
    protected DcFeederXmlType homeRun;

    /**
     * Gets the value of the feeder property.
     * 
     * @return
     *     possible object is
     *     {@link DcFeederXmlType }
     *     
     */
    public DcFeederXmlType getFeeder() {
        return feeder;
    }

    /**
     * Sets the value of the feeder property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcFeederXmlType }
     *     
     */
    public void setFeeder(DcFeederXmlType value) {
        this.feeder = value;
    }

    /**
     * Gets the value of the homeRun property.
     * 
     * @return
     *     possible object is
     *     {@link DcFeederXmlType }
     *     
     */
    public DcFeederXmlType getHomeRun() {
        return homeRun;
    }

    /**
     * Sets the value of the homeRun property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcFeederXmlType }
     *     
     */
    public void setHomeRun(DcFeederXmlType value) {
        this.homeRun = value;
    }

}
