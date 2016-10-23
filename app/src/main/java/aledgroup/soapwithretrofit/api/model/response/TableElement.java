package aledgroup.soapwithretrofit.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by aled on 10/23/2016.
 */

@Root(name = "Table", strict = false)
public class TableElement {

    @Element(name = "CITY", required = false)
    private String city;

    @Element(name = "STATE", required = false)
    private String state;

    @Element(name = "ZIP", required = false)
    private String zip;

    @Element(name = "TIME_ZONE", required = false)
    private String timeZone;

    @Element(name = "AREA_CODE", required = false)
    private String areaCode;


    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
