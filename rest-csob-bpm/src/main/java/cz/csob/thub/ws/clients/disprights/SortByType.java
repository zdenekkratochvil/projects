//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:53 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:56 PM(foreman)-)
//


package cz.csob.thub.ws.clients.disprights;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SortByType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SortByType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.csob.cz/common/core}SortAttribute"/>
 *         &lt;element ref="{http://www.csob.cz/common/core}SortDirection" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortByType", namespace = "http://www.csob.cz/common/v1", propOrder = {
    "sortAttribute",
    "sortDirection"
})
public class SortByType
    implements Serializable
{

    @XmlElement(name = "SortAttribute", namespace = "http://www.csob.cz/common/core", required = true)
    protected String sortAttribute;
    @XmlElement(name = "SortDirection", namespace = "http://www.csob.cz/common/core")
    protected SortDirectionType sortDirection;

    /**
     * Gets the value of the sortAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortAttribute() {
        return sortAttribute;
    }

    /**
     * Sets the value of the sortAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortAttribute(String value) {
        this.sortAttribute = value;
    }

    /**
     * Gets the value of the sortDirection property.
     * 
     * @return
     *     possible object is
     *     {@link SortDirectionType }
     *     
     */
    public SortDirectionType getSortDirection() {
        return sortDirection;
    }

    /**
     * Sets the value of the sortDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortDirectionType }
     *     
     */
    public void setSortDirection(SortDirectionType value) {
        this.sortDirection = value;
    }

}
