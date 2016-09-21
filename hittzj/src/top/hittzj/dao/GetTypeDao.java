package top.hittzj.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Type;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * 
 */
public class GetTypeDao {
	private Session session;
	private Transaction trans;
	
	public Commodity_Type getType(Commodity_Type ct) {
		String hql = "From Commodity_Type ct where ct.id=" + ct.getId();
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<Commodity_Type> list = query.list();
			if (list.isEmpty()) {
				session.close();
				return null;
			}
			trans.commit();
			session.close();
			return list.get(0);
		} catch (Exception e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return null;
		}
	}

}
