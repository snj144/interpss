//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.11 at 02:43:09 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Network container for AC Loadflow study. It is a sub type of the NetworkXmlType,
 * 				which as a bus list of BusXmlType and a branch list of BaseBranchXmlType 
 * 		
 * 
 * <p>Java class for LoadflowNetXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadflowNetXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}NetworkXmlType">
 *       &lt;sequence>
 *         &lt;element name="interchangeList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="interchange" type="{http://www.ieee.org/odm/Schema/2008}InterchangeXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="tieLineList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tieline" type="{http://www.ieee.org/odm/Schema/2008}TielineXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="xfrZTable" type="{http://www.ieee.org/odm/Schema/2008}XformerZTableXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadflowNetXmlType", propOrder = {
    "interchangeList",
    "tieLineList",
    "xfrZTable"
})
@XmlSeeAlso({
    OpfNetworkXmlType.class,
    ShortCircuitNetXmlType.class
})
public class LoadflowNetXmlType
    extends NetworkXmlType
{

    protected LoadflowNetXmlType.InterchangeList interchangeList;
    protected LoadflowNetXmlType.TieLineList tieLineList;
    protected XformerZTableXmlType xfrZTable;

    /**
     * Gets the value of the interchangeList property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowNetXmlType.InterchangeList }
     *     
     */
    public LoadflowNetXmlType.InterchangeList getInterchangeList() {
        return interchangeList;
    }

    /**
     * Sets the value of the interchangeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowNetXmlType.InterchangeList }
     *     
     */
    public void setInterchangeList(LoadflowNetXmlType.InterchangeList value) {
        this.interchangeList = value;
    }

    /**
     * Gets the value of the tieLineList property.
     * 
     * @return
     *     possible object is
     *     {@link LoadflowNetXmlType.TieLineList }
     *     
     */
    public LoadflowNetXmlType.TieLineList getTieLineList() {
        return tieLineList;
    }

    /**
     * Sets the value of the tieLineList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadflowNetXmlType.TieLineList }
     *     
     */
    public void setTieLineList(LoadflowNetXmlType.TieLineList value) {
        this.tieLineList = value;
    }

    /**
     * Gets the value of the xfrZTable property.
     * 
     * @return
     *     possible object is
     *     {@link XformerZTableXmlType }
     *     
     */
    public XformerZTableXmlType getXfrZTable() {
        return xfrZTable;
    }

    /**
     * Sets the value of the xfrZTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link XformerZTableXmlType }
     *     
     */
    public void setXfrZTable(XformerZTableXmlType value) {
        this.xfrZTable = value;
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
     *         &lt;element name="interchange" type="{http://www.ieee.org/odm/Schema/2008}InterchangeXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "interchange"
    })
    public static class InterchangeList {

        protected List<InterchangeXmlType> interchange;

        /**
         * Gets the value of the interchange property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the interchange property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInterchange().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InterchangeXmlType }
         * 
         * 
         */
        public List<InterchangeXmlType> getInterchange() {
            if (interchange == null) {
                interchange = new ArrayList<InterchangeXmlType>();
            }
            return this.interchange;
        }

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
     *         &lt;element name="tieline" type="{http://www.ieee.org/odm/Schema/2008}TielineXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "tieline"
    })
    public static class TieLineList {

        protected List<TielineXmlType> tieline;

        /**
         * Gets the value of the tieline property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tieline property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTieline().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TielineXmlType }
         * 
         * 
         */
        public List<TielineXmlType> getTieline() {
            if (tieline == null) {
                tieline = new ArrayList<TielineXmlType>();
            }
            return this.tieline;
        }

    }

}