//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:53 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:56 PM(foreman)-)
//


package cz.csob.thub.ws.clients.disprights;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StadiumCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StadiumCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="OUT"/>
 *     &lt;enumeration value="INT_IN"/>
 *     &lt;enumeration value="INT_OUT"/>
 *     &lt;enumeration value="FILTER"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="TTL_EXCE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StadiumCode")
@XmlEnum
public enum StadiumCode {

    IN,
    OUT,
    INT_IN,
    INT_OUT,
    FILTER,
    ERROR,
    TTL_EXCE;

    public String value() {
        return name();
    }

    public static StadiumCode fromValue(String v) {
        return valueOf(v);
    }

}
