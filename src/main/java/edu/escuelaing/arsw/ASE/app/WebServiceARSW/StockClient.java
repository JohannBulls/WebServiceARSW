package edu.escuelaing.arsw.ASE.app.WebServiceARSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Client class to fetch stock data from the Alpha Vantage API.
 */
public class StockClient {

    /**
     * Main method to demonstrate fetching stock data for a specific symbol and interval.
     *
     * @param args Command-line arguments (not used in this example).
     * @throws IOException If an I/O exception occurs during the HTTP GET request.
     */
    public static void main(String[] args) throws IOException {
        String symbol = "IBM"; // Stock symbol to query (replace with any desired symbol)
        String interval = "daily"; // Interval for the stock data (can be "intraday", "daily", "weekly", or "monthly")
        String baseURL = "https://www.alphavantage.co/query?function=TIME_SERIES_%s&symbol=%s&apikey=";
        String API_KEY = "demo"; // Replace with your actual Alpha Vantage API key
        String url = String.format(baseURL + API_KEY, interval.toUpperCase(), symbol);
        sendGET(url);
    }

    /**
     * Sends an HTTP GET request to the specified URL and prints the response.
     *
     * @param GET_URL The URL to send the GET request to.
     * @throws IOException If an I/O exception occurs during the HTTP GET request.
     */
    public static void sendGET(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // Success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            // Read the response line by line and append to the response StringBuilder
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the full response
            System.out.println(response.toString());
        } else { // Error handling
            System.out.println("GET request not worked");
        }
    }
}
