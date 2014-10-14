package Log;


import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Justin on 2014/8/15.
 */
public class Dumpable {
    private static final Map<Class, Logger> staticLoggerMap = new ConcurrentHashMap<>();
    private static final int LOGGER_POOL_THRESHOLD = 500;

    public Logger getLoggerForCurrentClass() {
        return getStaticLogger(this.getClass());
    }

    public Logger getStaticLogger(Class clazz) {
        if (!staticLoggerMap.containsKey(clazz)) {
            if (staticLoggerMap.size() >= LOGGER_POOL_THRESHOLD) {
                staticLoggerMap.clear();
            }
            staticLoggerMap.put(clazz, Logger.getLogger(clazz));
        }
        return staticLoggerMap.get(clazz);
    }

    public void debug(String message) {
        getLoggerForCurrentClass().debug(message);
    }

    public void info(String message) {
        getLoggerForCurrentClass().info(message);
    }

    public void error(String message) {
        getLoggerForCurrentClass().error(message);
    }
}
