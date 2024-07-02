package edu.escuelaing.arsw.ASE.app.WebServiceARSW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/intraday")
    public String getIntraday(@RequestParam String symbol) {
        return stockService.getStockData("TIME_SERIES_INTRADAY", symbol);
    }

    @GetMapping("/daily")
    public String getDaily(@RequestParam String symbol) {
        return stockService.getStockData("TIME_SERIES_DAILY", symbol);
    }

    @GetMapping("/weekly")
    public String getWeekly(@RequestParam String symbol) {
        return stockService.getStockData("TIME_SERIES_WEEKLY", symbol);
    }

    @GetMapping("/monthly")
    public String getMonthly(@RequestParam String symbol) {
        return stockService.getStockData("TIME_SERIES_MONTHLY", symbol);
    }
}