package Utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSON
{
    private final String title;
    Map<String, Object> keys = new HashMap<>();

    JSON (String title)
    {
        this.title = title;
        keys.put(title, null);
    }

    public Object getByKey(String key)
    {
        if (!keys.containsKey(key)) return new JSON(key).getByKey(key);
        return keys.get(key);
    }


}
