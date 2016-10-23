package aledgroup.soapwithretrofit.api.model.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by aled on 10/23/2016.
 */

@Root(name = "soap12:Body", strict = false)
public class UsStatesRequestBody {

    @Element(name = "GetInfoByCity",required = false)
    private UsStatesRequestData usStatesRequestData;

    public UsStatesRequestData getUsStatesRequestData() {
        return usStatesRequestData;
    }

    public void setUsStatesRequestData(UsStatesRequestData usStatesRequestData) {
        this.usStatesRequestData = usStatesRequestData;
    }

}
