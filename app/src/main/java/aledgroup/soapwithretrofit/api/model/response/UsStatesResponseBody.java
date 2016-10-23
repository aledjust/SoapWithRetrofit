package aledgroup.soapwithretrofit.api.model.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by aled on 10/23/2016.
 */

@Root(name = "Body", strict = false)
public class UsStatesResponseBody {

    @Element(name = "GetInfoByCityResponse", required = false)
    private UsStatesResponseData data;

    public UsStatesResponseData getData() {
        return data;
    }

    public void setData(UsStatesResponseData data) {
        this.data = data;
    }
}
