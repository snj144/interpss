//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.13 at 10:08:41 ���� CST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.ieee.odm.schema.Eq1MachineXmlType.SeFmt1;
import org.ieee.odm.schema.Eq1MachineXmlType.SeFmt2;


/**
 * <p>Java class for Eq1MachineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Eq1MachineXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}AbstractMachineXmlType">
 *       &lt;sequence>
 *         &lt;element name="xl" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="x0" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="x2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ra" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="xd" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="xq" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="xd1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Td01" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;choice>
 *           &lt;element name="seFmt1">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="se100" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                     &lt;element name="se120" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                     &lt;element name="sliner" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="seFmt2">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="e1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                     &lt;element name="e2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                     &lt;element name="se1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                     &lt;element name="se2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                     &lt;element name="af" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Eq1MachineXmlType", propOrder = {
    "xl",
    "x0",
    "x2",
    "ra",
    "xd",
    "xq",
    "xd1",
    "td01",
    "seFmt1",
    "seFmt2"
})
public class Eq1MachineXmlType
    extends AbstractMachineXmlType
{

    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double xl;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double x0;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double x2;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double ra;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double xd;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double xq;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double xd1;
    @XmlElement(name = "Td01", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType td01;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected SeFmt1 seFmt1;
    @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
    protected SeFmt2 seFmt2;

    /**
     * Gets the value of the xl property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getXl() {
        return xl;
    }

    /**
     * Sets the value of the xl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setXl(Double value) {
        this.xl = value;
    }

    /**
     * Gets the value of the x0 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getX0() {
        return x0;
    }

    /**
     * Sets the value of the x0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setX0(Double value) {
        this.x0 = value;
    }

    /**
     * Gets the value of the x2 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getX2() {
        return x2;
    }

    /**
     * Sets the value of the x2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setX2(Double value) {
        this.x2 = value;
    }

    /**
     * Gets the value of the ra property.
     * 
     */
    public double getRa() {
        return ra;
    }

    /**
     * Sets the value of the ra property.
     * 
     */
    public void setRa(double value) {
        this.ra = value;
    }

    /**
     * Gets the value of the xd property.
     * 
     */
    public double getXd() {
        return xd;
    }

    /**
     * Sets the value of the xd property.
     * 
     */
    public void setXd(double value) {
        this.xd = value;
    }

    /**
     * Gets the value of the xq property.
     * 
     */
    public double getXq() {
        return xq;
    }

    /**
     * Sets the value of the xq property.
     * 
     */
    public void setXq(double value) {
        this.xq = value;
    }

    /**
     * Gets the value of the xd1 property.
     * 
     */
    public double getXd1() {
        return xd1;
    }

    /**
     * Sets the value of the xd1 property.
     * 
     */
    public void setXd1(double value) {
        this.xd1 = value;
    }

    /**
     * Gets the value of the td01 property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTd01() {
        return td01;
    }

    /**
     * Sets the value of the td01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTd01(TimePeriodXmlType value) {
        this.td01 = value;
    }

    /**
     * Gets the value of the seFmt1 property.
     * 
     * @return
     *     possible object is
     *     {@link SeFmt1 }
     *     
     */
    public SeFmt1 getSeFmt1() {
        return seFmt1;
    }

    /**
     * Sets the value of the seFmt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeFmt1 }
     *     
     */
    public void setSeFmt1(SeFmt1 value) {
        this.seFmt1 = value;
    }

    /**
     * Gets the value of the seFmt2 property.
     * 
     * @return
     *     possible object is
     *     {@link SeFmt2 }
     *     
     */
    public SeFmt2 getSeFmt2() {
        return seFmt2;
    }

    /**
     * Sets the value of the seFmt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeFmt2 }
     *     
     */
    public void setSeFmt2(SeFmt2 value) {
        this.seFmt2 = value;
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
     *         &lt;element name="se100" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="se120" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="sliner" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
        "se100",
        "se120",
        "sliner"
    })
    public static class SeFmt1 {

        @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
        protected double se100;
        @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
        protected double se120;
        @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
        protected double sliner;

        /**
         * Gets the value of the se100 property.
         * 
         */
        public double getSe100() {
            return se100;
        }

        /**
         * Sets the value of the se100 property.
         * 
         */
        public void setSe100(double value) {
            this.se100 = value;
        }

        /**
         * Gets the value of the se120 property.
         * 
         */
        public double getSe120() {
            return se120;
        }

        /**
         * Sets the value of the se120 property.
         * 
         */
        public void setSe120(double value) {
            this.se120 = value;
        }

        /**
         * Gets the value of the sliner property.
         * 
         */
        public double getSliner() {
            return sliner;
        }

        /**
         * Sets the value of the sliner property.
         * 
         */
        public void setSliner(double value) {
            this.sliner = value;
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
     *         &lt;element name="e1" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="e2" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="se1" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="se2" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="af" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "e1",
        "e2",
        "se1",
        "se2",
        "af"
    })
    public static class SeFmt2 {

        @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
        protected double e1;
        @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
        protected double e2;
        @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
        protected double se1;
        @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
        protected double se2;
        @XmlElement(namespace = "http://www.ieee.org/odm/Schema/2008")
        protected Double af;

        /**
         * Gets the value of the e1 property.
         * 
         */
        public double getE1() {
            return e1;
        }

        /**
         * Sets the value of the e1 property.
         * 
         */
        public void setE1(double value) {
            this.e1 = value;
        }

        /**
         * Gets the value of the e2 property.
         * 
         */
        public double getE2() {
            return e2;
        }

        /**
         * Sets the value of the e2 property.
         * 
         */
        public void setE2(double value) {
            this.e2 = value;
        }

        /**
         * Gets the value of the se1 property.
         * 
         */
        public double getSe1() {
            return se1;
        }

        /**
         * Sets the value of the se1 property.
         * 
         */
        public void setSe1(double value) {
            this.se1 = value;
        }

        /**
         * Gets the value of the se2 property.
         * 
         */
        public double getSe2() {
            return se2;
        }

        /**
         * Sets the value of the se2 property.
         * 
         */
        public void setSe2(double value) {
            this.se2 = value;
        }

        /**
         * Gets the value of the af property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getAf() {
            return af;
        }

        /**
         * Sets the value of the af property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setAf(Double value) {
            this.af = value;
        }

    }

}