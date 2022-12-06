
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
 *         &lt;element name="current" type="{http://schemas.datacontract.org/2004/07/System.Device.Location}GeoCoordinate" minOccurs="0"/&gt;
 *         &lt;element name="goal" type="{http://schemas.datacontract.org/2004/07/System.Device.Location}GeoCoordinate" minOccurs="0"/&gt;
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
    "current",
    "goal"
})
@XmlRootElement(name = "LiveItinerary")
public class LiveItinerary {

    @XmlElementRef(name = "current", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GeoCoordinate> current;
    @XmlElementRef(name = "goal", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GeoCoordinate> goal;

    /**
     * Gets the value of the current property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     *     
     */
    public JAXBElement<GeoCoordinate> getCurrent() {
        return current;
    }

    /**
     * Sets the value of the current property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     *     
     */
    public void setCurrent(JAXBElement<GeoCoordinate> value) {
        this.current = value;
    }

    /**
     * Gets the value of the goal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     *     
     */
    public JAXBElement<GeoCoordinate> getGoal() {
        return goal;
    }

    /**
     * Sets the value of the goal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     *     
     */
    public void setGoal(JAXBElement<GeoCoordinate> value) {
        this.goal = value;
    }

}
