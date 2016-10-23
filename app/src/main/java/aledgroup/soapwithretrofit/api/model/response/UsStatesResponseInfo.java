package aledgroup.soapwithretrofit.api.model.response;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by aled on 10/23/2016.
 */

@Root(name = "GetInfoByCityResult",strict = false)
public class UsStatesResponseInfo {

    @ElementList(name = "NewDataSet",required = false)
    List<TableElement> elements;

    public List<TableElement> getElements() {
        return elements;
    }

    public void setElements(List<TableElement> elements) {
        this.elements = elements;
    }

}
