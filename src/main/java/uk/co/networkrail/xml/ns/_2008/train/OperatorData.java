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
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}EventTimestamp"/>
 *         &lt;element name="DAMessageType" type="{http://xml.networkrail.co.uk/ns/2008/Train}TRUSTDAMessageType"/>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}MessageText"/>
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
    "eventTimestamp",
    "daMessageType",
    "messageText"
})
@XmlRootElement(name = "OperatorData")
public class OperatorData {

    @XmlElement(name = "EventTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eventTimestamp;
    @XmlElement(name = "DAMessageType", required = true)
    protected String daMessageType;
    @XmlElement(name = "MessageText", required = true)
    protected String messageText;

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
     * Gets the value of the daMessageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDAMessageType() {
        return daMessageType;
    }

    /**
     * Sets the value of the daMessageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDAMessageType(String value) {
        this.daMessageType = value;
    }

    /**
     * Gets the value of the messageText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * Sets the value of the messageText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageText(String value) {
        this.messageText = value;
    }

}
