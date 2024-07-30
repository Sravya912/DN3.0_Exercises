package observer;

public class Test {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("ABC Corp", 100.00);
        
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();
        
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
        
        System.out.println("Initial stock price:");
        stockMarket.setStockPrice(105.00);

        System.out.println("\nUpdating stock price:");
        stockMarket.setStockPrice(110.00);
        
        stockMarket.deregisterObserver(mobileApp);
        
        System.out.println("\nAfter deregistering MobileApp:");
        stockMarket.setStockPrice(115.00);
    }
}
