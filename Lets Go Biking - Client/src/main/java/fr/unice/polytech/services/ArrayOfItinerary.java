package fr.unice.polytech.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfItinerary complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ArrayOfItinerary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Itinerary" type="{http://schemas.datacontract.org/2004/07/SOAP_WCF}Itinerary" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfItinerary", propOrder = {
        "itinerary"
})
public class ArrayOfItinerary {

    @XmlElement(name = "Itinerary", nillable = true)
    protected List<Itinerary> itinerary;

    /**
     * Gets the value of the itinerary property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itinerary property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItinerary().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Itinerary }
     */
    public List<Itinerary> getItinerary() {
        if (itinerary == null) {
            itinerary = new ArrayList<Itinerary>();
        }
        return this.itinerary;
    }

}
