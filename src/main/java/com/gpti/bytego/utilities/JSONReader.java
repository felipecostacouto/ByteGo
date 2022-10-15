package com.gpti.bytego.utilities;

import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class JSONReader
{
    public static JSONObject readJsonFromRequest(HttpServletRequest request)
    {
        JSONObject jsonObject = null;

        try {
            BufferedReader bufferedReader = request.getReader();

            String jsonReceived = "";
            String lineRead = bufferedReader.readLine();

            while (lineRead != null)
            {
                jsonReceived = jsonReceived.concat(lineRead);
                lineRead = bufferedReader.readLine();
            }

            jsonObject = new JSONObject(jsonReceived);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
