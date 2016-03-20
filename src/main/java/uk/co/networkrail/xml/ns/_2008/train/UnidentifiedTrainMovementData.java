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
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}WTTID"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}EventTimestamp"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}LocationStanox"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}MovementType"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Direction" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Line" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Platform" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Route" minOccurs="0"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}Division"/>
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
    "wttid",
    "eventTimestamp",
    "locationStanox",
    "movementType",
    "direction",
    "line",
    "platform",
    "route",
    "division"
})
@XmlRootElement(name = "UnidentifiedTrainMovementData")
public class UnidentifiedTrainMovementData {

    @XmlElement(name = "WTTID", required = true)
    protected String wttid;
    @XmlElement(name = "EventTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eventTimestamp;
    @XmlElement(name = "LocationStanox", required = true)
    protected String locationStanox;
    @XmlElement(name = "MovementType", required = true)
    @XmlSchemaType(name = "string")
    protected TrainMovementType movementType;
    @XmlElement(name = "Direction")
    @XmlSchemaType(name = "string")
    protected DirectionType direction;
    @XmlElement(name = "Line")
    protected String line;
    @XmlElement(name = "Platform")
    protected String platform;
    @XmlElement(name = "Route")
    protected String route;
    @XmlElement(name = "Division", required = true)
    protected String division;

    /**
     * Gets the value of the wttid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWTTID() {
        return wttid;
    }

    /**
     * Sets the value of the wttid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWTTID(String value) {
        this.wttid = value;
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
     * Gets the value of the movementType property.
     * 
     * @return
     *     possible object is
     *     {@link TrainMovementType }
     *     
     */
    public TrainMovementType getMovementType() {
        return movementType;
    }

    /**
     * Sets the value of the movementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainMovementType }
     *     
     */
    public void setMovementType(TrainMovementType value) {
        this.movementType = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link DirectionType }
     *     
     */
    public DirectionType getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionType }
     *     
     */
    public void setDirection(DirectionType value) {
        this.direction = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLine(String value) {
        this.line = value;
    }

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatform(String value) {
        this.platform = value;
    }

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoute(String value) {
        this.route = value;
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

}