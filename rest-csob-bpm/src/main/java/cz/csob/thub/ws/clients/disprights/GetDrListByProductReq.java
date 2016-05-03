//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:53 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:56 PM(foreman)-)
//


package cz.csob.thub.ws.clients.disprights;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="ProductFilterList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProductFilter" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="ProductNumber">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="20"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="HomeCurrency" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="BankSystem" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="ProductPrefix" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="6"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="History" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;element name="RightTypeList">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="RightType" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="10"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="LimitFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "productFilterList"
})
@XmlRootElement(name = "GetDrListByProductReq", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1")
public class GetDrListByProductReq
    implements Serializable
{

    @XmlElement(name = "ProductFilterList", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1", required = true)
    protected GetDrListByProductReq.ProductFilterList productFilterList;

    /**
     * Gets the value of the productFilterList property.
     * 
     * @return
     *     possible object is
     *     {@link GetDrListByProductReq.ProductFilterList }
     *     
     */
    public GetDrListByProductReq.ProductFilterList getProductFilterList() {
        return productFilterList;
    }

    /**
     * Sets the value of the productFilterList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetDrListByProductReq.ProductFilterList }
     *     
     */
    public void setProductFilterList(GetDrListByProductReq.ProductFilterList value) {
        this.productFilterList = value;
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
     *       &lt;sequence>
     *         &lt;element name="ProductFilter" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="ProductNumber">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="20"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="HomeCurrency" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                   &lt;element name="BankSystem" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="ProductPrefix" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="6"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="History" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                   &lt;element name="RightTypeList">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="RightType" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="10"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="LimitFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
        "productFilter"
    })
    public static class ProductFilterList
        implements Serializable
    {

        @XmlElement(name = "ProductFilter", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1", required = true)
        protected List<GetDrListByProductReq.ProductFilterList.ProductFilter> productFilter;

        /**
         * Gets the value of the productFilter property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the productFilter property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProductFilter().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetDrListByProductReq.ProductFilterList.ProductFilter }
         * 
         * 
         */
        public List<GetDrListByProductReq.ProductFilterList.ProductFilter> getProductFilter() {
            if (productFilter == null) {
                productFilter = new ArrayList<GetDrListByProductReq.ProductFilterList.ProductFilter>();
            }
            return this.productFilter;
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
         *       &lt;sequence>
         *         &lt;element name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="ProductNumber">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="20"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="HomeCurrency" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *         &lt;element name="BankSystem" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="ProductPrefix" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="6"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="History" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="RightTypeList">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="RightType" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="10"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="LimitFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "sequenceNumber",
            "productNumber",
            "homeCurrency",
            "bankSystem",
            "productPrefix",
            "history",
            "rightTypeList",
            "limitFlag"
        })
        public static class ProductFilter
            implements Serializable
        {

            @XmlElement(name = "SequenceNumber", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1")
            protected BigInteger sequenceNumber;
            @XmlElement(name = "ProductNumber", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1", required = true)
            protected String productNumber;
            @XmlElement(name = "HomeCurrency", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1", required = true)
            protected BigInteger homeCurrency;
            @XmlElement(name = "BankSystem", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1")
            protected BigInteger bankSystem;
            @XmlElement(name = "ProductPrefix", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1")
            protected String productPrefix;
            @XmlElement(name = "History", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1")
            protected Boolean history;
            @XmlElement(name = "RightTypeList", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1", required = true)
            protected GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList rightTypeList;
            @XmlElement(name = "LimitFlag", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1")
            protected Boolean limitFlag;

            /**
             * Gets the value of the sequenceNumber property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getSequenceNumber() {
                return sequenceNumber;
            }

            /**
             * Sets the value of the sequenceNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setSequenceNumber(BigInteger value) {
                this.sequenceNumber = value;
            }

            /**
             * Gets the value of the productNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProductNumber() {
                return productNumber;
            }

            /**
             * Sets the value of the productNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProductNumber(String value) {
                this.productNumber = value;
            }

            /**
             * Gets the value of the homeCurrency property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getHomeCurrency() {
                return homeCurrency;
            }

            /**
             * Sets the value of the homeCurrency property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setHomeCurrency(BigInteger value) {
                this.homeCurrency = value;
            }

            /**
             * Gets the value of the bankSystem property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getBankSystem() {
                return bankSystem;
            }

            /**
             * Sets the value of the bankSystem property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setBankSystem(BigInteger value) {
                this.bankSystem = value;
            }

            /**
             * Gets the value of the productPrefix property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProductPrefix() {
                return productPrefix;
            }

            /**
             * Sets the value of the productPrefix property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProductPrefix(String value) {
                this.productPrefix = value;
            }

            /**
             * Gets the value of the history property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isHistory() {
                return history;
            }

            /**
             * Sets the value of the history property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setHistory(Boolean value) {
                this.history = value;
            }

            /**
             * Gets the value of the rightTypeList property.
             * 
             * @return
             *     possible object is
             *     {@link GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList }
             *     
             */
            public GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList getRightTypeList() {
                return rightTypeList;
            }

            /**
             * Sets the value of the rightTypeList property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList }
             *     
             */
            public void setRightTypeList(GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList value) {
                this.rightTypeList = value;
            }

            /**
             * Gets the value of the limitFlag property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isLimitFlag() {
                return limitFlag;
            }

            /**
             * Sets the value of the limitFlag property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setLimitFlag(Boolean value) {
                this.limitFlag = value;
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
             *       &lt;sequence>
             *         &lt;element name="RightType" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="10"/>
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
                "rightType"
            })
            public static class RightTypeList
                implements Serializable
            {

                @XmlElement(name = "RightType", namespace = "http://www.csob.cz/distribution/DispositionalRights/getDrListByProduct/v1", required = true)
                protected List<BigInteger> rightType;

                /**
                 * Gets the value of the rightType property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the rightType property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getRightType().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link BigInteger }
                 * 
                 * 
                 */
                public List<BigInteger> getRightType() {
                    if (rightType == null) {
                        rightType = new ArrayList<BigInteger>();
                    }
                    return this.rightType;
                }

            }

        }

    }

}
