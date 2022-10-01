package com.gpti.bytego.utilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSON
{
    private final Map<String, Boolean> booleanKeys = new HashMap<>();
    private final Map<String, Integer> integerKeys = new HashMap<>();
    private final Map<String, Double> doubleKeys = new HashMap<>();
    private final Map<String, Long> longKeys = new HashMap<>();
    private final Map<String, Float> floatKeys = new HashMap<>();
    private final Map<String, String> stringKeys = new HashMap<>();
    private final Map<String, JSON> jsonKeys = new HashMap<>();
    private final List<Map<String, ?>> keys = Arrays.asList(
            booleanKeys, integerKeys, doubleKeys, longKeys, floatKeys, stringKeys, jsonKeys);

    public void putValue(String key, String value)
    {
        stringKeys.put(key, value);
    }

    public void putValue(String key, int value)
    {
        integerKeys.put(key, value);
    }

    public void putValue(String key, double value)
    {
        doubleKeys.put(key, value);
    }

    public void putValue(String key, float value)
    {
        floatKeys.put(key, value);
    }

    public void putValue(String key, long value)
    {
        longKeys.put(key, value);
    }

    public void putValue(String key, boolean value)
    {
        booleanKeys.put(key, value);
    }

    public void putValue(String key, JSON value)
    {
        jsonKeys.put(key, value);
    }

    public int getInt(String key)
    {
        return integerKeys.get(key);
    }

    public double getDouble(String key)
    {
        return doubleKeys.get(key);
    }

    public float getFloat(String key)
    {
        return floatKeys.get(key);
    }

    public long getLong(String key)
    {
        return longKeys.get(key);
    }

    public boolean getBoolean(String key)
    {
        return booleanKeys.get(key);
    }

    public JSON getJSON(String key)
    {
        return jsonKeys.get(key);
    }

    public String getString(String key)
    {
        for (Map<String, ?> map : keys) {
            if (map.get(key) != null) {
                return String.valueOf(map.get(key));
            }
        }

        return "null";
    }

    public void fullPrint()
    {
        fullPrintRecursive(1);
    }

    public void fullPrintRecursive(int numberOfTabsBefore)
    {
        for (Map<String, ?> map : keys) printMap(map, numberOfTabsBefore);
    }

    public boolean existKey(String key)
    {
        for (Map<String, ?> map : keys) if (map.containsKey(key)) return true;
        return false;
    }

    private <K extends String, V> void printMap(Map<String, V> map, int numberOfTabsBefore)
    {
        for (Map.Entry<String, V> entry : map.entrySet()) {
            for (int i = 0; i < numberOfTabsBefore; i++) {
                System.out.print("|\t");
            }
            if (!(entry.getValue() instanceof JSON))
            {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            else
            {
                System.out.println(entry.getKey() + ": ");
                ((JSON) entry.getValue()).fullPrintRecursive(numberOfTabsBefore + 1);
            }
        }
    }
}
