//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.13 at 10:08:41 ���� CST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		
 * 
 * <p>Java class for PVModelIVFunctionXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PVModelIVFunctionXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BasePVModelXmlType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="c" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="d" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="e" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="f" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="shadingFactor" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="sign" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
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
public class PVModelIVFunctionXmlType
    extends BasePVModelXmlType
{

    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double a;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double b;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double c;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double d;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double e;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double f;
    @XmlAttribute(required = true)
    protected double shadingFactor;
    @XmlAttribute(required = true)
    protected int sign;

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

}
