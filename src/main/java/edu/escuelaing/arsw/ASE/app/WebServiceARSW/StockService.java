package edu.escuelaing.arsw.ASE.app.WebServiceARSW;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service class to fetch stock data from Alpha Vantage API.
 */
@Service
public class StockService {
    //Key Demo
    private static final String API_KEY = "demo";
    //Key Teacher
    //private static final String API_KEY = "Q1QZFVJQ21K7C6XM";
    //Key Johann
    //private static final String API_KEY = "NC4JORUM3R1WGSG9";
    // Alpha Vantage API base URL for stock data
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=" + API_KEY;

    /**
     * Retrieves stock data from Alpha Vantage API based on the specified function and symbol.
     *
     * @param function The function to retrieve (e.g., TIME_SERIES_DAILY, TIME_SERIES_WEEKLY).
     * @param symbol   The stock symbol (e.g., AAPL for Apple, MSFT for Microsoft).
     * @return Stock data in JSON format as a String.
     */
    public String getStockData(String function, String symbol) {
        String url = String.format(BASE_URL, function, symbol);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}


