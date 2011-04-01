//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.01 at 07:21:18 AM GMT-05:00 
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
 * <p>Java class for DcAcInverterXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DcAcInverterXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="powerRating" type="{http://www.ieee.org/odm/Schema/2008}ActivePowerXmlType"/>
 *         &lt;element name="vdcmax" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="idcmax" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="mpptHigh" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="mpptLow" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="vac" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="loss" type="{http://www.ieee.org/odm/Schema/2008}InverterLossEqnXmlType"/>
 *           &lt;element name="lossParamList">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="lossParam" type="{http://www.ieee.org/odm/Schema/2008}InverterLossParamXmlType" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DcAcInverterXmlType", propOrder = {
    "powerRating",
    "vdcmax",
    "idcmax",
    "mpptHigh",
    "mpptLow",
    "vac",
    "loss",
    "lossParamList"
})
public class DcAcInverterXmlType {

    @XmlElement(required = true)
    protected ActivePowerXmlType powerRating;
    protected Double vdcmax;
    protected Double idcmax;
    protected Double mpptHigh;
    protected Double mpptLow;
    protected Double vac;
    protected InverterLossEqnXmlType loss;
    protected DcAcInverterXmlType.LossParamList lossParamList;

    /**
     * Gets the value of the powerRating property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public ActivePowerXmlType getPowerRating() {
        return powerRating;
    }

    /**
     * Sets the value of the powerRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public void setPowerRating(ActivePowerXmlType value) {
        this.powerRating = value;
    }

    /**
     * Gets the value of the vdcmax property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVdcmax() {
        return vdcmax;
    }

    /**
     * Sets the value of the vdcmax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVdcmax(Double value) {
        this.vdcmax = value;
    }

    /**
     * Gets the value of the idcmax property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIdcmax() {
        return idcmax;
    }

    /**
     * Sets the value of the idcmax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIdcmax(Double value) {
        this.idcmax = value;
    }

    /**
     * Gets the value of the mpptHigh property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMpptHigh() {
        return mpptHigh;
    }

    /**
     * Sets the value of the mpptHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMpptHigh(Double value) {
        this.mpptHigh = value;
    }

    /**
     * Gets the value of the mpptLow property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMpptLow() {
        return mpptLow;
    }

    /**
     * Sets the value of the mpptLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMpptLow(Double value) {
        this.mpptLow = value;
    }

    /**
     * Gets the value of the vac property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVac() {
        return vac;
    }

    /**
     * Sets the value of the vac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVac(Double value) {
        this.vac = value;
    }

    /**
     * Gets the value of the loss property.
     * 
     * @return
     *     possible object is
     *     {@link InverterLossEqnXmlType }
     *     
     */
    public InverterLossEqnXmlType getLoss() {
        return loss;
    }

    /**
     * Sets the value of the loss property.
     * 
     * @param value
     *     allowed object is
     *     {@link InverterLossEqnXmlType }
     *     
     */
    public void setLoss(InverterLossEqnXmlType value) {
        this.loss = value;
    }

    /**
     * Gets the value of the lossParamList property.
     * 
     * @return
     *     possible object is
     *     {@link DcAcInverterXmlType.LossParamList }
     *     
     */
    public DcAcInverterXmlType.LossParamList getLossParamList() {
        return lossParamList;
    }

    /**
     * Sets the value of the lossParamList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DcAcInverterXmlType.LossParamList }
     *     
     */
    public void setLossParamList(DcAcInverterXmlType.LossParamList value) {
        this.lossParamList = value;
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
     *         &lt;element name="lossParam" type="{http://www.ieee.org/odm/Schema/2008}InverterLossParamXmlType" maxOccurs="unbounded"/>
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
        "lossParam"
    })
    public static class LossParamList {

        @XmlElement(required = true)
        protected List<InverterLossParamXmlType> lossParam;

        /**
         * Gets the value of the lossParam property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lossParam property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLossParam().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InverterLossParamXmlType }
         * 
         * 
         */
        public List<InverterLossParamXmlType> getLossParam() {
            if (lossParam == null) {
                lossParam = new ArrayList<InverterLossParamXmlType>();
            }
            return this.lossParam;
        }

    }

}
