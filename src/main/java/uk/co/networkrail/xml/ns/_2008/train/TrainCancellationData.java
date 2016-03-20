//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.20 at 07:55:47 PM GMT 
//


package uk.co.networkrail.xml.ns._2008.train;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}OriginalTrainID"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}CurrentTrainID" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}EventTimestamp"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}LocationStanox"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}WTTTimestamp" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}OriginStanox" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}OriginalWTTTimestamp" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}TrainCancellationType"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}TrainServiceCode"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}ReasonCode"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Division"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}TOC"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}TrainFileAddress"/>
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
    "originalTrainID",
    "currentTrainID",
    "eventTimestamp",
    "locationStanox",
    "wttTimestamp",
    "originStanox",
    "originalWTTTimestamp",
    "trainCancellationType",
    "trainServiceCode",
    "reasonCode",
    "division",
    "toc",
    "trainFileAddress"
})
@XmlRootElement(name = "TrainCancellationData")
public class TrainCancellationData {

    @XmlElement(name = "OriginalTrainID", required = true)
    protected String originalTrainID;
    @XmlElement(name = "CurrentTrainID")
    protected String currentTrainID;
    @XmlElement(name = "EventTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eventTimestamp;
    @XmlElement(name = "LocationStanox", required = true)
    protected String locationStanox;
    @XmlElement(name = "WTTTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar wttTimestamp;
    @XmlElement(name = "OriginStanox")
    protected String originStanox;
    @XmlElement(name = "OriginalWTTTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar originalWTTTimestamp;
    @XmlElement(name = "TrainCancellationType", required = true)
    @XmlSchemaType(name = "string")
    protected CancellationType trainCancellationType;
    @XmlElement(name = "TrainServiceCode", required = true)
    protected String trainServiceCode;
    @XmlElement(name = "ReasonCode", required = true)
    protected String reasonCode;
    @XmlElement(name = "Division", required = true)
    protected String division;
    @XmlElement(name = "TOC", required = true)
    protected String toc;
    @XmlElement(name = "TrainFileAddress", required = true)
    protected String trainFileAddress;

    /**
     * Gets the value of the originalTrainID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalTrainID() {
        return originalTrainID;
    }

    /**
     * Sets the value of the originalTrainID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalTrainID(String value) {
        this.originalTrainID = value;
    }

    /**
     * Gets the value of the currentTrainID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentTrainID() {
        return currentTrainID;
    }

    /**
     * Sets the value of the currentTrainID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentTrainID(String value) {
        this.currentTrainID = value;
    }

    /**
     * Gets the value of the eventTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEventTimestamp() {
        return eventTimestamp;
    }

    /**
     * Sets the value of the eventTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEventTimestamp(XMLGregorianCalendar value) {
        this.eventTimestamp = value;
    }

    /**
     * Gets the value of the locationStanox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationStanox() {
        return locationStanox;
    }

    /**
     * Sets the value of the locationStanox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationStanox(String value) {
        this.locationStanox = value;
    }

    /**
     * Gets the value of the wttTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWTTTimestamp() {
        return wttTimestamp;
    }

    /**
     * Sets the value of the wttTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWTTTimestamp(XMLGregorianCalendar value) {
        this.wttTimestamp = value;
    }

    /**
     * Gets the value of the originStanox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginStanox() {
        return originStanox;
    }

    /**
     * Sets the value of the originStanox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginStanox(String value) {
        this.originStanox = value;
    }

    /**
     * Gets the value of the originalWTTTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOriginalWTTTimestamp() {
        return originalWTTTimestamp;
    }

    /**
     * Sets the value of the originalWTTTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOriginalWTTTimestamp(XMLGregorianCalendar value) {
        this.originalWTTTimestamp = value;
    }

    /**
     * Gets the value of the trainCancellationType property.
     * 
     * @return
     *     possible object is
     *     {@link CancellationType }
     *     
     */
    public CancellationType getTrainCancellationType() {
        return trainCancellationType;
    }

    /**
     * Sets the value of the trainCancellationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancellationType }
     *     
     */
    public void setTrainCancellationType(CancellationType value) {
        this.trainCancellationType = value;
    }

    /**
     * Gets the value of the trainServiceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainServiceCode() {
        return trainServiceCode;
    }

    /**
     * Sets the value of the trainServiceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainServiceCode(String value) {
        this.trainServiceCode = value;
    }

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCode(String value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the division property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivision(String value) {
        this.division = value;
    }

    /**
     * Gets the value of the toc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOC() {
        return toc;
    }

    /**
     * Sets the value of the toc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOC(String value) {
        this.toc = value;
    }

    /**
     * Gets the value of the trainFileAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainFileAddress() {
        return trainFileAddress;
    }

    /**
     * Sets the value of the trainFileAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainFileAddress(String value) {
        this.trainFileAddress = value;
    }

}
