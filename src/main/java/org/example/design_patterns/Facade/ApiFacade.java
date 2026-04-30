package org.example.design_patterns.Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {
    /**
     * Simplifies the process of fetching a specific value from a JSON API.
     */
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String jsonResponse = makeHttpRequest(urlString);
        return parseJsonAttribute(jsonResponse, attributeName);
    }

    private String makeHttpRequest(String urlString) throws IOException {
        HttpURLConnection con = null;
        try {
            URL url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Check if HTTP response is 200 OK
            int status = con.getResponseCode();
            if (status != 200) {
                throw new IOException("HTTP request failed with status: " + status);
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                return content.toString();
            }
        } finally {
            if (con != null) con.disconnect();
        }
    }

    private String parseJsonAttribute(String json, String attributeName) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            Object value = jsonObject.get(attributeName);

            if (value == null) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON.");
            }

            return value.toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response.", e);
        }
    }
}
