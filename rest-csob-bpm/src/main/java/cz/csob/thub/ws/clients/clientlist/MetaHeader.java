//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:53 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:56 PM(foreman)-)
//


package cz.csob.thub.ws.clients.clientlist;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HeaderVersion" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="SessionID" type="{http://ed6.kbc.com/metaheader.1}SessionID"/>
 *         &lt;element name="SessionSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="BusinessProcessOriginator" type="{http://ed6.kbc.com/metaheader.1}BusinessProcessOriginator" minOccurs="0"/>
 *         &lt;element name="BusinessUniqueID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="32"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BuidSequence" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="64"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReleaseVersion" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *               &lt;totalDigits value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Data" type="{http://ed6.kbc.com/metaheader.1}Data" minOccurs="0"/>
 *         &lt;element name="OriginalSource" type="{http://ed6.kbc.com/metaheader.1}OriginalSource"/>
 *         &lt;element name="UltimateTarget" type="{http://ed6.kbc.com/metaheader.1}UltimateTarget" minOccurs="0"/>
 *         &lt;element name="QoS" type="{http://ed6.kbc.com/metaheader.1}QualityOfService" minOccurs="0"/>
 *         &lt;element name="Retry" type="{http://ed6.kbc.com/metaheader.1}Retry" minOccurs="0"/>
 *         &lt;element name="Extension" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence minOccurs="0">
 *                   &lt;element name="OriginalSource" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence minOccurs="0">
 *                             &lt;element name="Brand" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "headerVersion",
    "sessionID",
    "sessionSequenceNumber",
    "businessProcessOriginator",
    "businessUniqueID",
    "buidSequence",
    "releaseVersion",
    "data",
    "originalSource",
    "ultimateTarget",
    "qoS",
    "retry",
    "extension"
})
@XmlRootElement(name = "MetaHeader")
public class MetaHeader
    implements Serializable
{

    @XmlElement(name = "HeaderVersion", required = true, defaultValue = "5")
    protected BigInteger headerVersion;
    @XmlElement(name = "SessionID", required = true)
    protected String sessionID;
    @XmlElement(name = "SessionSequenceNumber")
    protected BigInteger sessionSequenceNumber;
    @XmlElement(name = "BusinessProcessOriginator")
    protected BusinessProcessOriginator businessProcessOriginator;
    @XmlElement(name = "BusinessUniqueID", required = true)
    protected String businessUniqueID;
    @XmlElement(name = "BuidSequence")
    protected String buidSequence;
    @XmlElement(name = "ReleaseVersion")
    protected BigInteger releaseVersion;
    @XmlElement(name = "Data")
    protected Data data;
    @XmlElement(name = "OriginalSource", required = true)
    protected cz.csob.thub.ws.clients.clientlist.OriginalSource originalSource;
    @XmlElement(name = "UltimateTarget")
    protected UltimateTarget ultimateTarget;
    @XmlElement(name = "QoS")
    protected QualityOfService qoS;
    @XmlElement(name = "Retry")
    protected Retry retry;
    @XmlElement(name = "Extension")
    protected MetaHeader.Extension extension;

    /**
     * Gets the value of the headerVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHeaderVersion() {
        return headerVersion;
    }

    /**
     * Sets the value of the headerVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHeaderVersion(BigInteger value) {
        this.headerVersion = value;
    }

    /**
     * Gets the value of the sessionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

    /**
     * Gets the value of the sessionSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSessionSequenceNumber() {
        return sessionSequenceNumber;
    }

    /**
     * Sets the value of the sessionSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSessionSequenceNumber(BigInteger value) {
        this.sessionSequenceNumber = value;
    }

    /**
     * Gets the value of the businessProcessOriginator property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessProcessOriginator }
     *     
     */
    public BusinessProcessOriginator getBusinessProcessOriginator() {
        return businessProcessOriginator;
    }

    /**
     * Sets the value of the businessProcessOriginator property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessProcessOriginator }
     *     
     */
    public void setBusinessProcessOriginator(BusinessProcessOriginator value) {
        this.businessProcessOriginator = value;
    }

    /**
     * Gets the value of the businessUniqueID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessUniqueID() {
        return businessUniqueID;
    }

    /**
     * Sets the value of the businessUniqueID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessUniqueID(String value) {
        this.businessUniqueID = value;
    }

    /**
     * Gets the value of the buidSequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuidSequence() {
        return buidSequence;
    }

    /**
     * Sets the value of the buidSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuidSequence(String value) {
        this.buidSequence = value;
    }

    /**
     * Gets the value of the releaseVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReleaseVersion() {
        return releaseVersion;
    }

    /**
     * Sets the value of the releaseVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReleaseVersion(BigInteger value) {
        this.releaseVersion = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link Data }
     *     
     */
    public Data getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link Data }
     *     
     */
    public void setData(Data value) {
        this.data = value;
    }

    /**
     * Gets the value of the originalSource property.
     * 
     * @return
     *     possible object is
     *     {@link cz.csob.thub.ws.clients.clientlist.OriginalSource }
     *     
     */
    public cz.csob.thub.ws.clients.clientlist.OriginalSource getOriginalSource() {
        return originalSource;
    }

    /**
     * Sets the value of the originalSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link cz.csob.thub.ws.clients.clientlist.OriginalSource }
     *     
     */
    public void setOriginalSource(cz.csob.thub.ws.clients.clientlist.OriginalSource value) {
        this.originalSource = value;
    }

    /**
     * Gets the value of the ultimateTarget property.
     * 
     * @return
     *     possible object is
     *     {@link UltimateTarget }
     *     
     */
    public UltimateTarget getUltimateTarget() {
        return ultimateTarget;
    }

    /**
     * Sets the value of the ultimateTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link UltimateTarget }
     *     
     */
    public void setUltimateTarget(UltimateTarget value) {
        this.ultimateTarget = value;
    }

    /**
     * Gets the value of the qoS property.
     * 
     * @return
     *     possible object is
     *     {@link QualityOfService }
     *     
     */
    public QualityOfService getQoS() {
        return qoS;
    }

    /**
     * Sets the value of the qoS property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityOfService }
     *     
     */
    public void setQoS(QualityOfService value) {
        this.qoS = value;
    }

    /**
     * Gets the value of the retry property.
     * 
     * @return
     *     possible object is
     *     {@link Retry }
     *     
     */
    public Retry getRetry() {
        return retry;
    }

    /**
     * Sets the value of the retry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Retry }
     *     
     */
    public void setRetry(Retry value) {
        this.retry = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link MetaHeader.Extension }
     *     
     */
    public MetaHeader.Extension getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaHeader.Extension }
     *     
     */
    public void setExtension(MetaHeader.Extension value) {
        this.extension = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence minOccurs="0">
     *         &lt;element name="OriginalSource" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence minOccurs="0">
     *                   &lt;element name="Brand" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "originalSource"
    })
    public static class Extension
        implements Serializable
    {

        @XmlElement(name = "OriginalSource")
        protected MetaHeader.Extension.OriginalSource originalSource;

        /**
         * Gets the value of the originalSource property.
         * 
         * @return
         *     possible object is
         *     {@link MetaHeader.Extension.OriginalSource }
         *     
         */
        public MetaHeader.Extension.OriginalSource getOriginalSource() {
            return originalSource;
        }

        /**
         * Sets the value of the originalSource property.
         * 
         * @param value
         *     allowed object is
         *     {@link MetaHeader.Extension.OriginalSource }
         *     
         */
        public void setOriginalSource(MetaHeader.Extension.OriginalSource value) {
            this.originalSource = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence minOccurs="0">
         *         &lt;element name="Brand" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "brand"
        })
        public static class OriginalSource
            implements Serializable
        {

            @XmlElement(name = "Brand")
            @XmlSchemaType(name = "nonNegativeInteger")
            protected BigInteger brand;

            /**
             * Gets the value of the brand property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getBrand() {
                return brand;
            }

            /**
             * Sets the value of the brand property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setBrand(BigInteger value) {
                this.brand = value;
            }

        }

    }

}
