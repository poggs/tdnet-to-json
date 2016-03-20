//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.20 at 07:55:47 PM GMT 
//


package uk.co.networkrail.xml.ns._2008.train;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}AttributionReason"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}IncidentID"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}CurrentTrainID"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}OriginalTrainID" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}LocationStanox" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}EndLocationStanox" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}AlertNumber" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}DelayXRef" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Attributed" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}ReasonCode" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}ResponsibleTrain" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Location" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}EquipmentNumber" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}DelayLongDecription" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}ConfirmedFlag"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}NetworkDelayFlag" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}AttributionUpdateType" minOccurs="0"/>
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
    "attributionReason",
    "incidentID",
    "currentTrainID",
    "originalTrainID",
    "locationStanox",
    "endLocationStanox",
    "alertNumber",
    "delayXRef",
    "attributed",
    "reasonCode",
    "responsibleTrain",
    "location",
    "equipmentNumber",
    "delayLongDecription",
    "confirmedFlag",
    "networkDelayFlag",
    "attributionUpdateType"
})
@XmlRootElement(name = "DelayAttributionData")
public class DelayAttributionData {

    @XmlElement(name = "AttributionReason", required = true)
    @XmlSchemaType(name = "string")
    protected DelayAlertReasonType attributionReason;
    @XmlElement(name = "IncidentID", required = true)
    protected String incidentID;
    @XmlElement(name = "CurrentTrainID", required = true)
    protected String currentTrainID;
    @XmlElement(name = "OriginalTrainID")
    protected String originalTrainID;
    @XmlElement(name = "LocationStanox")
    protected String locationStanox;
    @XmlElement(name = "EndLocationStanox")
    protected String endLocationStanox;
    @XmlElement(name = "AlertNumber")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger alertNumber;
    @XmlElement(name = "DelayXRef")
    protected String delayXRef;
    @XmlElement(name = "Attributed")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger attributed;
    @XmlElement(name = "ReasonCode")
    protected String reasonCode;
    @XmlElement(name = "ResponsibleTrain")
    protected String responsibleTrain;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "EquipmentNumber")
    protected String equipmentNumber;
    @XmlElement(name = "DelayLongDecription")
    protected String delayLongDecription;
    @XmlElement(name = "ConfirmedFlag")
    protected boolean confirmedFlag;
    @XmlElement(name = "NetworkDelayFlag")
    protected Boolean networkDelayFlag;
    @XmlElement(name = "AttributionUpdateType")
    @XmlSchemaType(name = "string")
    protected UpdateType attributionUpdateType;

    /**
     * Gets the value of the attributionReason property.
     * 
     * @return
     *     possible object is
     *     {@link DelayAlertReasonType }
     *     
     */
    public DelayAlertReasonType getAttributionReason() {
        return attributionReason;
    }

    /**
     * Sets the value of the attributionReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link DelayAlertReasonType }
     *     
     */
    public void setAttributionReason(DelayAlertReasonType value) {
        this.attributionReason = value;
    }

    /**
     * Gets the value of the incidentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncidentID() {
        return incidentID;
    }

    /**
     * Sets the value of the incidentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncidentID(String value) {
        this.incidentID = value;
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
     * Gets the value of the endLocationStanox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndLocationStanox() {
        return endLocationStanox;
    }

    /**
     * Sets the value of the endLocationStanox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndLocationStanox(String value) {
        this.endLocationStanox = value;
    }

    /**
     * Gets the value of the alertNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAlertNumber() {
        return alertNumber;
    }

    /**
     * Sets the value of the alertNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAlertNumber(BigInteger value) {
        this.alertNumber = value;
    }

    /**
     * Gets the value of the delayXRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelayXRef() {
        return delayXRef;
    }

    /**
     * Sets the value of the delayXRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelayXRef(String value) {
        this.delayXRef = value;
    }

    /**
     * Gets the value of the attributed property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAttributed() {
        return attributed;
    }

    /**
     * Sets the value of the attributed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAttributed(BigInteger value) {
        this.attributed = value;
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
     * Gets the value of the responsibleTrain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleTrain() {
        return responsibleTrain;
    }

    /**
     * Sets the value of the responsibleTrain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleTrain(String value) {
        this.responsibleTrain = value;
    }

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
     * Gets the value of the equipmentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    /**
     * Sets the value of the equipmentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipmentNumber(String value) {
        this.equipmentNumber = value;
    }

    /**
     * Gets the value of the delayLongDecription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelayLongDecription() {
        return delayLongDecription;
    }

    /**
     * Sets the value of the delayLongDecription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelayLongDecription(String value) {
        this.delayLongDecription = value;
    }

    /**
     * Gets the value of the confirmedFlag property.
     * 
     */
    public boolean isConfirmedFlag() {
        return confirmedFlag;
    }

    /**
     * Sets the value of the confirmedFlag property.
     * 
     */
    public void setConfirmedFlag(boolean value) {
        this.confirmedFlag = value;
    }

    /**
     * Gets the value of the networkDelayFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNetworkDelayFlag() {
        return networkDelayFlag;
    }

    /**
     * Sets the value of the networkDelayFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNetworkDelayFlag(Boolean value) {
        this.networkDelayFlag = value;
    }

    /**
     * Gets the value of the attributionUpdateType property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateType }
     *     
     */
    public UpdateType getAttributionUpdateType() {
        return attributionUpdateType;
    }

    /**
     * Sets the value of the attributionUpdateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateType }
     *     
     */
    public void setAttributionUpdateType(UpdateType value) {
        this.attributionUpdateType = value;
    }

}