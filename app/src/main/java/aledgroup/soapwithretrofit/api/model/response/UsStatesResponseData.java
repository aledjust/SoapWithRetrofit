package aledgroup.soapwithretrofit.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by aled on 10/23/2016.
 */

@Root(name = "GetInfoByCityResponse", strict = false)
@Namespace(reference = "http://www.webserviceX.NET")
public class UsStatesResponseData {

    @Element(name = "GetInfoByCityResult", required = false)
    private UsStatesResponseInfo data;

    public UsStatesResponseInfo getData() {
        return data;
    }

    public void setData(UsStatesResponseInfo data) {
        this.data = data;
    }
}
