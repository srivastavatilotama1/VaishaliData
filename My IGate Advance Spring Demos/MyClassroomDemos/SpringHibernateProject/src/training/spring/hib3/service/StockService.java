package training.spring.hib3.service;

import training.spring.hib3.entity.Stock;

public interface StockService {
	 
	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
}