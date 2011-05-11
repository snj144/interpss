//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.11 at 02:43:09 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DStabSimulationXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DStabSimulationXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}BaseAnalysisTypeXmlType">
 *       &lt;sequence>
 *         &lt;element name="simulationSetting" type="{http://www.ieee.org/odm/Schema/2008}DStabSimuSettingXmlType"/>
 *         &lt;element name="aclfInitialization" type="{http://www.ieee.org/odm/Schema/2008}AclfAlgorithmXmlType"/>
 *         &lt;element name="dynamicEvents">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="disableDynEvents" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="dynamicEvent" type="{http://www.ieee.org/odm/Schema/2008}DynamicEventXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "DStabSimulationXmlType", propOrder = {
    "simulationSetting",
    "aclfInitialization",
    "dynamicEvents"
})
public class DStabSimulationXmlType
    extends BaseAnalysisTypeXmlType
{

    @XmlElement(required = true)
    protected DStabSimuSettingXmlType simulationSetting;
    @XmlElement(required = true)
    protected AclfAlgorithmXmlType aclfInitialization;
    @XmlElement(required = true)
    protected DStabSimulationXmlType.DynamicEvents dynamicEvents;

    /**
     * Gets the value of the simulationSetting property.
     * 
     * @return
     *     possible object is
     *     {@link DStabSimuSettingXmlType }
     *     
     */
    public DStabSimuSettingXmlType getSimulationSetting() {
        return simulationSetting;
    }

    /**
     * Sets the value of the simulationSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link DStabSimuSettingXmlType }
     *     
     */
    public void setSimulationSetting(DStabSimuSettingXmlType value) {
        this.simulationSetting = value;
    }

    /**
     * Gets the value of the aclfInitialization property.
     * 
     * @return
     *     possible object is
     *     {@link AclfAlgorithmXmlType }
     *     
     */
    public AclfAlgorithmXmlType getAclfInitialization() {
        return aclfInitialization;
    }

    /**
     * Sets the value of the aclfInitialization property.
     * 
     * @param value
     *     allowed object is
     *     {@link AclfAlgorithmXmlType }
     *     
     */
    public void setAclfInitialization(AclfAlgorithmXmlType value) {
        this.aclfInitialization = value;
    }

    /**
     * Gets the value of the dynamicEvents property.
     * 
     * @return
     *     possible object is
     *     {@link DStabSimulationXmlType.DynamicEvents }
     *     
     */
    public DStabSimulationXmlType.DynamicEvents getDynamicEvents() {
        return dynamicEvents;
    }

    /**
     * Sets the value of the dynamicEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link DStabSimulationXmlType.DynamicEvents }
     *     
     */
    public void setDynamicEvents(DStabSimulationXmlType.DynamicEvents value) {
        this.dynamicEvents = value;
    }


    /**
     * 
     *                             when disableDynEvents = true, SetPointChange events might be added. All other 
     *                             dynamic events are ignore.  
     * 							When study SetPointChange dynamic evetns, you must disableDynEvents = true. 
     * 							There should be not be more than one SetPointChange dynamic events
     * 							
     * 
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="disableDynEvents" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="dynamicEvent" type="{http://www.ieee.org/odm/Schema/2008}DynamicEventXmlType" maxOccurs="unbounded" minOccurs="0"/>
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
        "disableDynEvents",
        "dynamicEvent"
    })
    public static class DynamicEvents {

        protected Boolean disableDynEvents;
        protected List<DynamicEventXmlType> dynamicEvent;

        /**
         * Gets the value of the disableDynEvents property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDisableDynEvents() {
            return disableDynEvents;
        }

        /**
         * Sets the value of the disableDynEvents property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDisableDynEvents(Boolean value) {
            this.disableDynEvents = value;
        }

        /**
         * Gets the value of the dynamicEvent property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dynamicEvent property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDynamicEvent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DynamicEventXmlType }
         * 
         * 
         */
        public List<DynamicEventXmlType> getDynamicEvent() {
            if (dynamicEvent == null) {
                dynamicEvent = new ArrayList<DynamicEventXmlType>();
            }
            return this.dynamicEvent;
        }

    }

}
