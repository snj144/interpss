//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.26 at 02:44:35 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AclfAlgorithmXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AclfAlgorithmXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseAnalysisTypeXmlType">
 *       &lt;sequence>
 *         &lt;element name="lfMethod" type="{http://www.ieee.org/odm/Schema/2008}LfMethodEnumType"/>
 *         &lt;element name="maxIterations" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tolerance" type="{http://www.ieee.org/odm/Schema/2008}ApparentPowerXmlType"/>
 *         &lt;element name="initBusVoltage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="accFactor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="nonDivergent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AclfAlgorithmXmlType", propOrder = {
    "lfMethod",
    "maxIterations",
    "tolerance",
    "initBusVoltage",
    "accFactor",
    "nonDivergent"
})
public class AclfAlgorithmXmlType
    extends BaseAnalysisTypeXmlType
{

    @XmlElement(required = true)
    protected LfMethodEnumType lfMethod;
    protected int maxIterations;
    @XmlElement(required = true)
    protected ApparentPowerXmlType tolerance;
    protected Boolean initBusVoltage;
    protected Double accFactor;
    protected Boolean nonDivergent;

    /**
     * Gets the value of the lfMethod property.
     * 
     * @return
     *     possible object is
     *     {@link LfMethodEnumType }
     *     
     */
    public LfMethodEnumType getLfMethod() {
        return lfMethod;
    }

    /**
     * Sets the value of the lfMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link LfMethodEnumType }
     *     
     */
    public void setLfMethod(LfMethodEnumType value) {
        this.lfMethod = value;
    }

    /**
     * Gets the value of the maxIterations property.
     * 
     */
    public int getMaxIterations() {
        return maxIterations;
    }

    /**
     * Sets the value of the maxIterations property.
     * 
     */
    public void setMaxIterations(int value) {
        this.maxIterations = value;
    }

    /**
     * Gets the value of the tolerance property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public ApparentPowerXmlType getTolerance() {
        return tolerance;
    }

    /**
     * Sets the value of the tolerance property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPowerXmlType }
     *     
     */
    public void setTolerance(ApparentPowerXmlType value) {
        this.tolerance = value;
    }

    /**
     * Gets the value of the initBusVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInitBusVoltage() {
        return initBusVoltage;
    }

    /**
     * Sets the value of the initBusVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInitBusVoltage(Boolean value) {
        this.initBusVoltage = value;
    }

    /**
     * Gets the value of the accFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAccFactor() {
        return accFactor;
    }

    /**
     * Sets the value of the accFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAccFactor(Double value) {
        this.accFactor = value;
    }

    /**
     * Gets the value of the nonDivergent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNonDivergent() {
        return nonDivergent;
    }

    /**
     * Sets the value of the nonDivergent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNonDivergent(Boolean value) {
        this.nonDivergent = value;
    }

}
