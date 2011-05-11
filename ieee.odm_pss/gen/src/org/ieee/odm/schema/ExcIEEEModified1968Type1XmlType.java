//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.10 at 08:49:57 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcIEEEModified1968Type1XmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExcIEEEModified1968Type1XmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}ExcIEEE1968BaseXmlType">
 *       &lt;sequence>
 *         &lt;element name="TR" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExcIEEEModified1968Type1XmlType", propOrder = {
    "rest"
})
public class ExcIEEEModified1968Type1XmlType
    extends ExcIEEE1968BaseXmlType
{

    @XmlElementRef(name = "TR", namespace = "http://www.ieee.org/odm/Schema/2008", type = JAXBElement.class)
    protected List<JAXBElement<TimePeriodXmlType>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "TR" is used by two different parts of a schema. See: 
     * line 73 of file:/C:/eclipse/InterpssDev/ieee.odm_pss/schema/dynamic/exc/IEEEExciterModel.xsd
     * line 41 of file:/C:/eclipse/InterpssDev/ieee.odm_pss/schema/dynamic/exc/IEEEExciterModel.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TimePeriodXmlType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<TimePeriodXmlType>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<TimePeriodXmlType>>();
        }
        return this.rest;
    }

}
