//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.09 at 02:27:16 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PVModelIVFunctionXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PVModelIVFunctionXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="c" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="d" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="e" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="f" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sign" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="shadingFactor" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PVModelIVFunctionXmlType", propOrder = {
    "a",
    "b",
    "c",
    "d",
    "e",
    "f"
})
public class PVModelIVFunctionXmlType {

    protected double a;
    protected double b;
    protected double c;
    protected double d;
    protected double e;
    protected double f;
    @XmlAttribute(required = true)
    protected int sign;
    @XmlAttribute(required = true)
    protected double shadingFactor;

    /**
     * Gets the value of the a property.
     * 
     */
    public double getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     */
    public void setA(double value) {
        this.a = value;
    }

    /**
     * Gets the value of the b property.
     * 
     */
    public double getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     */
    public void setB(double value) {
        this.b = value;
    }

    /**
     * Gets the value of the c property.
     * 
     */
    public double getC() {
        return c;
    }

    /**
     * Sets the value of the c property.
     * 
     */
    public void setC(double value) {
        this.c = value;
    }

    /**
     * Gets the value of the d property.
     * 
     */
    public double getD() {
        return d;
    }

    /**
     * Sets the value of the d property.
     * 
     */
    public void setD(double value) {
        this.d = value;
    }

    /**
     * Gets the value of the e property.
     * 
     */
    public double getE() {
        return e;
    }

    /**
     * Sets the value of the e property.
     * 
     */
    public void setE(double value) {
        this.e = value;
    }

    /**
     * Gets the value of the f property.
     * 
     */
    public double getF() {
        return f;
    }

    /**
     * Sets the value of the f property.
     * 
     */
    public void setF(double value) {
        this.f = value;
    }

    /**
     * Gets the value of the sign property.
     * 
     */
    public int getSign() {
        return sign;
    }

    /**
     * Sets the value of the sign property.
     * 
     */
    public void setSign(int value) {
        this.sign = value;
    }

    /**
     * Gets the value of the shadingFactor property.
     * 
     */
    public double getShadingFactor() {
        return shadingFactor;
    }

    /**
     * Sets the value of the shadingFactor property.
     * 
     */
    public void setShadingFactor(double value) {
        this.shadingFactor = value;
    }

}
