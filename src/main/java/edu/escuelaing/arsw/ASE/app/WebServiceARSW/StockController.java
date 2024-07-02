package edu.escuelaing.arsw.ASE.app.WebServiceARSW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller to fetch stock data using StockService.
 */
@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    /**
     * Fetches intraday stock data for a specific symbol.
     *
     * @param symbol The stock symbol for the query.
     * @return Intraday data in JSON format.
     */
    @GetMapping("/intraday")
    public String getIntraday(@RequestParam String symbol) {
        return stockService.getStockData("TIME_SERIES_INTRADAY", symbol);
    }

    /**
     * Fetches daily stock data for a specific symbol.
     *
     * @param symbol The stock symbol for the query.
     * @return Daily data in JSON format.
     */
    @GetMapping("/daily")
    public String getDaily(@RequestParam String symbol) {
        return stockService.getStockData("TIME_SERIES_DAILY", symbol);
    }

    /**
     * Fetches weekly stock data for a specific symbol.
     *
     * @param symbol The stock symbol for the query.
     * @return Weekly data in JSON format.
     */
    @GetMapping("/weekly")
    public String getWeekly(@RequestParam String symbol) {
        return stockService.getStockData("TIME_SERIES_WEEKLY", symbol);
    }

    /**
     * Fetches monthly stock data for a specific symbol.
     *
     * @param symbol The stock symbol for the query.
     * @return Monthly data in JSON format.
     */
    @GetMapping("/monthly")
    public String getMonthly(@RequestParam String symbol) {
        return stockService.getStockData("TIME_SERIES_MONTHLY", symbol);
    }
}
