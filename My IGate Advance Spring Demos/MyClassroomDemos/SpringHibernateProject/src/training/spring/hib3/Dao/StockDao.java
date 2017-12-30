package training.spring.hib3.Dao;

import training.spring.hib3.entity.Stock;

public interface StockDao {
	 
	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
 
}
