//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.01 at 07:21:18 AM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Java class for InverterLossEqnXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InverterLossEqnXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="a1" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="a2" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="b1" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="b2" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="c1" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="c2" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InverterLossEqnXmlType")
public class InverterLossEqnXmlType {

    @XmlAttribute(required = true)
    protected double a1;
    @XmlAttribute(required = true)
    protected double a2;
    @XmlAttribute(required = true)
    protected double b1;
    @XmlAttribute(required = true)
    protected double b2;
    @XmlAttribute(required = true)
    protected double c1;
    @XmlAttribute(required = true)
    protected double c2;

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
     * Gets the value of the b1 property.
     * 
     */
    public double getB1() {
        return b1;
    }

    /**
     * Sets the value of the b1 property.
     * 
     */
    public void setB1(double value) {
        this.b1 = value;
    }

    /**
     * Gets the value of the b2 property.
     * 
     */
    public double getB2() {
        return b2;
    }

    /**
     * Sets the value of the b2 property.
     * 
     */
    public void setB2(double value) {
        this.b2 = value;
    }

    /**
     * Gets the value of the c1 property.
     * 
     */
    public double getC1() {
        return c1;
    }

    /**
     * Sets the value of the c1 property.
     * 
     */
    public void setC1(double value) {
        this.c1 = value;
    }

    /**
     * Gets the value of the c2 property.
     * 
     */
    public double getC2() {
        return c2;
    }

    /**
     * Sets the value of the c2 property.
     * 
     */
    public void setC2(double value) {
        this.c2 = value;
    }

}
