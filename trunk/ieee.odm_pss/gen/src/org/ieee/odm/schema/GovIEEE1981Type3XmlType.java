//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.19 at 08:28:58 AM GMT-08:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GovIEEE1981Type3XmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GovIEEE1981Type3XmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basePower" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="basePowerUnit" type="{http://www.ieee.org/odm/Schema}ApparentPowerUnitType"/>
 *         &lt;element name="TG" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="TP" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="U0" type="{http://www.ieee.org/odm/Schema}TimePeriodUnitType"/>
 *         &lt;element name="UC" type="{http://www.ieee.org/odm/Schema}TimePeriodUnitType"/>
 *         &lt;element name="PMAX" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PMIN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SIGMA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DELTA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TR" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="TW" type="{http://www.ieee.org/odm/Schema}TimePeriodXmlType"/>
 *         &lt;element name="a11" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a13" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a21" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a23" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GovIEEE1981Type3XmlType", propOrder = {
    "name",
    "desc",
    "basePower",
    "basePowerUnit",
    "tg",
    "tp",
    "u0",
    "uc",
    "pmax",
    "pmin",
    "sigma",
    "delta",
    "tr",
    "tw",
    "a11",
    "a13",
    "a21",
    "a23"
})
public class GovIEEE1981Type3XmlType {

    @XmlElement(required = true)
    protected String name;
    protected String desc;
    @XmlElement(required = true)
    protected String basePower;
    @XmlElement(required = true)
    protected ApparentPowerUnitType basePowerUnit;
    @XmlElement(name = "TG", required = true)
    protected TimePeriodXmlType tg;
    @XmlElement(name = "TP", required = true)
    protected TimePeriodXmlType tp;
    @XmlElement(name = "U0", required = true)
    protected TimePeriodUnitType u0;
    @XmlElement(name = "UC", required = true)
    protected TimePeriodUnitType uc;
    @XmlElement(name = "PMAX", required = true)
    protected String pmax;
    @XmlElement(name = "PMIN", required = true)
    protected String pmin;
    @XmlElement(name = "SIGMA")
    protected double sigma;
    @XmlElement(name = "DELTA")
    protected double delta;
    @XmlElement(name = "TR", required = true)
    protected TimePeriodXmlType tr;
    @XmlElement(name = "TW", required = true)
    protected TimePeriodXmlType tw;
    protected double a11;
    protected double a13;
    protected double a21;
    protected double a23;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the basePower property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasePower() {
        return basePower;
    }

    /**
     * Sets the value of the basePower property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasePower(String value) {
        this.basePower = value;
    }

    /**
     * Gets the value of the basePowerUnit property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerUnitType }
     *     
     */
    public ApparentPowerUnitType getBasePowerUnit() {
        return basePowerUnit;
    }

    /**
     * Sets the value of the basePowerUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerUnitType }
     *     
     */
    public void setBasePowerUnit(ApparentPowerUnitType value) {
        this.basePowerUnit = value;
    }

    /**
     * Gets the value of the tg property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTG() {
        return tg;
    }

    /**
     * Sets the value of the tg property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTG(TimePeriodXmlType value) {
        this.tg = value;
    }

    /**
     * Gets the value of the tp property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTP() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTP(TimePeriodXmlType value) {
        this.tp = value;
    }

    /**
     * Gets the value of the u0 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodUnitType }
     *     
     */
    public TimePeriodUnitType getU0() {
        return u0;
    }

    /**
     * Sets the value of the u0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodUnitType }
     *     
     */
    public void setU0(TimePeriodUnitType value) {
        this.u0 = value;
    }

    /**
     * Gets the value of the uc property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodUnitType }
     *     
     */
    public TimePeriodUnitType getUC() {
        return uc;
    }

    /**
     * Sets the value of the uc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodUnitType }
     *     
     */
    public void setUC(TimePeriodUnitType value) {
        this.uc = value;
    }

    /**
     * Gets the value of the pmax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMAX() {
        return pmax;
    }

    /**
     * Sets the value of the pmax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMAX(String value) {
        this.pmax = value;
    }

    /**
     * Gets the value of the pmin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMIN() {
        return pmin;
    }

    /**
     * Sets the value of the pmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMIN(String value) {
        this.pmin = value;
    }

    /**
     * Gets the value of the sigma property.
     * 
     */
    public double getSIGMA() {
        return sigma;
    }

    /**
     * Sets the value of the sigma property.
     * 
     */
    public void setSIGMA(double value) {
        this.sigma = value;
    }

    /**
     * Gets the value of the delta property.
     * 
     */
    public double getDELTA() {
        return delta;
    }

    /**
     * Sets the value of the delta property.
     * 
     */
    public void setDELTA(double value) {
        this.delta = value;
    }

    /**
     * Gets the value of the tr property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTR() {
        return tr;
    }

    /**
     * Sets the value of the tr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTR(TimePeriodXmlType value) {
        this.tr = value;
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
     * Gets the value of the a11 property.
     * 
     */
    public double getA11() {
        return a11;
    }

    /**
     * Sets the value of the a11 property.
     * 
     */
    public void setA11(double value) {
        this.a11 = value;
    }

    /**
     * Gets the value of the a13 property.
     * 
     */
    public double getA13() {
        return a13;
    }

    /**
     * Sets the value of the a13 property.
     * 
     */
    public void setA13(double value) {
        this.a13 = value;
    }

    /**
     * Gets the value of the a21 property.
     * 
     */
    public double getA21() {
        return a21;
    }

    /**
     * Sets the value of the a21 property.
     * 
     */
    public void setA21(double value) {
        this.a21 = value;
    }

    /**
     * Gets the value of the a23 property.
     * 
     */
    public double getA23() {
        return a23;
    }

    /**
     * Sets the value of the a23 property.
     * 
     */
    public void setA23(double value) {
        this.a23 = value;
    }

}
