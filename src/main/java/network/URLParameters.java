package network;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class URLParameters
{
    public static Map<String, Object> getQueryParameters(URI uri)
    {
        System.out.println(">>> Analysing URL " + uri.getQuery());
        Map<String, Object> map = new HashMap<>();
        String[] argSeparated = uri.getQuery().split("&");
        for (String argument : argSeparated) map.put(argument.split("=")[0], argument.split("=")[1]);
        return map;
    }

}
