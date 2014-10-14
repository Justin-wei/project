package ActionUtil;

import Log.Dumpable;
import org.apache.struts2.dispatcher.DefaultActionSupport;

/**
 * Created by Justin on 2014/8/15.
 */
public class BaseAction extends DefaultActionSupport {
    public void debug(String message) {
        new Dumpable().debug(message);
    }
}
