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
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}DelayAlertReason"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}AlertType"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}AlertTimestamp"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}CurrentTrainID"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}OriginalTrainID" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}LocationStanox"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}LocationStanme"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}EndLocationStanox" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}EndLocationStanme" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Delay" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Unexplained" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Unattributed" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}FTS" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}FTSAttributedFlag" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}RevisionFlag" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}SplitFlag" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}OriginalAlertNumber" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}DelayXRef" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}ReasonCode" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}ReasonDescription" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}EquipmentNumber" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Location" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}ResponsibleTrain" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}DelayLongDecription" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}RolledUpFlag" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}AttributedFlag" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Sector" minOccurs="0"/>
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
    "delayAlertReason",
    "alertType",
    "alertTimestamp",
    "currentTrainID",
    "originalTrainID",
    "locationStanox",
    "locationStanme",
    "endLocationStanox",
    "endLocationStanme",
    "delay",
    "unexplained",
    "unattributed",
    "fts",
    "ftsAttributedFlag",
    "revisionFlag",
    "splitFlag",
    "originalAlertNumber",
    "delayXRef",
    "reasonCode",
    "reasonDescription",
    "equipmentNumber",
    "location",
    "responsibleTrain",
    "delayLongDecription",
    "rolledUpFlag",
    "attributedFlag",
    "sector"
})
@XmlRootElement(name = "TrainDelayAlertData")
public class TrainDelayAlertData {

    @XmlElement(name = "DelayAlertReason", required = true)
    @XmlSchemaType(name = "string")
    protected DelayAlertReasonType delayAlertReason;
    @XmlElement(name = "AlertType", required = true)
    @XmlSchemaType(name = "string")
    protected AlertType alertType;
    @XmlElement(name = "AlertTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar alertTimestamp;
    @XmlElement(name = "CurrentTrainID", required = true)
    protected String currentTrainID;
    @XmlElement(name = "OriginalTrainID")
    protected String originalTrainID;
    @XmlElement(name = "LocationStanox", required = true)
    protected String locationStanox;
    @XmlElement(name = "LocationStanme", required = true)
    protected String locationStanme;
    @XmlElement(name = "EndLocationStanox")
    protected String endLocationStanox;
    @XmlElement(name = "EndLocationStanme")
    protected String endLocationStanme;
    @XmlElement(name = "Delay")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger delay;
    @XmlElement(name = "Unexplained")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger unexplained;
    @XmlElement(name = "Unattributed")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger unattributed;
    @XmlElement(name = "FTS")
    protected String fts;
    @XmlElement(name = "FTSAttributedFlag")
    protected String ftsAttributedFlag;
    @XmlElement(name = "RevisionFlag")
    protected Boolean revisionFlag;
    @XmlElement(name = "SplitFlag")
    protected Boolean splitFlag;
    @XmlElement(name = "OriginalAlertNumber")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger originalAlertNumber;
    @XmlElement(name = "DelayXRef")
    protected String delayXRef;
    @XmlElement(name = "ReasonCode")
    protected String reasonCode;
    @XmlElement(name = "ReasonDescription")
    protected String reasonDescription;
    @XmlElement(name = "EquipmentNumber")
    protected String equipmentNumber;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "ResponsibleTrain")
    protected String responsibleTrain;
    @XmlElement(name = "DelayLongDecription")
    protected String delayLongDecription;
    @XmlElement(name = "RolledUpFlag")
    protected Boolean rolledUpFlag;
    @XmlElement(name = "AttributedFlag")
    protected Boolean attributedFlag;
    @XmlElement(name = "Sector")
    protected Integer sector;

    /**
     * Gets the value of the delayAlertReason property.
     * 
     * @return
     *     possible object is
     *     {@link DelayAlertReasonType }
     *     
     */
    public DelayAlertReasonType getDelayAlertReason() {
        return delayAlertReason;
    }

    /**
     * Sets the value of the delayAlertReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link DelayAlertReasonType }
     *     
     */
    public void setDelayAlertReason(DelayAlertReasonType value) {
        this.delayAlertReason = value;
    }

    /**
     * Gets the value of the alertType property.
     * 
     * @return
     *     possible object is
     *     {@link AlertType }
     *     
     */
    public AlertType getAlertType() {
        return alertType;
    }

    /**
     * Sets the value of the alertType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlertType }
     *     
     */
    public void setAlertType(AlertType value) {
        this.alertType = value;
    }

    /**
     * Gets the value of the alertTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAlertTimestamp() {
        return alertTimestamp;
    }

    /**
     * Sets the value of the alertTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAlertTimestamp(XMLGregorianCalendar value) {
        this.alertTimestamp = value;
    }

    /**
     * Current Identifier of a train
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
     * Original Train ID only present if the train id has changed.
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
     * Gets the value of the locationStanme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationStanme() {
        return locationStanme;
    }

    /**
     * Sets the value of the locationStanme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationStanme(String value) {
        this.locationStanme = value;
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
     * Gets the value of the endLocationStanme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndLocationStanme() {
        return endLocationStanme;
    }

    /**
     * Sets the value of the endLocationStanme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndLocationStanme(String value) {
        this.endLocationStanme = value;
    }

    /**
     * Gets the value of the delay property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDelay() {
        return delay;
    }

    /**
     * Sets the value of the delay property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDelay(BigInteger value) {
        this.delay = value;
    }

    /**
     * Gets the value of the unexplained property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnexplained() {
        return unexplained;
    }

    /**
     * Sets the value of the unexplained property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnexplained(BigInteger value) {
        this.unexplained = value;
    }

    /**
     * Gets the value of the unattributed property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnattributed() {
        return unattributed;
    }

    /**
     * Sets the value of the unattributed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnattributed(BigInteger value) {
        this.unattributed = value;
    }

    /**
     * Gets the value of the fts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTS() {
        return fts;
    }

    /**
     * Sets the value of the fts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTS(String value) {
        this.fts = value;
    }

    /**
     * Gets the value of the ftsAttributedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTSAttributedFlag() {
        return ftsAttributedFlag;
    }

    /**
     * Sets the value of the ftsAttributedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTSAttributedFlag(String value) {
        this.ftsAttributedFlag = value;
    }

    /**
     * Gets the value of the revisionFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRevisionFlag() {
        return revisionFlag;
    }

    /**
     * Sets the value of the revisionFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRevisionFlag(Boolean value) {
        this.revisionFlag = value;
    }

    /**
     * Gets the value of the splitFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSplitFlag() {
        return splitFlag;
    }

    /**
     * Sets the value of the splitFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSplitFlag(Boolean value) {
        this.splitFlag = value;
    }

    /**
     * Gets the value of the originalAlertNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOriginalAlertNumber() {
        return originalAlertNumber;
    }

    /**
     * Sets the value of the originalAlertNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOriginalAlertNumber(BigInteger value) {
        this.originalAlertNumber = value;
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
     * Gets the value of the reasonDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonDescription() {
        return reasonDescription;
    }

    /**
     * Sets the value of the reasonDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonDescription(String value) {
        this.reasonDescription = value;
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
     * Gets the value of the rolledUpFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRolledUpFlag() {
        return rolledUpFlag;
    }

    /**
     * Sets the value of the rolledUpFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRolledUpFlag(Boolean value) {
        this.rolledUpFlag = value;
    }

    /**
     * Gets the value of the attributedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAttributedFlag() {
        return attributedFlag;
    }

    /**
     * Sets the value of the attributedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAttributedFlag(Boolean value) {
        this.attributedFlag = value;
    }

    /**
     * Gets the value of the sector property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSector() {
        return sector;
    }

    /**
     * Sets the value of the sector property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSector(Integer value) {
        this.sector = value;
    }

}
