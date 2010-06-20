//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.20 at 07:45:56 AM GMT-08:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShuntCompensatorDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShuntCompensatorDataXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="equivQ" type="{http://www.ieee.org/odm/Schema/2008}ReactivePowerXmlType" minOccurs="0"/>
 *         &lt;element name="shuntCompensatorList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="shunCompensator" type="{http://www.ieee.org/odm/Schema/2008}ShuntCompensatorXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
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
@XmlType(name = "ShuntCompensatorDataXmlType", propOrder = {
    "equivQ",
    "shuntCompensatorList"
})
public class ShuntCompensatorDataXmlType {

    protected ReactivePowerXmlType equivQ;
    protected ShuntCompensatorDataXmlType.ShuntCompensatorList shuntCompensatorList;

    /**
     * Gets the value of the equivQ property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public ReactivePowerXmlType getEquivQ() {
        return equivQ;
    }

    /**
     * Sets the value of the equivQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePowerXmlType }
     *     
     */
    public void setEquivQ(ReactivePowerXmlType value) {
        this.equivQ = value;
    }

    /**
     * Gets the value of the shuntCompensatorList property.
     * 
     * @return
     *     possible object is
     *     {@link ShuntCompensatorDataXmlType.ShuntCompensatorList }
     *     
     */
    public ShuntCompensatorDataXmlType.ShuntCompensatorList getShuntCompensatorList() {
        return shuntCompensatorList;
    }

    /**
     * Sets the value of the shuntCompensatorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShuntCompensatorDataXmlType.ShuntCompensatorList }
     *     
     */
    public void setShuntCompensatorList(ShuntCompensatorDataXmlType.ShuntCompensatorList value) {
        this.shuntCompensatorList = value;
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
     *       &lt;sequence>
     *         &lt;element name="shunCompensator" type="{http://www.ieee.org/odm/Schema/2008}ShuntCompensatorXmlType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "shunCompensator"
    })
    public static class ShuntCompensatorList {

        protected List<ShuntCompensatorXmlType> shunCompensator;

        /**
         * Gets the value of the shunCompensator property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the shunCompensator property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getShunCompensator().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ShuntCompensatorXmlType }
         * 
         * 
         */
        public List<ShuntCompensatorXmlType> getShunCompensator() {
            if (shunCompensator == null) {
                shunCompensator = new ArrayList<ShuntCompensatorXmlType>();
            }
            return this.shunCompensator;
        }

    }

}
