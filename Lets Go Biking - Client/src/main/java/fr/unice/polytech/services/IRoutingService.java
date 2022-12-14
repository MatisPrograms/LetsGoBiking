package fr.unice.polytech.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebService(name = "IRoutingService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface IRoutingService {


    /**
     * @param coordinates
     * @return returns fr.unice.polytech.services.ArrayOfItinerary
     */
    @WebMethod(operationName = "GetItineraryList", action = "http://tempuri.org/IRoutingService/GetItineraryList")
    @WebResult(name = "GetItineraryListResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetItineraryList", targetNamespace = "http://tempuri.org/", className = "fr.unice.polytech.services.GetItineraryList")
    @ResponseWrapper(localName = "GetItineraryListResponse", targetNamespace = "http://tempuri.org/", className = "fr.unice.polytech.services.GetItineraryListResponse")
    ArrayOfItinerary getItineraryList(
            @WebParam(name = "coordinates", targetNamespace = "http://tempuri.org/")
            ArrayOfGeoCoordinate coordinates);

    /**
     * @param origin
     * @param destination
     * @return returns fr.unice.polytech.services.Itinerary
     */
    @WebMethod(operationName = "GetItinerary", action = "http://tempuri.org/IRoutingService/GetItinerary")
    @WebResult(name = "GetItineraryResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetItinerary", targetNamespace = "http://tempuri.org/", className = "fr.unice.polytech.services.GetItinerary")
    @ResponseWrapper(localName = "GetItineraryResponse", targetNamespace = "http://tempuri.org/", className = "fr.unice.polytech.services.GetItineraryResponse")
    Itinerary getItinerary(
            @WebParam(name = "origin", targetNamespace = "http://tempuri.org/")
            GeoCoordinate origin,
            @WebParam(name = "destination", targetNamespace = "http://tempuri.org/")
            GeoCoordinate destination);

    /**
     * @param current
     * @param goal
     */
    @WebMethod(operationName = "LiveItinerary", action = "http://tempuri.org/IRoutingService/LiveItinerary")
    @RequestWrapper(localName = "LiveItinerary", targetNamespace = "http://tempuri.org/", className = "fr.unice.polytech.services.LiveItinerary")
    @ResponseWrapper(localName = "LiveItineraryResponse", targetNamespace = "http://tempuri.org/", className = "fr.unice.polytech.services.LiveItineraryResponse")
    void liveItinerary(
            @WebParam(name = "current", targetNamespace = "http://tempuri.org/")
            GeoCoordinate current,
            @WebParam(name = "goal", targetNamespace = "http://tempuri.org/")
            GeoCoordinate goal);

}
