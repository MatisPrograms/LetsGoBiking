
package fr.unice.polytech.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.unice.polytech.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfGeoCoordinate_QNAME = new QName("http://schemas.datacontract.org/2004/07/System.Device.Location", "ArrayOfGeoCoordinate");
    private final static QName _GeoCoordinate_QNAME = new QName("http://schemas.datacontract.org/2004/07/System.Device.Location", "GeoCoordinate");
    private final static QName _ArrayOfItinerary_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "ArrayOfItinerary");
    private final static QName _Itinerary_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "Itinerary");
    private final static QName _ArrayOfStep_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "ArrayOfStep");
    private final static QName _Step_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "Step");
    private final static QName _ArrayOfdouble_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfdouble");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _GetItineraryListCoordinates_QNAME = new QName("http://tempuri.org/", "coordinates");
    private final static QName _GetItineraryListResponseGetItineraryListResult_QNAME = new QName("http://tempuri.org/", "GetItineraryListResult");
    private final static QName _GetItineraryOrigin_QNAME = new QName("http://tempuri.org/", "origin");
    private final static QName _GetItineraryDestination_QNAME = new QName("http://tempuri.org/", "destination");
    private final static QName _GetItineraryResponseGetItineraryResult_QNAME = new QName("http://tempuri.org/", "GetItineraryResult");
    private final static QName _LiveItineraryCurrent_QNAME = new QName("http://tempuri.org/", "current");
    private final static QName _LiveItineraryGoal_QNAME = new QName("http://tempuri.org/", "goal");
    private final static QName _StepStreetName_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "street_name");
    private final static QName _StepText_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "text");
    private final static QName _ItineraryBbox_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "bbox");
    private final static QName _ItineraryCoordinates_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "coordinates");
    private final static QName _ItineraryFromStation_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "fromStation");
    private final static QName _ItinerarySteps_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "steps");
    private final static QName _ItineraryToStation_QNAME = new QName("http://schemas.datacontract.org/2004/07/SOAP_WCF", "toStation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.unice.polytech.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetItineraryList }
     * 
     */
    public GetItineraryList createGetItineraryList() {
        return new GetItineraryList();
    }

    /**
     * Create an instance of {@link ArrayOfGeoCoordinate }
     * 
     */
    public ArrayOfGeoCoordinate createArrayOfGeoCoordinate() {
        return new ArrayOfGeoCoordinate();
    }

    /**
     * Create an instance of {@link GetItineraryListResponse }
     * 
     */
    public GetItineraryListResponse createGetItineraryListResponse() {
        return new GetItineraryListResponse();
    }

    /**
     * Create an instance of {@link ArrayOfItinerary }
     * 
     */
    public ArrayOfItinerary createArrayOfItinerary() {
        return new ArrayOfItinerary();
    }

    /**
     * Create an instance of {@link GetItinerary }
     * 
     */
    public GetItinerary createGetItinerary() {
        return new GetItinerary();
    }

    /**
     * Create an instance of {@link GeoCoordinate }
     * 
     */
    public GeoCoordinate createGeoCoordinate() {
        return new GeoCoordinate();
    }

    /**
     * Create an instance of {@link GetItineraryResponse }
     * 
     */
    public GetItineraryResponse createGetItineraryResponse() {
        return new GetItineraryResponse();
    }

    /**
     * Create an instance of {@link Itinerary }
     * 
     */
    public Itinerary createItinerary() {
        return new Itinerary();
    }

    /**
     * Create an instance of {@link LiveItinerary }
     * 
     */
    public LiveItinerary createLiveItinerary() {
        return new LiveItinerary();
    }

    /**
     * Create an instance of {@link LiveItineraryResponse }
     * 
     */
    public LiveItineraryResponse createLiveItineraryResponse() {
        return new LiveItineraryResponse();
    }

    /**
     * Create an instance of {@link ArrayOfStep }
     * 
     */
    public ArrayOfStep createArrayOfStep() {
        return new ArrayOfStep();
    }

    /**
     * Create an instance of {@link Step }
     * 
     */
    public Step createStep() {
        return new Step();
    }

    /**
     * Create an instance of {@link ArrayOfdouble }
     * 
     */
    public ArrayOfdouble createArrayOfdouble() {
        return new ArrayOfdouble();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfGeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/System.Device.Location", name = "ArrayOfGeoCoordinate")
    public JAXBElement<ArrayOfGeoCoordinate> createArrayOfGeoCoordinate(ArrayOfGeoCoordinate value) {
        return new JAXBElement<ArrayOfGeoCoordinate>(_ArrayOfGeoCoordinate_QNAME, ArrayOfGeoCoordinate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/System.Device.Location", name = "GeoCoordinate")
    public JAXBElement<GeoCoordinate> createGeoCoordinate(GeoCoordinate value) {
        return new JAXBElement<GeoCoordinate>(_GeoCoordinate_QNAME, GeoCoordinate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItinerary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfItinerary }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "ArrayOfItinerary")
    public JAXBElement<ArrayOfItinerary> createArrayOfItinerary(ArrayOfItinerary value) {
        return new JAXBElement<ArrayOfItinerary>(_ArrayOfItinerary_QNAME, ArrayOfItinerary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Itinerary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Itinerary }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "Itinerary")
    public JAXBElement<Itinerary> createItinerary(Itinerary value) {
        return new JAXBElement<Itinerary>(_Itinerary_QNAME, Itinerary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "ArrayOfStep")
    public JAXBElement<ArrayOfStep> createArrayOfStep(ArrayOfStep value) {
        return new JAXBElement<ArrayOfStep>(_ArrayOfStep_QNAME, ArrayOfStep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Step }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Step }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "Step")
    public JAXBElement<Step> createStep(Step value) {
        return new JAXBElement<Step>(_Step_QNAME, Step.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfdouble")
    public JAXBElement<ArrayOfdouble> createArrayOfdouble(ArrayOfdouble value) {
        return new JAXBElement<ArrayOfdouble>(_ArrayOfdouble_QNAME, ArrayOfdouble.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfGeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "coordinates", scope = GetItineraryList.class)
    public JAXBElement<ArrayOfGeoCoordinate> createGetItineraryListCoordinates(ArrayOfGeoCoordinate value) {
        return new JAXBElement<ArrayOfGeoCoordinate>(_GetItineraryListCoordinates_QNAME, ArrayOfGeoCoordinate.class, GetItineraryList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItinerary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfItinerary }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetItineraryListResult", scope = GetItineraryListResponse.class)
    public JAXBElement<ArrayOfItinerary> createGetItineraryListResponseGetItineraryListResult(ArrayOfItinerary value) {
        return new JAXBElement<ArrayOfItinerary>(_GetItineraryListResponseGetItineraryListResult_QNAME, ArrayOfItinerary.class, GetItineraryListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "origin", scope = GetItinerary.class)
    public JAXBElement<GeoCoordinate> createGetItineraryOrigin(GeoCoordinate value) {
        return new JAXBElement<GeoCoordinate>(_GetItineraryOrigin_QNAME, GeoCoordinate.class, GetItinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "destination", scope = GetItinerary.class)
    public JAXBElement<GeoCoordinate> createGetItineraryDestination(GeoCoordinate value) {
        return new JAXBElement<GeoCoordinate>(_GetItineraryDestination_QNAME, GeoCoordinate.class, GetItinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Itinerary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Itinerary }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetItineraryResult", scope = GetItineraryResponse.class)
    public JAXBElement<Itinerary> createGetItineraryResponseGetItineraryResult(Itinerary value) {
        return new JAXBElement<Itinerary>(_GetItineraryResponseGetItineraryResult_QNAME, Itinerary.class, GetItineraryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "current", scope = LiveItinerary.class)
    public JAXBElement<GeoCoordinate> createLiveItineraryCurrent(GeoCoordinate value) {
        return new JAXBElement<GeoCoordinate>(_LiveItineraryCurrent_QNAME, GeoCoordinate.class, LiveItinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "goal", scope = LiveItinerary.class)
    public JAXBElement<GeoCoordinate> createLiveItineraryGoal(GeoCoordinate value) {
        return new JAXBElement<GeoCoordinate>(_LiveItineraryGoal_QNAME, GeoCoordinate.class, LiveItinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "street_name", scope = Step.class)
    public JAXBElement<String> createStepStreetName(String value) {
        return new JAXBElement<String>(_StepStreetName_QNAME, String.class, Step.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "text", scope = Step.class)
    public JAXBElement<String> createStepText(String value) {
        return new JAXBElement<String>(_StepText_QNAME, String.class, Step.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "bbox", scope = Itinerary.class)
    public JAXBElement<ArrayOfdouble> createItineraryBbox(ArrayOfdouble value) {
        return new JAXBElement<ArrayOfdouble>(_ItineraryBbox_QNAME, ArrayOfdouble.class, Itinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfGeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "coordinates", scope = Itinerary.class)
    public JAXBElement<ArrayOfGeoCoordinate> createItineraryCoordinates(ArrayOfGeoCoordinate value) {
        return new JAXBElement<ArrayOfGeoCoordinate>(_ItineraryCoordinates_QNAME, ArrayOfGeoCoordinate.class, Itinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "fromStation", scope = Itinerary.class)
    public JAXBElement<GeoCoordinate> createItineraryFromStation(GeoCoordinate value) {
        return new JAXBElement<GeoCoordinate>(_ItineraryFromStation_QNAME, GeoCoordinate.class, Itinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "steps", scope = Itinerary.class)
    public JAXBElement<ArrayOfStep> createItinerarySteps(ArrayOfStep value) {
        return new JAXBElement<ArrayOfStep>(_ItinerarySteps_QNAME, ArrayOfStep.class, Itinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoCoordinate }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SOAP_WCF", name = "toStation", scope = Itinerary.class)
    public JAXBElement<GeoCoordinate> createItineraryToStation(GeoCoordinate value) {
        return new JAXBElement<GeoCoordinate>(_ItineraryToStation_QNAME, GeoCoordinate.class, Itinerary.class, value);
    }

}
