//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.29 at 11:34:17 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		
 * 
 * <p>Java class for DistributionNetXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributionNetXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}NetworkXmlType">
 *       &lt;sequence>
 *         &lt;element name="positiveSeqDataOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="scStd" type="{http://www.ieee.org/odm/Schema/2008}ScAnalysisStdEnumType"/>
 *         &lt;element name="scPointList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="scPoint" type="{http://www.ieee.org/odm/Schema/2008}DistScPointXmlType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributionNetXmlType", propOrder = {
    "positiveSeqDataOnly",
    "scStd",
    "scPointList"
})
public class DistributionNetXmlType
    extends NetworkXmlType
{

    protected boolean positiveSeqDataOnly;
    @XmlElement(required = true)
    protected ScAnalysisStdEnumType scStd;
    @XmlElement(required = true)
    protected DistributionNetXmlType.ScPointList scPointList;

    /**
     * Gets the value of the positiveSeqDataOnly property.
     * 
     */
    public boolean isPositiveSeqDataOnly() {
        return positiveSeqDataOnly;
    }

    /**
     * Sets the value of the positiveSeqDataOnly property.
     * 
     */
    public void setPositiveSeqDataOnly(boolean value) {
        this.positiveSeqDataOnly = value;
    }

    /**
     * Gets the value of the scStd property.
     * 
     * @return
     *     possible object is
     *     {@link ScAnalysisStdEnumType }
     *     
     */
    public ScAnalysisStdEnumType getScStd() {
        return scStd;
    }

    /**
     * Sets the value of the scStd property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScAnalysisStdEnumType }
     *     
     */
    public void setScStd(ScAnalysisStdEnumType value) {
        this.scStd = value;
    }

    /**
     * Gets the value of the scPointList property.
     * 
     * @return
     *     possible object is
     *     {@link DistributionNetXmlType.ScPointList }
     *     
     */
    public DistributionNetXmlType.ScPointList getScPointList() {
        return scPointList;
    }

    /**
     * Sets the value of the scPointList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionNetXmlType.ScPointList }
     *     
     */
    public void setScPointList(DistributionNetXmlType.ScPointList value) {
        this.scPointList = value;
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
     *         &lt;element name="scPoint" type="{http://www.ieee.org/odm/Schema/2008}DistScPointXmlType" maxOccurs="unbounded"/>
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
        "scPoint"
    })
    public static class ScPointList {

        @XmlElement(required = true)
        protected List<DistScPointXmlType> scPoint;

        /**
         * Gets the value of the scPoint property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the scPoint property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getScPoint().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DistScPointXmlType }
         * 
         * 
         */
        public List<DistScPointXmlType> getScPoint() {
            if (scPoint == null) {
                scPoint = new ArrayList<DistScPointXmlType>();
            }
            return this.scPoint;
        }

    }

}
