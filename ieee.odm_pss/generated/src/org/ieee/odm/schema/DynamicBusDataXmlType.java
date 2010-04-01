//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.03.31 at 08:21:02 PM PDT 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicBusDataXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicBusDataXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="machineList" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="machine" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}MachineXmlType"/>
 *                   &lt;element name="exciter" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="exciterType">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="IEEE1992TypeAC1A"/>
 *                                   &lt;enumeration value="IEEE1981TypeAC2"/>
 *                                   &lt;enumeration value="IEEE1981ST1"/>
 *                                   &lt;enumeration value="BPAFJ"/>
 *                                   &lt;enumeration value="IEEE1968Type1"/>
 *                                   &lt;enumeration value="IEEEModified1968Type1"/>
 *                                   &lt;enumeration value="IEEE1981NewExcSystem"/>
 *                                   &lt;enumeration value="IEEETypeDC2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="exciterModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}ExciterModelSelectionXmlType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="governor" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="governorType">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="IEEE1981Type1"/>
 *                                   &lt;enumeration value="IEEE1981Type2"/>
 *                                   &lt;enumeration value="IEEE1981Type3"/>
 *                                   &lt;enumeration value="hydroStreamGeneralModel"/>
 *                                   &lt;enumeration value="hydroGovernerAndTurbine"/>
 *                                   &lt;enumeration value="hydroGoverner"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="governorModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}TurbineGovernorModelSelectionXmlType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="stabilizer" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="stabilizerType">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="IEEE1981Type"/>
 *                                   &lt;enumeration value="IEEE1982Type2A"/>
 *                                   &lt;enumeration value="IEE2ST"/>
 *                                   &lt;enumeration value="IEEEDualInput"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="stabilizerModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}StabilizerModelSelectionXmlType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dynamicLoad" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="location">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="atBus"/>
 *                         &lt;enumeration value="atOwner"/>
 *                         &lt;enumeration value="atZone"/>
 *                         &lt;enumeration value="atArea"/>
 *                         &lt;enumeration value="other"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LoadXmlType">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="IEEEStaticLoad"/>
 *                         &lt;enumeration value="ComplexLoad"/>
 *                         &lt;enumeration value="InductionMotor"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LoadModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}DynamicLoadModelSelectionXmlType"/>
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
@XmlType(name = "DynamicBusDataXmlType", propOrder = {
    "machineList",
    "dynamicLoad"
})
public class DynamicBusDataXmlType {

    protected List<DynamicBusDataXmlType.MachineList> machineList;
    protected DynamicBusDataXmlType.DynamicLoad dynamicLoad;

    /**
     * Gets the value of the machineList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the machineList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMachineList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DynamicBusDataXmlType.MachineList }
     * 
     * 
     */
    public List<DynamicBusDataXmlType.MachineList> getMachineList() {
        if (machineList == null) {
            machineList = new ArrayList<DynamicBusDataXmlType.MachineList>();
        }
        return this.machineList;
    }

    /**
     * Gets the value of the dynamicLoad property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicBusDataXmlType.DynamicLoad }
     *     
     */
    public DynamicBusDataXmlType.DynamicLoad getDynamicLoad() {
        return dynamicLoad;
    }

    /**
     * Sets the value of the dynamicLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicBusDataXmlType.DynamicLoad }
     *     
     */
    public void setDynamicLoad(DynamicBusDataXmlType.DynamicLoad value) {
        this.dynamicLoad = value;
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
     *         &lt;element name="location">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="atBus"/>
     *               &lt;enumeration value="atOwner"/>
     *               &lt;enumeration value="atZone"/>
     *               &lt;enumeration value="atArea"/>
     *               &lt;enumeration value="other"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LoadXmlType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="IEEEStaticLoad"/>
     *               &lt;enumeration value="ComplexLoad"/>
     *               &lt;enumeration value="InductionMotor"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LoadModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}DynamicLoadModelSelectionXmlType"/>
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
        "location",
        "loadXmlType",
        "loadModel"
    })
    public static class DynamicLoad {

        @XmlElement(required = true)
        protected String location;
        @XmlElement(name = "LoadXmlType", required = true)
        protected String loadXmlType;
        @XmlElement(name = "LoadModel", required = true)
        protected DynamicLoadModelSelectionXmlType loadModel;

        /**
         * Gets the value of the location property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocation() {
            return location;
        }

        /**
         * Sets the value of the location property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocation(String value) {
            this.location = value;
        }

        /**
         * Gets the value of the loadXmlType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLoadXmlType() {
            return loadXmlType;
        }

        /**
         * Sets the value of the loadXmlType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLoadXmlType(String value) {
            this.loadXmlType = value;
        }

        /**
         * Gets the value of the loadModel property.
         * 
         * @return
         *     possible object is
         *     {@link DynamicLoadModelSelectionXmlType }
         *     
         */
        public DynamicLoadModelSelectionXmlType getLoadModel() {
            return loadModel;
        }

        /**
         * Sets the value of the loadModel property.
         * 
         * @param value
         *     allowed object is
         *     {@link DynamicLoadModelSelectionXmlType }
         *     
         */
        public void setLoadModel(DynamicLoadModelSelectionXmlType value) {
            this.loadModel = value;
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
     *         &lt;element name="machine" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}MachineXmlType"/>
     *         &lt;element name="exciter" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="exciterType">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="IEEE1992TypeAC1A"/>
     *                         &lt;enumeration value="IEEE1981TypeAC2"/>
     *                         &lt;enumeration value="IEEE1981ST1"/>
     *                         &lt;enumeration value="BPAFJ"/>
     *                         &lt;enumeration value="IEEE1968Type1"/>
     *                         &lt;enumeration value="IEEEModified1968Type1"/>
     *                         &lt;enumeration value="IEEE1981NewExcSystem"/>
     *                         &lt;enumeration value="IEEETypeDC2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="exciterModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}ExciterModelSelectionXmlType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="governor" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="governorType">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="IEEE1981Type1"/>
     *                         &lt;enumeration value="IEEE1981Type2"/>
     *                         &lt;enumeration value="IEEE1981Type3"/>
     *                         &lt;enumeration value="hydroStreamGeneralModel"/>
     *                         &lt;enumeration value="hydroGovernerAndTurbine"/>
     *                         &lt;enumeration value="hydroGoverner"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="governorModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}TurbineGovernorModelSelectionXmlType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="stabilizer" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="stabilizerType">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="IEEE1981Type"/>
     *                         &lt;enumeration value="IEEE1982Type2A"/>
     *                         &lt;enumeration value="IEE2ST"/>
     *                         &lt;enumeration value="IEEEDualInput"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="stabilizerModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}StabilizerModelSelectionXmlType"/>
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
    @XmlType(name = "", propOrder = {
        "machine",
        "exciter",
        "governor",
        "stabilizer"
    })
    public static class MachineList {

        @XmlElement(required = true)
        protected MachineXmlType machine;
        protected DynamicBusDataXmlType.MachineList.Exciter exciter;
        protected DynamicBusDataXmlType.MachineList.Governor governor;
        protected DynamicBusDataXmlType.MachineList.Stabilizer stabilizer;

        /**
         * Gets the value of the machine property.
         * 
         * @return
         *     possible object is
         *     {@link MachineXmlType }
         *     
         */
        public MachineXmlType getMachine() {
            return machine;
        }

        /**
         * Sets the value of the machine property.
         * 
         * @param value
         *     allowed object is
         *     {@link MachineXmlType }
         *     
         */
        public void setMachine(MachineXmlType value) {
            this.machine = value;
        }

        /**
         * Gets the value of the exciter property.
         * 
         * @return
         *     possible object is
         *     {@link DynamicBusDataXmlType.MachineList.Exciter }
         *     
         */
        public DynamicBusDataXmlType.MachineList.Exciter getExciter() {
            return exciter;
        }

        /**
         * Sets the value of the exciter property.
         * 
         * @param value
         *     allowed object is
         *     {@link DynamicBusDataXmlType.MachineList.Exciter }
         *     
         */
        public void setExciter(DynamicBusDataXmlType.MachineList.Exciter value) {
            this.exciter = value;
        }

        /**
         * Gets the value of the governor property.
         * 
         * @return
         *     possible object is
         *     {@link DynamicBusDataXmlType.MachineList.Governor }
         *     
         */
        public DynamicBusDataXmlType.MachineList.Governor getGovernor() {
            return governor;
        }

        /**
         * Sets the value of the governor property.
         * 
         * @param value
         *     allowed object is
         *     {@link DynamicBusDataXmlType.MachineList.Governor }
         *     
         */
        public void setGovernor(DynamicBusDataXmlType.MachineList.Governor value) {
            this.governor = value;
        }

        /**
         * Gets the value of the stabilizer property.
         * 
         * @return
         *     possible object is
         *     {@link DynamicBusDataXmlType.MachineList.Stabilizer }
         *     
         */
        public DynamicBusDataXmlType.MachineList.Stabilizer getStabilizer() {
            return stabilizer;
        }

        /**
         * Sets the value of the stabilizer property.
         * 
         * @param value
         *     allowed object is
         *     {@link DynamicBusDataXmlType.MachineList.Stabilizer }
         *     
         */
        public void setStabilizer(DynamicBusDataXmlType.MachineList.Stabilizer value) {
            this.stabilizer = value;
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
         *         &lt;element name="exciterType">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="IEEE1992TypeAC1A"/>
         *               &lt;enumeration value="IEEE1981TypeAC2"/>
         *               &lt;enumeration value="IEEE1981ST1"/>
         *               &lt;enumeration value="BPAFJ"/>
         *               &lt;enumeration value="IEEE1968Type1"/>
         *               &lt;enumeration value="IEEEModified1968Type1"/>
         *               &lt;enumeration value="IEEE1981NewExcSystem"/>
         *               &lt;enumeration value="IEEETypeDC2"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="exciterModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}ExciterModelSelectionXmlType"/>
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
            "exciterType",
            "exciterModel"
        })
        public static class Exciter {

            @XmlElement(required = true)
            protected String exciterType;
            @XmlElement(required = true)
            protected ExciterModelSelectionXmlType exciterModel;

            /**
             * Gets the value of the exciterType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExciterType() {
                return exciterType;
            }

            /**
             * Sets the value of the exciterType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExciterType(String value) {
                this.exciterType = value;
            }

            /**
             * Gets the value of the exciterModel property.
             * 
             * @return
             *     possible object is
             *     {@link ExciterModelSelectionXmlType }
             *     
             */
            public ExciterModelSelectionXmlType getExciterModel() {
                return exciterModel;
            }

            /**
             * Sets the value of the exciterModel property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExciterModelSelectionXmlType }
             *     
             */
            public void setExciterModel(ExciterModelSelectionXmlType value) {
                this.exciterModel = value;
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
         *         &lt;element name="governorType">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="IEEE1981Type1"/>
         *               &lt;enumeration value="IEEE1981Type2"/>
         *               &lt;enumeration value="IEEE1981Type3"/>
         *               &lt;enumeration value="hydroStreamGeneralModel"/>
         *               &lt;enumeration value="hydroGovernerAndTurbine"/>
         *               &lt;enumeration value="hydroGoverner"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="governorModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}TurbineGovernorModelSelectionXmlType"/>
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
            "governorType",
            "governorModel"
        })
        public static class Governor {

            @XmlElement(required = true)
            protected String governorType;
            @XmlElement(required = true)
            protected TurbineGovernorModelSelectionXmlType governorModel;

            /**
             * Gets the value of the governorType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGovernorType() {
                return governorType;
            }

            /**
             * Sets the value of the governorType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGovernorType(String value) {
                this.governorType = value;
            }

            /**
             * Gets the value of the governorModel property.
             * 
             * @return
             *     possible object is
             *     {@link TurbineGovernorModelSelectionXmlType }
             *     
             */
            public TurbineGovernorModelSelectionXmlType getGovernorModel() {
                return governorModel;
            }

            /**
             * Sets the value of the governorModel property.
             * 
             * @param value
             *     allowed object is
             *     {@link TurbineGovernorModelSelectionXmlType }
             *     
             */
            public void setGovernorModel(TurbineGovernorModelSelectionXmlType value) {
                this.governorModel = value;
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
         *         &lt;element name="stabilizerType">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="IEEE1981Type"/>
         *               &lt;enumeration value="IEEE1982Type2A"/>
         *               &lt;enumeration value="IEE2ST"/>
         *               &lt;enumeration value="IEEEDualInput"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="stabilizerModel" type="{http://www.ieee.org/cmte/psace/oss/odm/pss/Schema/v1}StabilizerModelSelectionXmlType"/>
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
            "stabilizerType",
            "stabilizerModel"
        })
        public static class Stabilizer {

            @XmlElement(required = true)
            protected String stabilizerType;
            @XmlElement(required = true)
            protected StabilizerModelSelectionXmlType stabilizerModel;

            /**
             * Gets the value of the stabilizerType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStabilizerType() {
                return stabilizerType;
            }

            /**
             * Sets the value of the stabilizerType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStabilizerType(String value) {
                this.stabilizerType = value;
            }

            /**
             * Gets the value of the stabilizerModel property.
             * 
             * @return
             *     possible object is
             *     {@link StabilizerModelSelectionXmlType }
             *     
             */
            public StabilizerModelSelectionXmlType getStabilizerModel() {
                return stabilizerModel;
            }

            /**
             * Sets the value of the stabilizerModel property.
             * 
             * @param value
             *     allowed object is
             *     {@link StabilizerModelSelectionXmlType }
             *     
             */
            public void setStabilizerModel(StabilizerModelSelectionXmlType value) {
                this.stabilizerModel = value;
            }

        }

    }

}
