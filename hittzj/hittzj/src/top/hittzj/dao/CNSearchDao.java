package top.hittzj.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.util.HibernateSessionUtil;

public class CNSearchDao {
	private Session session;
	private Transaction trans;

	public List<Commodity_Need> search(Commodity_Need cn) {
		try {
			String hql = "from Commodity_Need cn where cn.name like " + "'%" + cn.getName() + "%'" ;
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<Commodity_Need> list = query.list();
			if (list.size() > 10) {
				list = list.subList(0, 10);
			}
			else{
				list=list.subList(0, list.size());
						}
			trans.commit();
			session.close();
			return list;
		} catch (HibernateException e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return null;
		}
	}
}
