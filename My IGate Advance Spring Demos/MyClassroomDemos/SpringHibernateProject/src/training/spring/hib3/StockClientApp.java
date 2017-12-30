package training.spring.hib3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import training.spring.hib3.entity.Stock;
import training.spring.hib3.service.StockService;
public class StockClientApp 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    	  new ClassPathXmlApplicationContext("stock-config1.xml"); 
    	StockService stockService = (StockService)appContext.getBean("stockService"); 
    	/** insert **/
    	
    	Stock stock = new Stock();
    	stock.setStockCode("7668");
    	stock.setStockName("addd");
    	
    	stockService.save(stock);    
    	
    	Stock stock1 = new Stock();
    	stock1.setStockCode("7868");
    	stock1.setStockName("bdffg");
    	stockService.save(stock1);
    	
    	/** select **/
    	Stock stock2 = stockService.findByStockCode("7668");
    	System.out.println(stock2);
 
    	/** update **/
    	stock2.setStockName("Hhjh");
    	stockService.update(stock2);
 
    	/** delete **/
    	//stockService.delete(stock2);
 
    	System.out.println("Done");
    }
}
