//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.09 at 02:24:39 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PssIEEEDualInputXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PssIEEEDualInputXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}StabilizerModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="firstInputSignal" type="{http://www.ieee.org/odm/Schema/2008}StabilizerInputSignalEnumType"/>
 *         &lt;element name="firstRemoteBusId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType"/>
 *         &lt;element name="secondInputSignal" type="{http://www.ieee.org/odm/Schema/2008}StabilizerInputSignalEnumType" minOccurs="0"/>
 *         &lt;element name="secondRemoteBusId" type="{http://www.ieee.org/odm/Schema/2008}IDRefRecordXmlType" minOccurs="0"/>
 *         &lt;element name="Trw" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T5" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T6" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T7" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="Kr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Trp" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="TW" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="TW1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="TW2" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="KS" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T9" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T10" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T12" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="Kp" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T2" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T13" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T14" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T3" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T4" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="VSMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VSMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PssIEEEDualInputXmlType", propOrder = {
    "firstInputSignal",
    "firstRemoteBusId",
    "secondInputSignal",
    "secondRemoteBusId",
    "trw",
    "t5",
    "t6",
    "t7",
    "kr",
    "trp",
    "tw",
    "tw1",
    "tw2",
    "ks",
    "t9",
    "t10",
    "t12",
    "kp",
    "t1",
    "t2",
    "t13",
    "t14",
    "t3",
    "t4",
    "vsmax",
    "vsmin"
})
public class PssIEEEDualInputXmlType
    extends StabilizerModelXmlType
{

    @XmlElement(required = true)
    protected StabilizerInputSignalEnumType firstInputSignal;
    @XmlElement(required = true)
    protected IDRefRecordXmlType firstRemoteBusId;
    protected StabilizerInputSignalEnumType secondInputSignal;
    protected IDRefRecordXmlType secondRemoteBusId;
    @XmlElement(name = "Trw", required = true)
    protected TimePeriodXmlType trw;
    @XmlElement(name = "T5", required = true)
    protected TimePeriodXmlType t5;
    @XmlElement(name = "T6", required = true)
    protected TimePeriodXmlType t6;
    @XmlElement(name = "T7", required = true)
    protected TimePeriodXmlType t7;
    @XmlElement(name = "Kr")
    protected double kr;
    @XmlElement(name = "Trp", required = true)
    protected TimePeriodXmlType trp;
    @XmlElement(name = "TW", required = true)
    protected TimePeriodXmlType tw;
    @XmlElement(name = "TW1", required = true)
    protected TimePeriodXmlType tw1;
    @XmlElement(name = "TW2", required = true)
    protected TimePeriodXmlType tw2;
    @XmlElement(name = "KS")
    protected double ks;
    @XmlElement(name = "T9", required = true)
    protected TimePeriodXmlType t9;
    @XmlElement(name = "T10", required = true)
    protected TimePeriodXmlType t10;
    @XmlElement(name = "T12", required = true)
    protected TimePeriodXmlType t12;
    @XmlElement(name = "Kp")
    protected double kp;
    @XmlElement(name = "T1", required = true)
    protected TimePeriodXmlType t1;
    @XmlElement(name = "T2", required = true)
    protected TimePeriodXmlType t2;
    @XmlElement(name = "T13", required = true)
    protected TimePeriodXmlType t13;
    @XmlElement(name = "T14", required = true)
    protected TimePeriodXmlType t14;
    @XmlElement(name = "T3", required = true)
    protected TimePeriodXmlType t3;
    @XmlElement(name = "T4", required = true)
    protected TimePeriodXmlType t4;
    @XmlElement(name = "VSMAX")
    protected double vsmax;
    @XmlElement(name = "VSMIN")
    protected double vsmin;

    /**
     * Gets the value of the firstInputSignal property.
     * 
     * @return
     *     possible object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public StabilizerInputSignalEnumType getFirstInputSignal() {
        return firstInputSignal;
    }

    /**
     * Sets the value of the firstInputSignal property.
     * 
     * @param value
     *     allowed object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public void setFirstInputSignal(StabilizerInputSignalEnumType value) {
        this.firstInputSignal = value;
    }

    /**
     * Gets the value of the firstRemoteBusId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getFirstRemoteBusId() {
        return firstRemoteBusId;
    }

    /**
     * Sets the value of the firstRemoteBusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setFirstRemoteBusId(IDRefRecordXmlType value) {
        this.firstRemoteBusId = value;
    }

    /**
     * Gets the value of the secondInputSignal property.
     * 
     * @return
     *     possible object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public StabilizerInputSignalEnumType getSecondInputSignal() {
        return secondInputSignal;
    }

    /**
     * Sets the value of the secondInputSignal property.
     * 
     * @param value
     *     allowed object is
     *     {@link StabilizerInputSignalEnumType }
     *     
     */
    public void setSecondInputSignal(StabilizerInputSignalEnumType value) {
        this.secondInputSignal = value;
    }

    /**
     * Gets the value of the secondRemoteBusId property.
     * 
     * @return
     *     possible object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public IDRefRecordXmlType getSecondRemoteBusId() {
        return secondRemoteBusId;
    }

    /**
     * Sets the value of the secondRemoteBusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDRefRecordXmlType }
     *     
     */
    public void setSecondRemoteBusId(IDRefRecordXmlType value) {
        this.secondRemoteBusId = value;
    }

    /**
     * Gets the value of the trw property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTrw() {
        return trw;
    }

    /**
     * Sets the value of the trw property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTrw(TimePeriodXmlType value) {
        this.trw = value;
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
     * Gets the value of the t7 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT7() {
        return t7;
    }

    /**
     * Sets the value of the t7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT7(TimePeriodXmlType value) {
        this.t7 = value;
    }

    /**
     * Gets the value of the kr property.
     * 
     */
    public double getKr() {
        return kr;
    }

    /**
     * Sets the value of the kr property.
     * 
     */
    public void setKr(double value) {
        this.kr = value;
    }

    /**
     * Gets the value of the trp property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTrp() {
        return trp;
    }

    /**
     * Sets the value of the trp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTrp(TimePeriodXmlType value) {
        this.trp = value;
    }

    /**
     * Gets the value of the tw property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTW() {
        return tw;
    }

    /**
     * Sets the value of the tw property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTW(TimePeriodXmlType value) {
        this.tw = value;
    }

    /**
     * Gets the value of the tw1 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTW1() {
        return tw1;
    }

    /**
     * Sets the value of the tw1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTW1(TimePeriodXmlType value) {
        this.tw1 = value;
    }

    /**
     * Gets the value of the tw2 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTW2() {
        return tw2;
    }

    /**
     * Sets the value of the tw2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTW2(TimePeriodXmlType value) {
        this.tw2 = value;
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
     * Gets the value of the t9 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT9() {
        return t9;
    }

    /**
     * Sets the value of the t9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT9(TimePeriodXmlType value) {
        this.t9 = value;
    }

    /**
     * Gets the value of the t10 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT10() {
        return t10;
    }

    /**
     * Sets the value of the t10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT10(TimePeriodXmlType value) {
        this.t10 = value;
    }

    /**
     * Gets the value of the t12 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT12() {
        return t12;
    }

    /**
     * Sets the value of the t12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT12(TimePeriodXmlType value) {
        this.t12 = value;
    }

    /**
     * Gets the value of the kp property.
     * 
     */
    public double getKp() {
        return kp;
    }

    /**
     * Sets the value of the kp property.
     * 
     */
    public void setKp(double value) {
        this.kp = value;
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
     * Gets the value of the t13 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT13() {
        return t13;
    }

    /**
     * Sets the value of the t13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT13(TimePeriodXmlType value) {
        this.t13 = value;
    }

    /**
     * Gets the value of the t14 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getT14() {
        return t14;
    }

    /**
     * Sets the value of the t14 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setT14(TimePeriodXmlType value) {
        this.t14 = value;
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
     * Gets the value of the vsmax property.
     * 
     */
    public double getVSMAX() {
        return vsmax;
    }

    /**
     * Sets the value of the vsmax property.
     * 
     */
    public void setVSMAX(double value) {
        this.vsmax = value;
    }

    /**
     * Gets the value of the vsmin property.
     * 
     */
    public double getVSMIN() {
        return vsmin;
    }

    /**
     * Sets the value of the vsmin property.
     * 
     */
    public void setVSMIN(double value) {
        this.vsmin = value;
    }

}
