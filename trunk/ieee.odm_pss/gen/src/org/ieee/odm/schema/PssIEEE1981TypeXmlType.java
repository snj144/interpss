//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.30 at 03:27:45 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PssIEEE1981TypeXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PssIEEE1981TypeXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}StabilizerModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="inputSignal" type="{http://www.ieee.org/odm/Schema/2008}StabilizerInputSignalEnumType"/>
 *         &lt;element name="remoteBusId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="A1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="A2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="A3" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="A4" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="A5" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="A6" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T2" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T3" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T4" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T5" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T6" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="KS" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LSMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LSMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VCU" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VCL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PssIEEE1981TypeXmlType", propOrder = {
    "inputSignal",
    "remoteBusId",
    "a1",
    "a2",
    "a3",
    "a4",
    "a5",
    "a6",
    "t1",
    "t2",
    "t3",
    "t4",
    "t5",
    "t6",
    "ks",
    "lsmax",
    "lsmin",
    "vcu",
    "vcl"
})
public class PssIEEE1981TypeXmlType
    extends StabilizerModelXmlType
{

    @XmlElement(required = true)
    protected StabilizerInputSignalEnumType inputSignal;
    protected IDRefRecordXmlType remoteBusId;
    @XmlElement(name = "A1")
    protected double a1;
    @XmlElement(name = "A2")
    protected double a2;
    @XmlElement(name = "A3")
    protected double a3;
    @XmlElement(name = "A4")
    protected double a4;
    @XmlElement(name = "A5")
    protected double a5;
    @XmlElement(name = "A6")
    protected double a6;
    @XmlElement(name = "T1", required = true)
    protected TimePeriodXmlType t1;
    @XmlElement(name = "T2", required = true)
    protected TimePeriodXmlType t2;
    @XmlElement(name = "T3", required = true)
    protected TimePeriodXmlType t3;
    @XmlElement(name = "T4", required = true)
    protected TimePeriodXmlType t4;
    @XmlElement(name = "T5", required = true)
    protected TimePeriodXmlType t5;
    @XmlElement(name = "T6", required = true)
    protected TimePeriodXmlType t6;
    @XmlElement(name = "KS")
    protected double ks;
    @XmlElement(name = "LSMAX")
    protected double lsmax;
    @XmlElement(name = "LSMIN")
    protected double lsmin;
    @XmlElement(name = "VCU", required = true)
    protected String vcu;
    @XmlElement(name = "VCL", required = true)
    protected String vcl;

    /**
     * Gets the value of the inputSignal property.
     * 
     * @return
     *     possible object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public StabilizerInputSignalEnumType getInputSignal() {
        return inputSignal;
    }

    /**
     * Sets the value of the inputSignal property.
     * 
     * @param value
     *     allowed object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public void setInputSignal(StabilizerInputSignalEnumType value) {
        this.inputSignal = value;
    }

    /**
     * Gets the value of the remoteBusId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getRemoteBusId() {
        return remoteBusId;
    }

    /**
     * Sets the value of the remoteBusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setRemoteBusId(IDRefRecordXmlType value) {
        this.remoteBusId = value;
    }

    /**
     * Gets the value of the a1 property.
     * 
     */
    public double getA1() {
        return a1;
    }

    /**
     * Sets the value of the a1 property.
     * 
     */
    public void setA1(double value) {
        this.a1 = value;
    }

    /**
     * Gets the value of the a2 property.
     * 
     */
    public double getA2() {
        return a2;
    }

    /**
     * Sets the value of the a2 property.
     * 
     */
    public void setA2(double value) {
        this.a2 = value;
    }

    /**
     * Gets the value of the a3 property.
     * 
     */
    public double getA3() {
        return a3;
    }

    /**
     * Sets the value of the a3 property.
     * 
     */
    public void setA3(double value) {
        this.a3 = value;
    }

    /**
     * Gets the value of the a4 property.
     * 
     */
    public double getA4() {
        return a4;
    }

    /**
     * Sets the value of the a4 property.
     * 
     */
    public void setA4(double value) {
        this.a4 = value;
    }

    /**
     * Gets the value of the a5 property.
     * 
     */
    public double getA5() {
        return a5;
    }

    /**
     * Sets the value of the a5 property.
     * 
     */
    public void setA5(double value) {
        this.a5 = value;
    }

    /**
     * Gets the value of the a6 property.
     * 
     */
    public double getA6() {
        return a6;
    }

    /**
     * Sets the value of the a6 property.
     * 
     */
    public void setA6(double value) {
        this.a6 = value;
    }

    /**
     * Gets the value of the t1 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT1() {
        return t1;
    }

    /**
     * Sets the value of the t1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT1(TimePeriodXmlType value) {
        this.t1 = value;
    }

    /**
     * Gets the value of the t2 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT2() {
        return t2;
    }

    /**
     * Sets the value of the t2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT2(TimePeriodXmlType value) {
        this.t2 = value;
    }

    /**
     * Gets the value of the t3 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT3() {
        return t3;
    }

    /**
     * Sets the value of the t3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT3(TimePeriodXmlType value) {
        this.t3 = value;
    }

    /**
     * Gets the value of the t4 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT4() {
        return t4;
    }

    /**
     * Sets the value of the t4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT4(TimePeriodXmlType value) {
        this.t4 = value;
    }

    /**
     * Gets the value of the t5 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT5() {
        return t5;
    }

    /**
     * Sets the value of the t5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT5(TimePeriodXmlType value) {
        this.t5 = value;
    }

    /**
     * Gets the value of the t6 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT6() {
        return t6;
    }

    /**
     * Sets the value of the t6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT6(TimePeriodXmlType value) {
        this.t6 = value;
    }

    /**
     * Gets the value of the ks property.
     * 
     */
    public double getKS() {
        return ks;
    }

    /**
     * Sets the value of the ks property.
     * 
     */
    public void setKS(double value) {
        this.ks = value;
    }

    /**
     * Gets the value of the lsmax property.
     * 
     */
    public double getLSMAX() {
        return lsmax;
    }

    /**
     * Sets the value of the lsmax property.
     * 
     */
    public void setLSMAX(double value) {
        this.lsmax = value;
    }

    /**
     * Gets the value of the lsmin property.
     * 
     */
    public double getLSMIN() {
        return lsmin;
    }

    /**
     * Sets the value of the lsmin property.
     * 
     */
    public void setLSMIN(double value) {
        this.lsmin = value;
    }

    /**
     * Gets the value of the vcu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCU() {
        return vcu;
    }

    /**
     * Sets the value of the vcu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCU(String value) {
        this.vcu = value;
    }

    /**
     * Gets the value of the vcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCL() {
        return vcl;
    }

    /**
     * Sets the value of the vcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCL(String value) {
        this.vcl = value;
    }

}
