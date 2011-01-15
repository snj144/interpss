//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.09 at 02:27:16 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DynamicMachineXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DynamicMachineXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}IDRecordXmlType">
 *       &lt;sequence>
 *         &lt;element name="ownerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ratedPower" type="{http://www.ieee.org/odm/Schema/2008}ActivePowerXmlType" minOccurs="0"/>
 *         &lt;element name="ratedVoltage" type="{http://www.ieee.org/odm/Schema/2008}VoltageXmlType" minOccurs="0"/>
 *         &lt;element name="pContributionPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="qContributionPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element ref="{http://www.ieee.org/odm/Schema/2008}machineModel"/>
 *         &lt;element ref="{http://www.ieee.org/odm/Schema/2008}exciter" minOccurs="0"/>
 *         &lt;element ref="{http://www.ieee.org/odm/Schema/2008}governor" minOccurs="0"/>
 *         &lt;element ref="{http://www.ieee.org/odm/Schema/2008}stabilizer" minOccurs="0"/>
 *         &lt;element name="grounding" type="{http://www.ieee.org/odm/Schema/2008}GroundingXmlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DynamicMachineXmlType", propOrder = {
    "ownerName",
    "ratedPower",
    "ratedVoltage",
    "pContributionPercent",
    "qContributionPercent",
    "machineModel",
    "exciter",
    "governor",
    "stabilizer",
    "grounding"
})
public class DynamicMachineXmlType
    extends IDRecordXmlType
{

    protected String ownerName;
    protected ActivePowerXmlType ratedPower;
    protected VoltageXmlType ratedVoltage;
    protected Double pContributionPercent;
    protected Double qContributionPercent;
    @XmlElementRef(name = "machineModel", namespace = "http://www.ieee.org/odm/Schema/2008", type = JAXBElement.class)
    protected JAXBElement<? extends MachineModelXmlType> machineModel;
    @XmlElementRef(name = "exciter", namespace = "http://www.ieee.org/odm/Schema/2008", type = JAXBElement.class)
    protected JAXBElement<? extends ExciterModelXmlType> exciter;
    @XmlElementRef(name = "governor", namespace = "http://www.ieee.org/odm/Schema/2008", type = JAXBElement.class)
    protected JAXBElement<? extends GovernorModelXmlType> governor;
    @XmlElementRef(name = "stabilizer", namespace = "http://www.ieee.org/odm/Schema/2008", type = JAXBElement.class)
    protected JAXBElement<? extends StabilizerModelXmlType> stabilizer;
    protected GroundingXmlType grounding;

    /**
     * Gets the value of the ownerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Gets the value of the ratedPower property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public ActivePowerXmlType getRatedPower() {
        return ratedPower;
    }

    /**
     * Sets the value of the ratedPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePowerXmlType }
     *     
     */
    public void setRatedPower(ActivePowerXmlType value) {
        this.ratedPower = value;
    }

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
     * Gets the value of the pContributionPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPContributionPercent() {
        return pContributionPercent;
    }

    /**
     * Sets the value of the pContributionPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPContributionPercent(Double value) {
        this.pContributionPercent = value;
    }

    /**
     * Gets the value of the qContributionPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getQContributionPercent() {
        return qContributionPercent;
    }

    /**
     * Sets the value of the qContributionPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setQContributionPercent(Double value) {
        this.qContributionPercent = value;
    }

    /**
     * Gets the value of the machineModel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Eq1MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq1Ed1MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ClassicMachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq11Ed11MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq1Ed1MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MachineModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq11Ed11MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquiMachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq11MachineXmlType }{@code >}
     *     
     */
    public JAXBElement<? extends MachineModelXmlType> getMachineModel() {
        return machineModel;
    }

    /**
     * Sets the value of the machineModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Eq1MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq1Ed1MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ClassicMachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq11Ed11MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq1Ed1MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MachineModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq11Ed11MachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EquiMachineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Eq11MachineXmlType }{@code >}
     *     
     */
    public void setMachineModel(JAXBElement<? extends MachineModelXmlType> value) {
        this.machineModel = ((JAXBElement<? extends MachineModelXmlType> ) value);
    }

    /**
     * Gets the value of the exciter property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1981ST1XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcSimpleTypeXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type1SXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEEModified1968Type1XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1981TypeAC2XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type1XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExciterModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcBPAFJXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1992TypeAC1AXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type3XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcTSATTypeEXC34XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1981NewExcSystemXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type4XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type2XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEETypeDC2XmlType }{@code >}
     *     
     */
    public JAXBElement<? extends ExciterModelXmlType> getExciter() {
        return exciter;
    }

    /**
     * Sets the value of the exciter property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1981ST1XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcSimpleTypeXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type1SXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEEModified1968Type1XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1981TypeAC2XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type1XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExciterModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcBPAFJXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1992TypeAC1AXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type3XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcTSATTypeEXC34XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1981NewExcSystemXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type4XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEE1968Type2XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ExcIEEETypeDC2XmlType }{@code >}
     *     
     */
    public void setExciter(JAXBElement<? extends ExciterModelXmlType> value) {
        this.exciter = ((JAXBElement<? extends ExciterModelXmlType> ) value);
    }

    /**
     * Gets the value of the governor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GovHydroSteamGeneralModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovSteamTDSRXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovIEEE1981Type3XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovSimpleTypeXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovSteamNRXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovernorModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovIEEE1981Type2XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovHydroTurbineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovIEEE1981Type1XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovHydroXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovSteamTCSRXmlType }{@code >}
     *     
     */
    public JAXBElement<? extends GovernorModelXmlType> getGovernor() {
        return governor;
    }

    /**
     * Sets the value of the governor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GovHydroSteamGeneralModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovSteamTDSRXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovIEEE1981Type3XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovSimpleTypeXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovSteamNRXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovernorModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovIEEE1981Type2XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovHydroTurbineXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovIEEE1981Type1XmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovHydroXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GovSteamTCSRXmlType }{@code >}
     *     
     */
    public void setGovernor(JAXBElement<? extends GovernorModelXmlType> value) {
        this.governor = ((JAXBElement<? extends GovernorModelXmlType> ) value);
    }

    /**
     * Gets the value of the stabilizer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StabilizerModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIEEE1981TypeXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIEEEDualInputXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIeeePss1AXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssSimpleTypeXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIEE2STXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIEEE1992Type2AXmlType }{@code >}
     *     
     */
    public JAXBElement<? extends StabilizerModelXmlType> getStabilizer() {
        return stabilizer;
    }

    /**
     * Sets the value of the stabilizer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StabilizerModelXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIEEE1981TypeXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIEEEDualInputXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIeeePss1AXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssSimpleTypeXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIEE2STXmlType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PssIEEE1992Type2AXmlType }{@code >}
     *     
     */
    public void setStabilizer(JAXBElement<? extends StabilizerModelXmlType> value) {
        this.stabilizer = ((JAXBElement<? extends StabilizerModelXmlType> ) value);
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

}
