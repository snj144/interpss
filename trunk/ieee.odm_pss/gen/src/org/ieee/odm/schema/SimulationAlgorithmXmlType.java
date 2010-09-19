//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.18 at 07:53:49 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimulationAlgorithmXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimulationAlgorithmXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="aclfAnalysis" type="{http://www.ieee.org/odm/Schema/2008}AclfAlgorithmXmlType" minOccurs="0"/>
 *         &lt;element name="acscAnalysis" type="{http://www.ieee.org/odm/Schema/2008}AcscFaultAnalysisXmlType" minOccurs="0"/>
 *         &lt;element name="dStabAnalysis" type="{http://www.ieee.org/odm/Schema/2008}DStabilitySimulationXmlType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimulationAlgorithmXmlType", propOrder = {
    "aclfAnalysis",
    "acscAnalysis",
    "dStabAnalysis"
})
public class SimulationAlgorithmXmlType {

    protected AclfAlgorithmXmlType aclfAnalysis;
    protected AcscFaultAnalysisXmlType acscAnalysis;
    protected DStabilitySimulationXmlType dStabAnalysis;

    /**
     * Gets the value of the aclfAnalysis property.
     * 
     * @return
     *     possible object is
     *     {@link AclfAlgorithmXmlType }
     *     
     */
    public AclfAlgorithmXmlType getAclfAnalysis() {
        return aclfAnalysis;
    }

    /**
     * Sets the value of the aclfAnalysis property.
     * 
     * @param value
     *     allowed object is
     *     {@link AclfAlgorithmXmlType }
     *     
     */
    public void setAclfAnalysis(AclfAlgorithmXmlType value) {
        this.aclfAnalysis = value;
    }

    /**
     * Gets the value of the acscAnalysis property.
     * 
     * @return
     *     possible object is
     *     {@link AcscFaultAnalysisXmlType }
     *     
     */
    public AcscFaultAnalysisXmlType getAcscAnalysis() {
        return acscAnalysis;
    }

    /**
     * Sets the value of the acscAnalysis property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcscFaultAnalysisXmlType }
     *     
     */
    public void setAcscAnalysis(AcscFaultAnalysisXmlType value) {
        this.acscAnalysis = value;
    }

    /**
     * Gets the value of the dStabAnalysis property.
     * 
     * @return
     *     possible object is
     *     {@link DStabilitySimulationXmlType }
     *     
     */
    public DStabilitySimulationXmlType getDStabAnalysis() {
        return dStabAnalysis;
    }

    /**
     * Sets the value of the dStabAnalysis property.
     * 
     * @param value
     *     allowed object is
     *     {@link DStabilitySimulationXmlType }
     *     
     */
    public void setDStabAnalysis(DStabilitySimulationXmlType value) {
        this.dStabAnalysis = value;
    }

}
