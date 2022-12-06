
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
 *         &lt;element name="GetItineraryListResult" type="{http://schemas.datacontract.org/2004/07/SOAP_WCF}ArrayOfItinerary" minOccurs="0"/&gt;
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
    "getItineraryListResult"
})
@XmlRootElement(name = "GetItineraryListResponse")
public class GetItineraryListResponse {

    @XmlElementRef(name = "GetItineraryListResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfItinerary> getItineraryListResult;

    /**
     * Gets the value of the getItineraryListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItinerary }{@code >}
     *     
     */
    public JAXBElement<ArrayOfItinerary> getGetItineraryListResult() {
        return getItineraryListResult;
    }

    /**
     * Sets the value of the getItineraryListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItinerary }{@code >}
     *     
     */
    public void setGetItineraryListResult(JAXBElement<ArrayOfItinerary> value) {
        this.getItineraryListResult = value;
    }

}
