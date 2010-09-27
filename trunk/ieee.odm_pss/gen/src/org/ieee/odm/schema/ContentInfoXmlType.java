//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.27 at 04:59:51 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContentInfoXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentInfoXmlType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="originalDataFormat" type="{http://www.ieee.org/odm/Schema/2008}OriginalDataFormatEnumType"/>
 *         &lt;element name="originalFormatVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adapterProviderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adapterProviderVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentInfoXmlType", propOrder = {
    "originalDataFormat",
    "originalFormatVersion",
    "adapterProviderName",
    "adapterProviderVersion"
})
public class ContentInfoXmlType {

    @XmlElement(required = true)
    protected OriginalDataFormatEnumType originalDataFormat;
    protected String originalFormatVersion;
    protected String adapterProviderName;
    protected String adapterProviderVersion;

    /**
     * Gets the value of the originalDataFormat property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalDataFormatEnumType }
     *     
     */
    public OriginalDataFormatEnumType getOriginalDataFormat() {
        return originalDataFormat;
    }

    /**
     * Sets the value of the originalDataFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalDataFormatEnumType }
     *     
     */
    public void setOriginalDataFormat(OriginalDataFormatEnumType value) {
        this.originalDataFormat = value;
    }

    /**
     * Gets the value of the originalFormatVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalFormatVersion() {
        return originalFormatVersion;
    }

    /**
     * Sets the value of the originalFormatVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalFormatVersion(String value) {
        this.originalFormatVersion = value;
    }

    /**
     * Gets the value of the adapterProviderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdapterProviderName() {
        return adapterProviderName;
    }

    /**
     * Sets the value of the adapterProviderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdapterProviderName(String value) {
        this.adapterProviderName = value;
    }

    /**
     * Gets the value of the adapterProviderVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdapterProviderVersion() {
        return adapterProviderVersion;
    }

    /**
     * Sets the value of the adapterProviderVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdapterProviderVersion(String value) {
        this.adapterProviderVersion = value;
    }

}
