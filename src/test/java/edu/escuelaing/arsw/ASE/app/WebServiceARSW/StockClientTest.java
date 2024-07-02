package edu.escuelaing.arsw.ASE.app.WebServiceARSW;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Test class to execute StockClient concurrently using multiple threads.
 */
public class StockClientTest {

    /**
     * Main method to execute StockClient with multiple threads.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Number of threads to execute concurrently
        int numberOfThreads = 10; // You can change this to 100 if needed

        // Create a fixed thread pool with the specified number of threads
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Submit tasks to the executor (each task is an instance of StockClientTask)
        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(new StockClientTask());
        }

        // Shutdown the executor when all tasks are completed
        executor.shutdown();
    }

    /**
     * Runnable task that runs the StockClient.
     */
    static class StockClientTask implements Runnable {
        @Override
        public void run() {
            String symbol = "IBM"; // Stock symbol to query (replace with any desired symbol)
            String interval = "daily"; // Interval for the stock data (can be "intraday", "daily", "weekly", or "monthly")
            String baseURL = "https://www.alphavantage.co/query?function=TIME_SERIES_%s&symbol=%s&apikey=";
            String API_KEY = "demo"; // Replace with your actual Alpha Vantage API key

            String url = String.format(baseURL + API_KEY, interval.toUpperCase(), symbol);

            try {
                StockClient.sendGET(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
