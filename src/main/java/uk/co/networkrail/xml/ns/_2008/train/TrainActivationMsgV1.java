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
import javax.xml.bind.annotation.XmlType;
import uk.co.networkrail.xml.ns._2008.eai.Message;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.networkrail.co.uk/ns/2008/EAI}Message">
 *       &lt;sequence>
 *         &lt;element ref="{http://xml.networkrail.co.uk/ns/2008/Train}TrainActivationData"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trainActivationData"
})
@XmlRootElement(name = "TrainActivationMsgV1")
public class TrainActivationMsgV1
    extends Message
{

    @XmlElement(name = "TrainActivationData", required = true)
    protected TrainActivationData trainActivationData;

    /**
     * Gets the value of the trainActivationData property.
     * 
     * @return
     *     possible object is
     *     {@link TrainActivationData }
     *     
     */
    public TrainActivationData getTrainActivationData() {
        return trainActivationData;
    }

    /**
     * Sets the value of the trainActivationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainActivationData }
     *     
     */
    public void setTrainActivationData(TrainActivationData value) {
        this.trainActivationData = value;
    }

}
