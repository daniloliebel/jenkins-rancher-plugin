package jenkins.plugins.rancher.util;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentParser {
    public static Map<String, Object> parse(String environments) {
        HashMap<String, Object> map = new HashMap<>();
        String[] fragments = environments.split("_DIV_");
        for (String fragement : fragments) {
            if (fragement.contains("_ENV_")) {
                int index = fragement.indexOf("_ENV_");
                String env = fragement.substring(0, index);
                String value = fragement.substring(index + 5, fragement.length());
                map.put(env, value);
            }
        }
        return map;
    }
}
