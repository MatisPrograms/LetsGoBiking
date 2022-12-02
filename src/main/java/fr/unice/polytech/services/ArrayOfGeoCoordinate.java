package fr.unice.polytech.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfGeoCoordinate complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ArrayOfGeoCoordinate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GeoCoordinate" type="{http://schemas.datacontract.org/2004/07/System.Device.Location}GeoCoordinate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGeoCoordinate", namespace = "http://schemas.datacontract.org/2004/07/System.Device.Location", propOrder = {
        "geoCoordinate"
})
public class ArrayOfGeoCoordinate {

    @XmlElement(name = "GeoCoordinate", nillable = true)
    protected List<GeoCoordinate> geoCoordinate;

    /**
     * Gets the value of the geoCoordinate property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geoCoordinate property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeoCoordinate().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeoCoordinate }
     */
    public List<GeoCoordinate> getGeoCoordinate() {
        if (geoCoordinate == null) {
            geoCoordinate = new ArrayList<GeoCoordinate>();
        }
        return this.geoCoordinate;
    }

}
