package edu.escuelaing.arsw.ASE.app.WebServiceARSW;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {
    //Key Demo
    private static final String API_KEY = "demo";
    //Key Teacher
    //private static final String API_KEY = "Q1QZFVJQ21K7C6XM";
    //Key Johann
    //private static final String API_KEY = "NC4JORUM3R1WGSG9";

    private static final String BASE_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=" + API_KEY;

    public String getStockData(String function, String symbol) {
        String url = String.format(BASE_URL, function, symbol);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
