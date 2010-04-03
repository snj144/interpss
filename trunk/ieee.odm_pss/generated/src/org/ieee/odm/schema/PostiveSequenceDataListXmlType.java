//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.03 at 12:10:58 PM PDT 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PostiveSequenceDataListXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostiveSequenceDataListXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="generatorPostiveList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="gerneratorPostive" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="busId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
 *                             &lt;element name="macId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType" minOccurs="0"/>
 *                             &lt;element name="ZRPos" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="ZXPos" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostiveSequenceDataListXmlType", propOrder = {
    "generatorPostiveList"
})
public class PostiveSequenceDataListXmlType {

    protected PostiveSequenceDataListXmlType.GeneratorPostiveList generatorPostiveList;

    /**
     * Gets the value of the generatorPostiveList property.
     * 
     * @return
     *     possible object is
     *     {@link PostiveSequenceDataListXmlType.GeneratorPostiveList }
     *     
     */
    public PostiveSequenceDataListXmlType.GeneratorPostiveList getGeneratorPostiveList() {
        return generatorPostiveList;
    }

    /**
     * Sets the value of the generatorPostiveList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostiveSequenceDataListXmlType.GeneratorPostiveList }
     *     
     */
    public void setGeneratorPostiveList(PostiveSequenceDataListXmlType.GeneratorPostiveList value) {
        this.generatorPostiveList = value;
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
     *         &lt;element name="gerneratorPostive" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="busId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
     *                   &lt;element name="macId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType" minOccurs="0"/>
     *                   &lt;element name="ZRPos" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="ZXPos" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "gerneratorPostive"
    })
    public static class GeneratorPostiveList {

        protected List<PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive> gerneratorPostive;

        /**
         * Gets the value of the gerneratorPostive property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gerneratorPostive property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGerneratorPostive().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive }
         * 
         * 
         */
        public List<PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive> getGerneratorPostive() {
            if (gerneratorPostive == null) {
                gerneratorPostive = new ArrayList<PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive>();
            }
            return this.gerneratorPostive;
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
         *         &lt;element name="busId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType"/>
         *         &lt;element name="macId" type="{http://www.ieee.org/odm/Schema}IDRefRecordXmlType" minOccurs="0"/>
         *         &lt;element name="ZRPos" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="ZXPos" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
            "busId",
            "macId",
            "zrPos",
            "zxPos"
        })
        public static class GerneratorPostive {

            @XmlElement(required = true)
            protected IDRefRecordXmlType busId;
            protected IDRefRecordXmlType macId;
            @XmlElement(name = "ZRPos")
            protected Double zrPos;
            @XmlElement(name = "ZXPos")
            protected Double zxPos;

            /**
             * Gets the value of the busId property.
             * 
             * @return
             *     possible object is
             *     {@link IDRefRecordXmlType }
             *     
             */
            public IDRefRecordXmlType getBusId() {
                return busId;
            }

            /**
             * Sets the value of the busId property.
             * 
             * @param value
             *     allowed object is
             *     {@link IDRefRecordXmlType }
             *     
             */
            public void setBusId(IDRefRecordXmlType value) {
                this.busId = value;
            }

            /**
             * Gets the value of the macId property.
             * 
             * @return
             *     possible object is
             *     {@link IDRefRecordXmlType }
             *     
             */
            public IDRefRecordXmlType getMacId() {
                return macId;
            }

            /**
             * Sets the value of the macId property.
             * 
             * @param value
             *     allowed object is
             *     {@link IDRefRecordXmlType }
             *     
             */
            public void setMacId(IDRefRecordXmlType value) {
                this.macId = value;
            }

            /**
             * Gets the value of the zrPos property.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getZRPos() {
                return zrPos;
            }

            /**
             * Sets the value of the zrPos property.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setZRPos(Double value) {
                this.zrPos = value;
            }

            /**
             * Gets the value of the zxPos property.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getZXPos() {
                return zxPos;
            }

            /**
             * Sets the value of the zxPos property.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setZXPos(Double value) {
                this.zxPos = value;
            }

        }

    }

}
