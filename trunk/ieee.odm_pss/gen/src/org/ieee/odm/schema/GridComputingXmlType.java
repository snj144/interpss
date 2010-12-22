//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.21 at 03:20:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GridComputingXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GridComputingXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableGridRun" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="remoteJobCreation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="timeout" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="remoteNodeDebug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="remoteNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aclfOption" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="returnStudyCase">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="AllStudyCase"/>
 *                         &lt;enumeration value="DivergedCase"/>
 *                         &lt;enumeration value="NoReturn"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="calculateViolation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="busVoltagePULimit" type="{http://www.ieee.org/odm/Schema/2008}LimitXmlType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GridComputingXmlType", propOrder = {
    "enableGridRun",
    "remoteJobCreation",
    "timeout",
    "remoteNodeDebug",
    "remoteNodeName",
    "aclfOption"
})
public class GridComputingXmlType {

    protected boolean enableGridRun;
    protected Boolean remoteJobCreation;
    protected Long timeout;
    protected Boolean remoteNodeDebug;
    protected String remoteNodeName;
    protected GridComputingXmlType.AclfOption aclfOption;

    /**
     * Gets the value of the enableGridRun property.
     * 
     */
    public boolean isEnableGridRun() {
        return enableGridRun;
    }

    /**
     * Sets the value of the enableGridRun property.
     * 
     */
    public void setEnableGridRun(boolean value) {
        this.enableGridRun = value;
    }

    /**
     * Gets the value of the remoteJobCreation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRemoteJobCreation() {
        return remoteJobCreation;
    }

    /**
     * Sets the value of the remoteJobCreation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRemoteJobCreation(Boolean value) {
        this.remoteJobCreation = value;
    }

    /**
     * Gets the value of the timeout property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeout() {
        return timeout;
    }

    /**
     * Sets the value of the timeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeout(Long value) {
        this.timeout = value;
    }

    /**
     * Gets the value of the remoteNodeDebug property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRemoteNodeDebug() {
        return remoteNodeDebug;
    }

    /**
     * Sets the value of the remoteNodeDebug property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRemoteNodeDebug(Boolean value) {
        this.remoteNodeDebug = value;
    }

    /**
     * Gets the value of the remoteNodeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteNodeName() {
        return remoteNodeName;
    }

    /**
     * Sets the value of the remoteNodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteNodeName(String value) {
        this.remoteNodeName = value;
    }

    /**
     * Gets the value of the aclfOption property.
     * 
     * @return
     *     possible object is
     *     {@link GridComputingXmlType.AclfOption }
     *     
     */
    public GridComputingXmlType.AclfOption getAclfOption() {
        return aclfOption;
    }

    /**
     * Sets the value of the aclfOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link GridComputingXmlType.AclfOption }
     *     
     */
    public void setAclfOption(GridComputingXmlType.AclfOption value) {
        this.aclfOption = value;
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
     *         &lt;element name="returnStudyCase">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="AllStudyCase"/>
     *               &lt;enumeration value="DivergedCase"/>
     *               &lt;enumeration value="NoReturn"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="calculateViolation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="busVoltagePULimit" type="{http://www.ieee.org/odm/Schema/2008}LimitXmlType" minOccurs="0"/>
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
        "returnStudyCase",
        "calculateViolation",
        "busVoltagePULimit"
    })
    public static class AclfOption {

        @XmlElement(required = true)
        protected String returnStudyCase;
        protected Boolean calculateViolation;
        protected LimitXmlType busVoltagePULimit;

        /**
         * Gets the value of the returnStudyCase property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReturnStudyCase() {
            return returnStudyCase;
        }

        /**
         * Sets the value of the returnStudyCase property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReturnStudyCase(String value) {
            this.returnStudyCase = value;
        }

        /**
         * Gets the value of the calculateViolation property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCalculateViolation() {
            return calculateViolation;
        }

        /**
         * Sets the value of the calculateViolation property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCalculateViolation(Boolean value) {
            this.calculateViolation = value;
        }

        /**
         * Gets the value of the busVoltagePULimit property.
         * 
         * @return
         *     possible object is
         *     {@link LimitXmlType }
         *     
         */
        public LimitXmlType getBusVoltagePULimit() {
            return busVoltagePULimit;
        }

        /**
         * Sets the value of the busVoltagePULimit property.
         * 
         * @param value
         *     allowed object is
         *     {@link LimitXmlType }
         *     
         */
        public void setBusVoltagePULimit(LimitXmlType value) {
            this.busVoltagePULimit = value;
        }

    }

}
