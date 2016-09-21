package top.hittzj.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.util.HibernateSessionUtil;

public class DeleCSDao {
	private Session session;
	private Transaction trans;
	
	/**
	 * @param cn
	 *            id
	 * @return false true
	 */
	public boolean delet(Commodity_Sell cs){
		try {
			session=HibernateSessionUtil.getSession();
			String hql="from Commodity_Sell cs where cs.id="+cs.getId();
			trans=session.beginTransaction();
			List<Commodity_Sell> list= session.createQuery(hql).list();
			if(!list.isEmpty()){
				Commodity_Sell cs2=list.get(0);
				session.delete(cs2);
				trans.commit();
				session.close();
				return true;
			}
			return false;
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
