package fr.unice.polytech.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeoCoordinate complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GeoCoordinate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Altitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="Course" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="HorizontalAccuracy" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="Speed" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="VerticalAccuracy" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoCoordinate", namespace = "http://schemas.datacontract.org/2004/07/System.Device.Location", propOrder = {
        "altitude",
        "course",
        "horizontalAccuracy",
        "latitude",
        "longitude",
        "speed",
        "verticalAccuracy"
})
public class GeoCoordinate {

    @XmlElement(name = "Altitude")
    protected Double altitude;
    @XmlElement(name = "Course")
    protected Double course;
    @XmlElement(name = "HorizontalAccuracy")
    protected Double horizontalAccuracy;
    @XmlElement(name = "Latitude")
    protected Double latitude;
    @XmlElement(name = "Longitude")
    protected Double longitude;
    @XmlElement(name = "Speed")
    protected Double speed;
    @XmlElement(name = "VerticalAccuracy")
    protected Double verticalAccuracy;

    /**
     * Gets the value of the altitude property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getAltitude() {
        return altitude;
    }

    /**
     * Sets the value of the altitude property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setAltitude(Double value) {
        this.altitude = value;
    }

    /**
     * Gets the value of the course property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getCourse() {
        return course;
    }

    /**
     * Sets the value of the course property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setCourse(Double value) {
        this.course = value;
    }

    /**
     * Gets the value of the horizontalAccuracy property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    /**
     * Sets the value of the horizontalAccuracy property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setHorizontalAccuracy(Double value) {
        this.horizontalAccuracy = value;
    }

    /**
     * Gets the value of the latitude property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the speed property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setSpeed(Double value) {
        this.speed = value;
    }

    /**
     * Gets the value of the verticalAccuracy property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getVerticalAccuracy() {
        return verticalAccuracy;
    }

    /**
     * Sets the value of the verticalAccuracy property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setVerticalAccuracy(Double value) {
        this.verticalAccuracy = value;
    }

}
