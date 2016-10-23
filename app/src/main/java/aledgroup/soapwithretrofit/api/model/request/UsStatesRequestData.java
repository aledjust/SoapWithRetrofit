package aledgroup.soapwithretrofit.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by aled on 10/23/2016.
 */

@Root(name = "GetInfoByCity", strict = false)
@Namespace(reference = "http://www.webserviceX.NET")
public class UsStatesRequestData {

    @Element(name = "USCity", required = false)
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
