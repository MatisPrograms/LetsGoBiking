
package fr.unice.polytech.services;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetItineraryResult" type="{http://schemas.datacontract.org/2004/07/SOAP_WCF}Itinerary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getItineraryResult"
})
@XmlRootElement(name = "GetItineraryResponse")
public class GetItineraryResponse {

    @XmlElementRef(name = "GetItineraryResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<Itinerary> getItineraryResult;

    /**
     * Gets the value of the getItineraryResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Itinerary }{@code >}
     *     
     */
    public JAXBElement<Itinerary> getGetItineraryResult() {
        return getItineraryResult;
    }

    /**
     * Sets the value of the getItineraryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Itinerary }{@code >}
     *     
     */
    public void setGetItineraryResult(JAXBElement<Itinerary> value) {
        this.getItineraryResult = value;
    }

}
