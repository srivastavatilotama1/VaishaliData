package training.spring.hib3.Dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import training.spring.hib3.entity.Stock;

@Repository("stockDao")
public class StockDaoImpl implements StockDao {
	
	private SessionFactory sessionFactory;

	
	@Autowired
	public StockDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("this.sessionFactory : " + this.sessionFactory);
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Stock stock) {
		System.out.println("in save");
		currentSession().save(stock);
	}

	public void update(Stock stock) {
		currentSession().update(stock);
	}

	public void delete(Stock stock) {
		currentSession().delete(stock);
	}

	public Stock findByStockCode(String stockCode) {
		
				
		/*List list = currentSession().createQuery("from Stock where stockCode=?").setString(0,stockCode).list();
		return (Stock) list.get(0);*/
		
      Query	 qry=currentSession().createQuery("from Stock where stockCode=?");
      qry.setString(0,stockCode);
      List list=qry.list();
		return (Stock) list.get(0);
		
		//return new Stock();
	}

}