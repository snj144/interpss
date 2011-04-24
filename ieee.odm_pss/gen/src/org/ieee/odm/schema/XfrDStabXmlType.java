//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.24 at 04:05:23 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XfrDStabXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XfrDStabXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}XfrShortCircuitXmlType">
 *       &lt;sequence>
 *         &lt;element name="xfrRelay" type="{http://www.ieee.org/odm/Schema/2008}DynamicXfrRelayXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XfrDStabXmlType", propOrder = {
    "xfrRelay"
})
public class XfrDStabXmlType
    extends XfrShortCircuitXmlType
{

    protected List<DynamicXfrRelayXmlType> xfrRelay;

    /**
     * Gets the value of the xfrRelay property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xfrRelay property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXfrRelay().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DynamicXfrRelayXmlType }
     * 
     * 
     */
    public List<DynamicXfrRelayXmlType> getXfrRelay() {
        if (xfrRelay == null) {
            xfrRelay = new ArrayList<DynamicXfrRelayXmlType>();
        }
        return this.xfrRelay;
    }

}
