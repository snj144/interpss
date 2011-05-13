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


/**
 * <p>Java class for ExcBPAFQXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExcBPAFQXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}ExcSimpleTypeXmlType">
 *       &lt;sequence>
 *         &lt;element name="K" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KV" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T1" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T2" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="VA1MAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VA1MIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T3" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="T4" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="VAMAX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VAMIN" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KF" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TF" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="KH" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KB" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="T5" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="KE" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TE" type="{http://www.ieee.org/odm/Schema/2008}TimePeriodXmlType"/>
 *         &lt;element name="E1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SE1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="E2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="SE2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KC" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KD" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="KL1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="VL1R" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="EFDmax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExcBPAFQXmlType", propOrder = {
    "k",
    "kv",
    "t1",
    "t2",
    "va1MAX",
    "va1MIN",
    "t3",
    "t4",
    "vamax",
    "vamin",
    "kf",
    "tf",
    "kh",
    "kb",
    "t5",
    "ke",
    "te",
    "e1",
    "se1",
    "e2",
    "se2",
    "kc",
    "kd",
    "kl1",
    "vl1R",
    "efDmax"
})
public class ExcBPAFQXmlType
    extends ExcSimpleTypeXmlType
{

    @XmlElement(name = "K", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double k;
    @XmlElement(name = "KV", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kv;
    @XmlElement(name = "T1", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType t1;
    @XmlElement(name = "T2", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType t2;
    @XmlElement(name = "VA1MAX", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double va1MAX;
    @XmlElement(name = "VA1MIN", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double va1MIN;
    @XmlElement(name = "T3", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType t3;
    @XmlElement(name = "T4", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType t4;
    @XmlElement(name = "VAMAX", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double vamax;
    @XmlElement(name = "VAMIN", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double vamin;
    @XmlElement(name = "KF", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kf;
    @XmlElement(name = "TF", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType tf;
    @XmlElement(name = "KH", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kh;
    @XmlElement(name = "KB", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kb;
    @XmlElement(name = "T5", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType t5;
    @XmlElement(name = "KE", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double ke;
    @XmlElement(name = "TE", namespace = "http://www.ieee.org/odm/Schema/2008", required = true)
    protected TimePeriodXmlType te;
    @XmlElement(name = "E1", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double e1;
    @XmlElement(name = "SE1", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double se1;
    @XmlElement(name = "E2", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected Double e2;
    @XmlElement(name = "SE2", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double se2;
    @XmlElement(name = "KC", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kc;
    @XmlElement(name = "KD", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kd;
    @XmlElement(name = "KL1", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double kl1;
    @XmlElement(name = "VL1R", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double vl1R;
    @XmlElement(name = "EFDmax", namespace = "http://www.ieee.org/odm/Schema/2008")
    protected double efDmax;

    /**
     * Gets the value of the k property.
     * 
     */
    public double getK() {
        return k;
    }

    /**
     * Sets the value of the k property.
     * 
     */
    public void setK(double value) {
        this.k = value;
    }

    /**
     * Gets the value of the kv property.
     * 
     */
    public double getKV() {
        return kv;
    }

    /**
     * Sets the value of the kv property.
     * 
     */
    public void setKV(double value) {
        this.kv = value;
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
     * Gets the value of the va1MAX property.
     * 
     */
    public double getVA1MAX() {
        return va1MAX;
    }

    /**
     * Sets the value of the va1MAX property.
     * 
     */
    public void setVA1MAX(double value) {
        this.va1MAX = value;
    }

    /**
     * Gets the value of the va1MIN property.
     * 
     */
    public double getVA1MIN() {
        return va1MIN;
    }

    /**
     * Sets the value of the va1MIN property.
     * 
     */
    public void setVA1MIN(double value) {
        this.va1MIN = value;
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
     * Gets the value of the vamax property.
     * 
     */
    public double getVAMAX() {
        return vamax;
    }

    /**
     * Sets the value of the vamax property.
     * 
     */
    public void setVAMAX(double value) {
        this.vamax = value;
    }

    /**
     * Gets the value of the vamin property.
     * 
     */
    public double getVAMIN() {
        return vamin;
    }

    /**
     * Sets the value of the vamin property.
     * 
     */
    public void setVAMIN(double value) {
        this.vamin = value;
    }

    /**
     * Gets the value of the kf property.
     * 
     */
    public double getKF() {
        return kf;
    }

    /**
     * Sets the value of the kf property.
     * 
     */
    public void setKF(double value) {
        this.kf = value;
    }

    /**
     * Gets the value of the tf property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTF() {
        return tf;
    }

    /**
     * Sets the value of the tf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTF(TimePeriodXmlType value) {
        this.tf = value;
    }

    /**
     * Gets the value of the kh property.
     * 
     */
    public double getKH() {
        return kh;
    }

    /**
     * Sets the value of the kh property.
     * 
     */
    public void setKH(double value) {
        this.kh = value;
    }

    /**
     * Gets the value of the kb property.
     * 
     */
    public double getKB() {
        return kb;
    }

    /**
     * Sets the value of the kb property.
     * 
     */
    public void setKB(double value) {
        this.kb = value;
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
     * Gets the value of the ke property.
     * 
     */
    public double getKE() {
        return ke;
    }

    /**
     * Sets the value of the ke property.
     * 
     */
    public void setKE(double value) {
        this.ke = value;
    }

    /**
     * Gets the value of the te property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public TimePeriodXmlType getTE() {
        return te;
    }

    /**
     * Sets the value of the te property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodXmlType }
     *     
     */
    public void setTE(TimePeriodXmlType value) {
        this.te = value;
    }

    /**
     * Gets the value of the e1 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getE1() {
        return e1;
    }

    /**
     * Sets the value of the e1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setE1(Double value) {
        this.e1 = value;
    }

    /**
     * Gets the value of the se1 property.
     * 
     */
    public double getSE1() {
        return se1;
    }

    /**
     * Sets the value of the se1 property.
     * 
     */
    public void setSE1(double value) {
        this.se1 = value;
    }

    /**
     * Gets the value of the e2 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getE2() {
        return e2;
    }

    /**
     * Sets the value of the e2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setE2(Double value) {
        this.e2 = value;
    }

    /**
     * Gets the value of the se2 property.
     * 
     */
    public double getSE2() {
        return se2;
    }

    /**
     * Sets the value of the se2 property.
     * 
     */
    public void setSE2(double value) {
        this.se2 = value;
    }

    /**
     * Gets the value of the kc property.
     * 
     */
    public double getKC() {
        return kc;
    }

    /**
     * Sets the value of the kc property.
     * 
     */
    public void setKC(double value) {
        this.kc = value;
    }

    /**
     * Gets the value of the kd property.
     * 
     */
    public double getKD() {
        return kd;
    }

    /**
     * Sets the value of the kd property.
     * 
     */
    public void setKD(double value) {
        this.kd = value;
    }

    /**
     * Gets the value of the kl1 property.
     * 
     */
    public double getKL1() {
        return kl1;
    }

    /**
     * Sets the value of the kl1 property.
     * 
     */
    public void setKL1(double value) {
        this.kl1 = value;
    }

    /**
     * Gets the value of the vl1R property.
     * 
     */
    public double getVL1R() {
        return vl1R;
    }

    /**
     * Sets the value of the vl1R property.
     * 
     */
    public void setVL1R(double value) {
        this.vl1R = value;
    }

    /**
     * Gets the value of the efDmax property.
     * 
     */
    public double getEFDmax() {
        return efDmax;
    }

    /**
     * Sets the value of the efDmax property.
     * 
     */
    public void setEFDmax(double value) {
        this.efDmax = value;
    }

}
