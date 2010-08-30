//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.30 at 08:25:32 AM GMT-05:00 
//


package org.ieee.odm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineShortCircuitXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LineShortCircuitXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}LineBranchXmlType">
 *       &lt;sequence>
 *         &lt;element name="lineZeroSeq" type="{http://www.ieee.org/odm/Schema/2008}LineZeroSeqXmlType" minOccurs="0"/>
 *         &lt;element name="lineMutualZeroZ" type="{http://www.ieee.org/odm/Schema/2008}MutualZeroZXmlType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineShortCircuitXmlType", propOrder = {
    "lineZeroSeq",
    "lineMutualZeroZ"
})
@XmlSeeAlso({
    LineDStabXmlType.class
})
public class LineShortCircuitXmlType
    extends LineBranchXmlType
{

    protected LineZeroSeqXmlType lineZeroSeq;
    protected List<MutualZeroZXmlType> lineMutualZeroZ;

    /**
     * Gets the value of the lineZeroSeq property.
     * 
     * @return
     *     possible object is
     *     {@link LineZeroSeqXmlType }
     *     
     */
    public LineZeroSeqXmlType getLineZeroSeq() {
        return lineZeroSeq;
    }

    /**
     * Sets the value of the lineZeroSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineZeroSeqXmlType }
     *     
     */
    public void setLineZeroSeq(LineZeroSeqXmlType value) {
        this.lineZeroSeq = value;
    }

    /**
     * Gets the value of the lineMutualZeroZ property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineMutualZeroZ property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineMutualZeroZ().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MutualZeroZXmlType }
     * 
     * 
     */
    public List<MutualZeroZXmlType> getLineMutualZeroZ() {
        if (lineMutualZeroZ == null) {
            lineMutualZeroZ = new ArrayList<MutualZeroZXmlType>();
        }
        return this.lineMutualZeroZ;
    }

}
