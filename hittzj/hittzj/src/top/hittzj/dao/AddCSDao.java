package top.hittzj.dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/15
 *
 */

public class AddCSDao {
	private Session session;
	private Transaction trans;
	/**
	 * @param Commodit_Sell 
	 * @return false/true
	 */
	public boolean save(Commodity_Sell cs) {
		try {
			session=HibernateSessionUtil.getSession();
			trans =session.beginTransaction();
			session.save(cs);
			trans.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return false;
			
		}
	}

}
