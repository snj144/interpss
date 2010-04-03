//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.03 at 12:10:58 PM PDT 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * for define a study scenario. In addtion to the modification defined at the StudyCase level, modification can be also defined at each scenario level
 * 
 * <p>Java class for ScenarioXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScenarioXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema}IDRecordXmlType">
 *       &lt;sequence>
 *         &lt;element name="analysisCategory" type="{http://www.ieee.org/odm/Schema}AnalysisCategoryEnumType"/>
 *         &lt;element name="modifcation" type="{http://www.ieee.org/odm/Schema}ModifyRecordXmlType" minOccurs="0"/>
 *         &lt;element name="transientSimlation" type="{http://www.ieee.org/odm/Schema}TransientSimulationXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScenarioXmlType", propOrder = {
    "analysisCategory",
    "modifcation",
    "transientSimlation"
})
public class ScenarioXmlType
    extends IDRecordXmlType
{

    @XmlElement(required = true)
    protected AnalysisCategoryEnumType analysisCategory;
    protected ModifyRecordXmlType modifcation;
    protected TransientSimulationXmlType transientSimlation;

    /**
     * Gets the value of the analysisCategory property.
     * 
     * @return
     *     possible object is
     *     {@link AnalysisCategoryEnumType }
     *     
     */
    public AnalysisCategoryEnumType getAnalysisCategory() {
        return analysisCategory;
    }

    /**
     * Sets the value of the analysisCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnalysisCategoryEnumType }
     *     
     */
    public void setAnalysisCategory(AnalysisCategoryEnumType value) {
        this.analysisCategory = value;
    }

    /**
     * Gets the value of the modifcation property.
     * 
     * @return
     *     possible object is
     *     {@link ModifyRecordXmlType }
     *     
     */
    public ModifyRecordXmlType getModifcation() {
        return modifcation;
    }

    /**
     * Sets the value of the modifcation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyRecordXmlType }
     *     
     */
    public void setModifcation(ModifyRecordXmlType value) {
        this.modifcation = value;
    }

    /**
     * Gets the value of the transientSimlation property.
     * 
     * @return
     *     possible object is
     *     {@link TransientSimulationXmlType }
     *     
     */
    public TransientSimulationXmlType getTransientSimlation() {
        return transientSimlation;
    }

    /**
     * Sets the value of the transientSimlation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransientSimulationXmlType }
     *     
     */
    public void setTransientSimlation(TransientSimulationXmlType value) {
        this.transientSimlation = value;
    }

}
