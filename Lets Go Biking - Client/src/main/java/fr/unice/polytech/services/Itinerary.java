package fr.unice.polytech.services;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Itinerary complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Itinerary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ascend" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="bbox" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfdouble" minOccurs="0"/&gt;
 *         &lt;element name="coordinates" type="{http://schemas.datacontract.org/2004/07/System.Device.Location}ArrayOfGeoCoordinate" minOccurs="0"/&gt;
 *         &lt;element name="descend" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="steps" type="{http://schemas.datacontract.org/2004/07/SOAP_WCF}ArrayOfStep" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Itinerary", namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", propOrder = {
        "ascend",
        "bbox",
        "coordinates",
        "descend",
        "distance",
        "duration",
        "steps"
})
public class Itinerary {

    protected Double ascend;
    @XmlElementRef(name = "bbox", namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfdouble> bbox;
    @XmlElementRef(name = "coordinates", namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfGeoCoordinate> coordinates;
    protected Double descend;
    protected Double distance;
    protected Double duration;
    @XmlElementRef(name = "steps", namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfStep> steps;

    /**
     * Gets the value of the ascend property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getAscend() {
        return ascend;
    }

    /**
     * Sets the value of the ascend property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setAscend(Double value) {
        this.ascend = value;
    }

    /**
     * Gets the value of the bbox property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     */
    public JAXBElement<ArrayOfdouble> getBbox() {
        return bbox;
    }

    /**
     * Sets the value of the bbox property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     */
    public void setBbox(JAXBElement<ArrayOfdouble> value) {
        this.bbox = value;
    }

    /**
     * Gets the value of the coordinates property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link ArrayOfGeoCoordinate }{@code >}
     */
    public JAXBElement<ArrayOfGeoCoordinate> getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the value of the coordinates property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link ArrayOfGeoCoordinate }{@code >}
     */
    public void setCoordinates(JAXBElement<ArrayOfGeoCoordinate> value) {
        this.coordinates = value;
    }

    /**
     * Gets the value of the descend property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getDescend() {
        return descend;
    }

    /**
     * Sets the value of the descend property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setDescend(Double value) {
        this.descend = value;
    }

    /**
     * Gets the value of the distance property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setDistance(Double value) {
        this.distance = value;
    }

    /**
     * Gets the value of the duration property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setDuration(Double value) {
        this.duration = value;
    }

    /**
     * Gets the value of the steps property.
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     */
    public JAXBElement<ArrayOfStep> getSteps() {
        return steps;
    }

    /**
     * Sets the value of the steps property.
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     */
    public void setSteps(JAXBElement<ArrayOfStep> value) {
        this.steps = value;
    }

}
