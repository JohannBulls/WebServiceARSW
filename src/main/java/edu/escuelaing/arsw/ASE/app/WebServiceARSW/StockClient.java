package edu.escuelaing.arsw.ASE.app.WebServiceARSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StockClient {

    public static void main(String[] args) throws IOException {
        String symbol = "IBM";
        String interval = "daily"; // Puedes cambiar el intervalo a "intraday", "weekly", o "monthly"
        String URLs= "https://www.alphavantage.co/query?function=TIME_SERIES_%s&symbol=%s&apikey=";
        String API_KEY = "demo";
        String url = String.format(URLs+API_KEY, interval.toUpperCase(), symbol);
        sendGET(url);
    }

    private static void sendGET(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
    }
}