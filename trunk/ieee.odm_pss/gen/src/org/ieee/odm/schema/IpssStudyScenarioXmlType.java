//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.30 at 03:27:45 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Key concepts:
 * 		- Acsc Fault : defined using Fault Type (BusFault, BranchFault, BranchOutage) and Fault Category (3P, LG, LL, LLG)
 * 		- Dynamic Event : defined using Dynamic Event Type (Fault, LoadChange, SetPointChange). Dynamic Event Fault is then 
 *                           defined using Acsc Fault.
 * 		
 * 
 * <p>Java class for IpssStudyScenarioXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IpssStudyScenarioXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}StudyScenarioXmlType">
 *       &lt;sequence>
 *         &lt;element name="gridRunOption" type="{http://www.ieee.org/odm/Schema/2008}GridComputingXmlType" minOccurs="0"/>
 *         &lt;element name="defaultAclfAlgo" type="{http://www.ieee.org/odm/Schema/2008}AclfAlgorithmXmlType" minOccurs="0"/>
 *         &lt;element name="scenarioList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="scenario" type="{http://www.ieee.org/odm/Schema/2008}ScenarioXmlType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpssStudyScenarioXmlType", propOrder = {
    "gridRunOption",
    "defaultAclfAlgo",
    "scenarioList"
})
public class IpssStudyScenarioXmlType
    extends StudyScenarioXmlType
{

    protected GridComputingXmlType gridRunOption;
    protected AclfAlgorithmXmlType defaultAclfAlgo;
    @XmlElement(required = true)
    protected IpssStudyScenarioXmlType.ScenarioList scenarioList;

    /**
     * Gets the value of the gridRunOption property.
     * 
     * @return
     *     possible object is
     *     {@link GridComputingXmlType }
     *     
     */
    public GridComputingXmlType getGridRunOption() {
        return gridRunOption;
    }

    /**
     * Sets the value of the gridRunOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link GridComputingXmlType }
     *     
     */
    public void setGridRunOption(GridComputingXmlType value) {
        this.gridRunOption = value;
    }

    /**
     * Gets the value of the defaultAclfAlgo property.
     * 
     * @return
     *     possible object is
     *     {@link AclfAlgorithmXmlType }
     *     
     */
    public AclfAlgorithmXmlType getDefaultAclfAlgo() {
        return defaultAclfAlgo;
    }

    /**
     * Sets the value of the defaultAclfAlgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AclfAlgorithmXmlType }
     *     
     */
    public void setDefaultAclfAlgo(AclfAlgorithmXmlType value) {
        this.defaultAclfAlgo = value;
    }

    /**
     * Gets the value of the scenarioList property.
     * 
     * @return
     *     possible object is
     *     {@link IpssStudyScenarioXmlType.ScenarioList }
     *     
     */
    public IpssStudyScenarioXmlType.ScenarioList getScenarioList() {
        return scenarioList;
    }

    /**
     * Sets the value of the scenarioList property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpssStudyScenarioXmlType.ScenarioList }
     *     
     */
    public void setScenarioList(IpssStudyScenarioXmlType.ScenarioList value) {
        this.scenarioList = value;
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
     *         &lt;element name="scenario" type="{http://www.ieee.org/odm/Schema/2008}ScenarioXmlType" maxOccurs="unbounded"/>
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
        "scenario"
    })
    public static class ScenarioList {

        @XmlElement(required = true)
        protected List<ScenarioXmlType> scenario;

        /**
         * Gets the value of the scenario property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the scenario property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getScenario().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ScenarioXmlType }
         * 
         * 
         */
        public List<ScenarioXmlType> getScenario() {
            if (scenario == null) {
                scenario = new ArrayList<ScenarioXmlType>();
            }
            return this.scenario;
        }

    }

}
