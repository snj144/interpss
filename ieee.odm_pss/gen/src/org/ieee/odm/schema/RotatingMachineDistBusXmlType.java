//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.24 at 06:07:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		bus record for loadflow and short circuit study
 * 		
 * 
 * <p>Java class for RotatingMachineDistBusXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RotatingMachineDistBusXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}DistBusXmlType">
 *       &lt;sequence>
 *         &lt;element name="ratedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType"/>
 *         &lt;element name="pFactor" type="{http://www.ieee.org/odm/Schema/2008}PowerFactorXmlType"/>
 *         &lt;element name="grounding" type="{http://www.ieee.org/odm/Schema/2008}GroundingXmlType"/>
 *         &lt;element name="z1List">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="z" type="{http://www.ieee.org/odm/Schema/2008}NamedZXmlType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="z0" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType"/>
 *         &lt;element name="z2" type="{http://www.ieee.org/odm/Schema/2008}ZXmlType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RotatingMachineDistBusXmlType", propOrder = {
    "ratedVoltage",
    "pFactor",
    "grounding",
    "z1List",
    "z0",
    "z2"
})
@XmlSeeAlso({
    GeneratorDistBusXmlType.class,
    MixedLoadDistBusXmlType.class,
    MotorDistBusXmlType.class
})
public abstract class RotatingMachineDistBusXmlType
    extends DistBusXmlType
{

    @XmlElement(required = true)
    protected VoltageXmlType ratedVoltage;
    @XmlElement(required = true)
    protected PowerFactorXmlType pFactor;
    @XmlElement(required = true)
    protected GroundingXmlType grounding;
    @XmlElement(required = true)
    protected RotatingMachineDistBusXmlType.Z1List z1List;
    @XmlElement(required = true)
    protected ZXmlType z0;
    @XmlElement(required = true)
    protected ZXmlType z2;

    /**
     * Gets the value of the ratedVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageXmlType }
     *     
     */
    public VoltageXmlType getRatedVoltage() {
        return ratedVoltage;
    }

    /**
     * Sets the value of the ratedVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageXmlType }
     *     
     */
    public void setRatedVoltage(VoltageXmlType value) {
        this.ratedVoltage = value;
    }

    /**
     * Gets the value of the pFactor property.
     * 
     * @return
     *     possible object is
     *     {@link PowerFactorXmlType }
     *     
     */
    public PowerFactorXmlType getPFactor() {
        return pFactor;
    }

    /**
     * Sets the value of the pFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerFactorXmlType }
     *     
     */
    public void setPFactor(PowerFactorXmlType value) {
        this.pFactor = value;
    }

    /**
     * Gets the value of the grounding property.
     * 
     * @return
     *     possible object is
     *     {@link GroundingXmlType }
     *     
     */
    public GroundingXmlType getGrounding() {
        return grounding;
    }

    /**
     * Sets the value of the grounding property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroundingXmlType }
     *     
     */
    public void setGrounding(GroundingXmlType value) {
        this.grounding = value;
    }

    /**
     * Gets the value of the z1List property.
     * 
     * @return
     *     possible object is
     *     {@link RotatingMachineDistBusXmlType.Z1List }
     *     
     */
    public RotatingMachineDistBusXmlType.Z1List getZ1List() {
        return z1List;
    }

    /**
     * Sets the value of the z1List property.
     * 
     * @param value
     *     allowed object is
     *     {@link RotatingMachineDistBusXmlType.Z1List }
     *     
     */
    public void setZ1List(RotatingMachineDistBusXmlType.Z1List value) {
        this.z1List = value;
    }

    /**
     * Gets the value of the z0 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ0() {
        return z0;
    }

    /**
     * Sets the value of the z0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ0(ZXmlType value) {
        this.z0 = value;
    }

    /**
     * Gets the value of the z2 property.
     * 
     * @return
     *     possible object is
     *     {@link ZXmlType }
     *     
     */
    public ZXmlType getZ2() {
        return z2;
    }

    /**
     * Sets the value of the z2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZXmlType }
     *     
     */
    public void setZ2(ZXmlType value) {
        this.z2 = value;
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
     *         &lt;element name="z" type="{http://www.ieee.org/odm/Schema/2008}NamedZXmlType" maxOccurs="unbounded"/>
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
        "z"
    })
    public static class Z1List {

        @XmlElement(required = true)
        protected List<NamedZXmlType> z;

        /**
         * Gets the value of the z property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the z property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getZ().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NamedZXmlType }
         * 
         * 
         */
        public List<NamedZXmlType> getZ() {
            if (z == null) {
                z = new ArrayList<NamedZXmlType>();
            }
            return this.z;
        }

    }

}
