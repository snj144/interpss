//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.21 at 03:20:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicLoadIEEEStaticLoadXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicLoadIEEEStaticLoadXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="modelDesc" type="{http://www.ieee.org/odm/Schema/2008}DynamicLoadEnumType" minOccurs="0"/>
 *         &lt;element name="a1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a3" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a4" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a5" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a6" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a7" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a8" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="n1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="n2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="n3" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="n4" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="n5" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="n6" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="a9" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="a10" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DynamicLoadIEEEStaticLoadXmlType", propOrder = {
    "modelDesc",
    "a1",
    "a2",
    "a3",
    "a4",
    "a5",
    "a6",
    "a7",
    "a8",
    "n1",
    "n2",
    "n3",
    "n4",
    "n5",
    "n6",
    "a9",
    "a10"
})
public class DynamicLoadIEEEStaticLoadXmlType {

    protected DynamicLoadEnumType modelDesc;
    protected double a1;
    protected double a2;
    protected double a3;
    protected double a4;
    protected double a5;
    protected double a6;
    protected double a7;
    protected double a8;
    protected double n1;
    protected double n2;
    protected double n3;
    protected double n4;
    protected double n5;
    protected double n6;
    protected Double a9;
    protected Double a10;

    /**
     * Gets the value of the modelDesc property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicLoadEnumType }
     *     
     */
    public DynamicLoadEnumType getModelDesc() {
        return modelDesc;
    }

    /**
     * Sets the value of the modelDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicLoadEnumType }
     *     
     */
    public void setModelDesc(DynamicLoadEnumType value) {
        this.modelDesc = value;
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
     * Gets the value of the a7 property.
     * 
     */
    public double getA7() {
        return a7;
    }

    /**
     * Sets the value of the a7 property.
     * 
     */
    public void setA7(double value) {
        this.a7 = value;
    }

    /**
     * Gets the value of the a8 property.
     * 
     */
    public double getA8() {
        return a8;
    }

    /**
     * Sets the value of the a8 property.
     * 
     */
    public void setA8(double value) {
        this.a8 = value;
    }

    /**
     * Gets the value of the n1 property.
     * 
     */
    public double getN1() {
        return n1;
    }

    /**
     * Sets the value of the n1 property.
     * 
     */
    public void setN1(double value) {
        this.n1 = value;
    }

    /**
     * Gets the value of the n2 property.
     * 
     */
    public double getN2() {
        return n2;
    }

    /**
     * Sets the value of the n2 property.
     * 
     */
    public void setN2(double value) {
        this.n2 = value;
    }

    /**
     * Gets the value of the n3 property.
     * 
     */
    public double getN3() {
        return n3;
    }

    /**
     * Sets the value of the n3 property.
     * 
     */
    public void setN3(double value) {
        this.n3 = value;
    }

    /**
     * Gets the value of the n4 property.
     * 
     */
    public double getN4() {
        return n4;
    }

    /**
     * Sets the value of the n4 property.
     * 
     */
    public void setN4(double value) {
        this.n4 = value;
    }

    /**
     * Gets the value of the n5 property.
     * 
     */
    public double getN5() {
        return n5;
    }

    /**
     * Sets the value of the n5 property.
     * 
     */
    public void setN5(double value) {
        this.n5 = value;
    }

    /**
     * Gets the value of the n6 property.
     * 
     */
    public double getN6() {
        return n6;
    }

    /**
     * Sets the value of the n6 property.
     * 
     */
    public void setN6(double value) {
        this.n6 = value;
    }

    /**
     * Gets the value of the a9 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getA9() {
        return a9;
    }

    /**
     * Sets the value of the a9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setA9(Double value) {
        this.a9 = value;
    }

    /**
     * Gets the value of the a10 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getA10() {
        return a10;
    }

    /**
     * Sets the value of the a10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setA10(Double value) {
        this.a10 = value;
    }

}
