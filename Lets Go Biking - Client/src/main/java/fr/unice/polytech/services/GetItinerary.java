package fr.unice.polytech.services;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;


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
 *         &lt;element name="origin" type="{http://schemas.datacontract.org/2004/07/System.Device.Location}GeoCoordinate" minOccurs="0"/&gt;
 *         &lt;element name="destination" type="{http://schemas.datacontract.org/2004/07/System.Device.Location}GeoCoordinate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "origin",
        "destination"
})
@XmlRootElement(name = "GetItinerary", namespace = "http://tempuri.org/")
public class GetItinerary {

    @XmlElementRef(name = "origin", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GeoCoordinate> origin;
    @XmlElementRef(name = "destination", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GeoCoordinate> destination;

    /**
     * Gets the value of the origin property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    public JAXBElement<GeoCoordinate> getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    public void setOrigin(JAXBElement<GeoCoordinate> value) {
        this.origin = value;
    }

    /**
     * Gets the value of the destination property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    public JAXBElement<GeoCoordinate> getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    public void setDestination(JAXBElement<GeoCoordinate> value) {
        this.destination = value;
    }

}
