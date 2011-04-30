//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.29 at 11:34:17 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		for define a study scenario. 
 * 		
 * 
 * <p>Java class for ScenarioXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScenarioXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}IDRecordXmlType">
 *       &lt;sequence>
 *         &lt;element name="modifcation" type="{http://www.ieee.org/odm/Schema/2008}ModifyRecordXmlType" minOccurs="0"/>
 *         &lt;element name="simuAlgo" type="{http://www.ieee.org/odm/Schema/2008}SimulationAlgorithmXmlType"/>
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
    "modifcation",
    "simuAlgo"
})
public class ScenarioXmlType
    extends IDRecordXmlType
{

    protected ModifyRecordXmlType modifcation;
    @XmlElement(required = true)
    protected SimulationAlgorithmXmlType simuAlgo;

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
     * Gets the value of the simuAlgo property.
     * 
     * @return
     *     possible object is
     *     {@link SimulationAlgorithmXmlType }
     *     
     */
    public SimulationAlgorithmXmlType getSimuAlgo() {
        return simuAlgo;
    }

    /**
     * Sets the value of the simuAlgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimulationAlgorithmXmlType }
     *     
     */
    public void setSimuAlgo(SimulationAlgorithmXmlType value) {
        this.simuAlgo = value;
    }

}
