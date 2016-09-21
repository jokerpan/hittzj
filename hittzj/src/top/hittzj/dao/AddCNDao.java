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
 */
public class AddCNDao {
	private Session session;
	private Transaction trans;
	/**
	 * @param Commodit_Sell (里面需要完整的人，类型 ，商品)
	 * @return false/true
	 */
	public boolean save(Commodity_Need cn) {
		try {
			session=HibernateSessionUtil.getSession();
			trans =session.beginTransaction();
			session.save(cn);
			trans.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			trans.rollback();
			session.close();
			return false;
			
		}
	}

}
