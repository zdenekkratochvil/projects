//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:53 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:56 PM(foreman)-)
//


package cz.csob.thub.ws.clients.disprights;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.csob.thub.ws.clients.disprights package. 
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

    private final static QName _SortingIdentifier_QNAME = new QName("http://www.csob.cz/common/core", "SortingIdentifier");
    private final static QName _Brand_QNAME = new QName("http://www.csob.cz/common/core", "Brand");
    private final static QName _CallContext_QNAME = new QName("http://www.csob.cz/common/core", "CallContext");
    private final static QName _TextData_QNAME = new QName("http://www.csob.cz/common/core", "TextData");
    private final static QName _BankSystem_QNAME = new QName("http://www.csob.cz/common/core", "BankSystem");
    private final static QName _IPAddress_QNAME = new QName("http://www.csob.cz/common/core", "IPAddress");
    private final static QName _TemplateCid_QNAME = new QName("http://www.csob.cz/common/core", "TemplateCid");
    private final static QName _OperatorCid_QNAME = new QName("http://www.csob.cz/common/core", "OperatorCid");
    private final static QName _ChannelCid_QNAME = new QName("http://www.csob.cz/common/core", "ChannelCid");
    private final static QName _PagingRes_QNAME = new QName("http://www.csob.cz/common/v1", "PagingRes");
    private final static QName _PagingChoice_QNAME = new QName("http://www.csob.cz/common/v1", "PagingChoice");
    private final static QName _BankSystemINFSYST_QNAME = new QName("http://www.csob.cz/common/core", "BankSystemINFSYST");
    private final static QName _LanguageId_QNAME = new QName("http://www.csob.cz/common/core", "LanguageId");
    private final static QName _ResultSetCount_QNAME = new QName("http://www.csob.cz/common/core", "ResultSetCount");
    private final static QName _Operator_QNAME = new QName("http://www.csob.cz/common/core", "Operator");
    private final static QName _ValidFromDate_QNAME = new QName("http://www.csob.cz/common/core", "ValidFromDate");
    private final static QName _Date_QNAME = new QName("http://www.csob.cz/common/core", "Date");
    private final static QName _PagingOptResSetMax_QNAME = new QName("http://www.csob.cz/common/v1", "PagingOptResSetMax");
    private final static QName _BrandCid_QNAME = new QName("http://www.csob.cz/common/core", "BrandCid");
    private final static QName _MessageFormat_QNAME = new QName("http://www.csob.cz/common/core", "MessageFormat");
    private final static QName _LanguageCid_QNAME = new QName("http://www.csob.cz/common/core", "LanguageCid");
    private final static QName _PageNumber_QNAME = new QName("http://www.csob.cz/common/core", "PageNumber");
    private final static QName _RowNumber_QNAME = new QName("http://www.csob.cz/common/core", "RowNumber");
    private final static QName _BankSystemCid_QNAME = new QName("http://www.csob.cz/common/core", "BankSystemCid");
    private final static QName _GeneralFault_QNAME = new QName("http://services.csob.cz/base_v1", "GeneralFault");
    private final static QName _ValidToDateTime_QNAME = new QName("http://www.csob.cz/common/core", "ValidToDateTime");
    private final static QName _ValidateOnly_QNAME = new QName("http://www.csob.cz/common/core", "ValidateOnly");
    private final static QName _SortBy1_QNAME = new QName("http://www.csob.cz/common/v1", "SortBy1");
    private final static QName _OrgUnitId_QNAME = new QName("http://www.csob.cz/common/core", "OrgUnitId");
    private final static QName _SortBy2_QNAME = new QName("http://www.csob.cz/common/v1", "SortBy2");
    private final static QName _SortAttribute_QNAME = new QName("http://www.csob.cz/common/core", "SortAttribute");
    private final static QName _ExpectedResultSetCount_QNAME = new QName("http://www.csob.cz/common/core", "ExpectedResultSetCount");
    private final static QName _OperatorId_QNAME = new QName("http://www.csob.cz/common/core", "OperatorId");
    private final static QName _ResultSetMax_QNAME = new QName("http://www.csob.cz/common/core", "ResultSetMax");
    private final static QName _Timestamp_QNAME = new QName("http://www.csob.cz/common/core", "Timestamp");
    private final static QName _ValidateOnlyFlag_QNAME = new QName("http://www.csob.cz/common/core", "ValidateOnlyFlag");
    private final static QName _RowsPerPage_QNAME = new QName("http://www.csob.cz/common/core", "RowsPerPage");
    private final static QName _SortDirection_QNAME = new QName("http://www.csob.cz/common/core", "SortDirection");
    private final static QName _ValidToDate_QNAME = new QName("http://www.csob.cz/common/core", "ValidToDate");
    private final static QName _CurrentCount_QNAME = new QName("http://www.csob.cz/common/core", "CurrentCount");
    private final static QName _IsModifiable_QNAME = new QName("http://www.csob.cz/common/core", "IsModifiable");
    private final static QName _Paging_QNAME = new QName("http://www.csob.cz/common/v1", "Paging");
    private final static QName _Boolean_QNAME = new QName("http://www.csob.cz/common/core", "Boolean");
    private final static QName _BrandId_QNAME = new QName("http://www.csob.cz/common/core", "BrandId");
    private final static QName _Language_QNAME = new QName("http://www.csob.cz/common/core", "Language");
    private final static QName _OrgUnitCid_QNAME = new QName("http://www.csob.cz/common/core", "OrgUnitCid");
    private final static QName _ErrorCid_QNAME = new QName("http://www.csob.cz/common/core", "ErrorCid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.csob.thub.ws.clients.disprights
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDrListByProductReq }
     * 
     */
    public GetDrListByProductReq createGetDrListByProductReq() {
        return new GetDrListByProductReq();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes }
     * 
     */
    public GetDrListByProductRes createGetDrListByProductRes() {
        return new GetDrListByProductRes();
    }

    /**
     * Create an instance of {@link MetaHeader }
     * 
     */
    public MetaHeader createMetaHeader() {
        return new MetaHeader();
    }

    /**
     * Create an instance of {@link GeneralFault }
     * 
     */
    public GeneralFault createGeneralFault() {
        return new GeneralFault();
    }

    /**
     * Create an instance of {@link GeneralFault.Errors }
     * 
     */
    public GeneralFault.Errors createGeneralFaultErrors() {
        return new GeneralFault.Errors();
    }

    /**
     * Create an instance of {@link GeneralFault.Errors.Error }
     * 
     */
    public GeneralFault.Errors.Error createGeneralFaultErrorsError() {
        return new GeneralFault.Errors.Error();
    }

    /**
     * Create an instance of {@link GeneralFault.Errors.Error.Elements }
     * 
     */
    public GeneralFault.Errors.Error.Elements createGeneralFaultErrorsErrorElements() {
        return new GeneralFault.Errors.Error.Elements();
    }

    /**
     * Create an instance of {@link MetaHeader.Extension }
     * 
     */
    public MetaHeader.Extension createMetaHeaderExtension() {
        return new MetaHeader.Extension();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset }
     * 
     */
    public GetDrListByProductRes.Resultset createGetDrListByProductResResultset() {
        return new GetDrListByProductRes.Resultset();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result }
     * 
     */
    public GetDrListByProductRes.Resultset.Result createGetDrListByProductResResultsetResult() {
        return new GetDrListByProductRes.Resultset.Result();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList createGetDrListByProductResResultsetResultRightList() {
        return new GetDrListByProductRes.Resultset.Result.RightList();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right createGetDrListByProductResResultsetResultRightListRight() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList createGetDrListByProductResResultsetResultRightListRightLimitList() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit createGetDrListByProductResResultsetResultRightListRightLimitListLimit() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.ProductList }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.ProductList createGetDrListByProductResResultsetResultRightListRightLimitListLimitProductList() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.ProductList();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.DisponentList }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.DisponentList createGetDrListByProductResResultsetResultRightListRightLimitListLimitDisponentList() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.DisponentList();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.DisponentList }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.DisponentList createGetDrListByProductResResultsetResultRightListRightDisponentList() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.DisponentList();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.RightProductList }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.RightProductList createGetDrListByProductResResultsetResultRightListRightRightProductList() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.RightProductList();
    }

    /**
     * Create an instance of {@link GetDrListByProductReq.ProductFilterList }
     * 
     */
    public GetDrListByProductReq.ProductFilterList createGetDrListByProductReqProductFilterList() {
        return new GetDrListByProductReq.ProductFilterList();
    }

    /**
     * Create an instance of {@link GetDrListByProductReq.ProductFilterList.ProductFilter }
     * 
     */
    public GetDrListByProductReq.ProductFilterList.ProductFilter createGetDrListByProductReqProductFilterListProductFilter() {
        return new GetDrListByProductReq.ProductFilterList.ProductFilter();
    }

    /**
     * Create an instance of {@link PagingResType }
     * 
     */
    public PagingResType createPagingResType() {
        return new PagingResType();
    }

    /**
     * Create an instance of {@link PagingOptResSetMaxType }
     * 
     */
    public PagingOptResSetMaxType createPagingOptResSetMaxType() {
        return new PagingOptResSetMaxType();
    }

    /**
     * Create an instance of {@link SortByType }
     * 
     */
    public SortByType createSortByType() {
        return new SortByType();
    }

    /**
     * Create an instance of {@link PagingType }
     * 
     */
    public PagingType createPagingType() {
        return new PagingType();
    }

    /**
     * Create an instance of {@link PagingChoiceType }
     * 
     */
    public PagingChoiceType createPagingChoiceType() {
        return new PagingChoiceType();
    }

    /**
     * Create an instance of {@link PagingOptType }
     * 
     */
    public PagingOptType createPagingOptType() {
        return new PagingOptType();
    }

    /**
     * Create an instance of {@link ForwardCompatibilityPlaceholderType }
     * 
     */
    public ForwardCompatibilityPlaceholderType createForwardCompatibilityPlaceholderType() {
        return new ForwardCompatibilityPlaceholderType();
    }

    /**
     * Create an instance of {@link BusinessProcessOriginator }
     * 
     */
    public BusinessProcessOriginator createBusinessProcessOriginator() {
        return new BusinessProcessOriginator();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link cz.csob.thub.ws.clients.disprights.OriginalSource }
     * 
     */
    public cz.csob.thub.ws.clients.disprights.OriginalSource createOriginalSource() {
        return new cz.csob.thub.ws.clients.disprights.OriginalSource();
    }

    /**
     * Create an instance of {@link UltimateTarget }
     * 
     */
    public UltimateTarget createUltimateTarget() {
        return new UltimateTarget();
    }

    /**
     * Create an instance of {@link QualityOfService }
     * 
     */
    public QualityOfService createQualityOfService() {
        return new QualityOfService();
    }

    /**
     * Create an instance of {@link Retry }
     * 
     */
    public Retry createRetry() {
        return new Retry();
    }

    /**
     * Create an instance of {@link Stadium }
     * 
     */
    public Stadium createStadium() {
        return new Stadium();
    }

    /**
     * Create an instance of {@link GeneralFault.Errors.Error.Parameters }
     * 
     */
    public GeneralFault.Errors.Error.Parameters createGeneralFaultErrorsErrorParameters() {
        return new GeneralFault.Errors.Error.Parameters();
    }

    /**
     * Create an instance of {@link GeneralFault.Errors.Error.Elements.Element }
     * 
     */
    public GeneralFault.Errors.Error.Elements.Element createGeneralFaultErrorsErrorElementsElement() {
        return new GeneralFault.Errors.Error.Elements.Element();
    }

    /**
     * Create an instance of {@link MetaHeader.Extension.OriginalSource }
     * 
     */
    public MetaHeader.Extension.OriginalSource createMetaHeaderExtensionOriginalSource() {
        return new MetaHeader.Extension.OriginalSource();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.ProductList.Product }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.ProductList.Product createGetDrListByProductResResultsetResultRightListRightLimitListLimitProductListProduct() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.ProductList.Product();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.DisponentList.Disponent }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.DisponentList.Disponent createGetDrListByProductResResultsetResultRightListRightLimitListLimitDisponentListDisponent() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.LimitList.Limit.DisponentList.Disponent();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.DisponentList.Disponent }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.DisponentList.Disponent createGetDrListByProductResResultsetResultRightListRightDisponentListDisponent() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.DisponentList.Disponent();
    }

    /**
     * Create an instance of {@link GetDrListByProductRes.Resultset.Result.RightList.Right.RightProductList.RightProduct }
     * 
     */
    public GetDrListByProductRes.Resultset.Result.RightList.Right.RightProductList.RightProduct createGetDrListByProductResResultsetResultRightListRightRightProductListRightProduct() {
        return new GetDrListByProductRes.Resultset.Result.RightList.Right.RightProductList.RightProduct();
    }

    /**
     * Create an instance of {@link GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList }
     * 
     */
    public GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList createGetDrListByProductReqProductFilterListProductFilterRightTypeList() {
        return new GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "SortingIdentifier")
    public JAXBElement<String> createSortingIdentifier(String value) {
        return new JAXBElement<String>(_SortingIdentifier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "Brand")
    public JAXBElement<BigInteger> createBrand(BigInteger value) {
        return new JAXBElement<BigInteger>(_Brand_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "CallContext")
    public JAXBElement<String> createCallContext(String value) {
        return new JAXBElement<String>(_CallContext_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "TextData")
    public JAXBElement<String> createTextData(String value) {
        return new JAXBElement<String>(_TextData_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "BankSystem")
    public JAXBElement<BigInteger> createBankSystem(BigInteger value) {
        return new JAXBElement<BigInteger>(_BankSystem_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "IPAddress")
    public JAXBElement<String> createIPAddress(String value) {
        return new JAXBElement<String>(_IPAddress_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "TemplateCid")
    public JAXBElement<BigInteger> createTemplateCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_TemplateCid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "OperatorCid")
    public JAXBElement<BigInteger> createOperatorCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_OperatorCid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ChannelCid")
    public JAXBElement<BigInteger> createChannelCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_ChannelCid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagingResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/v1", name = "PagingRes")
    public JAXBElement<PagingResType> createPagingRes(PagingResType value) {
        return new JAXBElement<PagingResType>(_PagingRes_QNAME, PagingResType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagingChoiceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/v1", name = "PagingChoice")
    public JAXBElement<PagingChoiceType> createPagingChoice(PagingChoiceType value) {
        return new JAXBElement<PagingChoiceType>(_PagingChoice_QNAME, PagingChoiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "BankSystemINFSYST")
    public JAXBElement<String> createBankSystemINFSYST(String value) {
        return new JAXBElement<String>(_BankSystemINFSYST_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "LanguageId")
    public JAXBElement<BigInteger> createLanguageId(BigInteger value) {
        return new JAXBElement<BigInteger>(_LanguageId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ResultSetCount", defaultValue = "1")
    public JAXBElement<BigInteger> createResultSetCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_ResultSetCount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "Operator")
    public JAXBElement<BigInteger> createOperator(BigInteger value) {
        return new JAXBElement<BigInteger>(_Operator_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ValidFromDate")
    public JAXBElement<XMLGregorianCalendar> createValidFromDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ValidFromDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "Date")
    public JAXBElement<XMLGregorianCalendar> createDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Date_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagingOptResSetMaxType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/v1", name = "PagingOptResSetMax")
    public JAXBElement<PagingOptResSetMaxType> createPagingOptResSetMax(PagingOptResSetMaxType value) {
        return new JAXBElement<PagingOptResSetMaxType>(_PagingOptResSetMax_QNAME, PagingOptResSetMaxType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "BrandCid")
    public JAXBElement<BigInteger> createBrandCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_BrandCid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "MessageFormat")
    public JAXBElement<BigInteger> createMessageFormat(BigInteger value) {
        return new JAXBElement<BigInteger>(_MessageFormat_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "LanguageCid")
    public JAXBElement<BigInteger> createLanguageCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_LanguageCid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "PageNumber")
    public JAXBElement<BigInteger> createPageNumber(BigInteger value) {
        return new JAXBElement<BigInteger>(_PageNumber_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "RowNumber")
    public JAXBElement<BigInteger> createRowNumber(BigInteger value) {
        return new JAXBElement<BigInteger>(_RowNumber_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "BankSystemCid")
    public JAXBElement<BigInteger> createBankSystemCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_BankSystemCid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.csob.cz/base_v1", name = "GeneralFault")
    public JAXBElement<GeneralFault> createGeneralFault(GeneralFault value) {
        return new JAXBElement<GeneralFault>(_GeneralFault_QNAME, GeneralFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ValidToDateTime")
    public JAXBElement<XMLGregorianCalendar> createValidToDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ValidToDateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ValidateOnly")
    public JAXBElement<Boolean> createValidateOnly(Boolean value) {
        return new JAXBElement<Boolean>(_ValidateOnly_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SortByType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/v1", name = "SortBy1")
    public JAXBElement<SortByType> createSortBy1(SortByType value) {
        return new JAXBElement<SortByType>(_SortBy1_QNAME, SortByType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "OrgUnitId")
    public JAXBElement<BigInteger> createOrgUnitId(BigInteger value) {
        return new JAXBElement<BigInteger>(_OrgUnitId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SortByType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/v1", name = "SortBy2")
    public JAXBElement<SortByType> createSortBy2(SortByType value) {
        return new JAXBElement<SortByType>(_SortBy2_QNAME, SortByType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "SortAttribute")
    public JAXBElement<String> createSortAttribute(String value) {
        return new JAXBElement<String>(_SortAttribute_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ExpectedResultSetCount")
    public JAXBElement<Long> createExpectedResultSetCount(Long value) {
        return new JAXBElement<Long>(_ExpectedResultSetCount_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "OperatorId")
    public JAXBElement<BigInteger> createOperatorId(BigInteger value) {
        return new JAXBElement<BigInteger>(_OperatorId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ResultSetMax", defaultValue = "1")
    public JAXBElement<BigInteger> createResultSetMax(BigInteger value) {
        return new JAXBElement<BigInteger>(_ResultSetMax_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "Timestamp")
    public JAXBElement<XMLGregorianCalendar> createTimestamp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Timestamp_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ValidateOnlyFlag")
    public JAXBElement<String> createValidateOnlyFlag(String value) {
        return new JAXBElement<String>(_ValidateOnlyFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "RowsPerPage")
    public JAXBElement<BigInteger> createRowsPerPage(BigInteger value) {
        return new JAXBElement<BigInteger>(_RowsPerPage_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SortDirectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "SortDirection")
    public JAXBElement<SortDirectionType> createSortDirection(SortDirectionType value) {
        return new JAXBElement<SortDirectionType>(_SortDirection_QNAME, SortDirectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ValidToDate")
    public JAXBElement<XMLGregorianCalendar> createValidToDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ValidToDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "CurrentCount", defaultValue = "1")
    public JAXBElement<BigInteger> createCurrentCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_CurrentCount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "IsModifiable")
    public JAXBElement<String> createIsModifiable(String value) {
        return new JAXBElement<String>(_IsModifiable_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/v1", name = "Paging")
    public JAXBElement<PagingType> createPaging(PagingType value) {
        return new JAXBElement<PagingType>(_Paging_QNAME, PagingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "Boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "BrandId")
    public JAXBElement<BigInteger> createBrandId(BigInteger value) {
        return new JAXBElement<BigInteger>(_BrandId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "Language")
    public JAXBElement<BigInteger> createLanguage(BigInteger value) {
        return new JAXBElement<BigInteger>(_Language_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "OrgUnitCid")
    public JAXBElement<BigInteger> createOrgUnitCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_OrgUnitCid_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csob.cz/common/core", name = "ErrorCid")
    public JAXBElement<BigInteger> createErrorCid(BigInteger value) {
        return new JAXBElement<BigInteger>(_ErrorCid_QNAME, BigInteger.class, null, value);
    }

}