package top.hittzj.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.util.HibernateSessionUtil;

public class IsUserExistDao {
	private Session session;
	private Transaction trans;
	public boolean isExist(String count){
		try {
			String hql="from User u where u.count="+count;
			session=HibernateSessionUtil.getSession();
			trans=session.beginTransaction();
			Query query = session.createQuery(hql);
			List list = query.list();
			if(list.isEmpty()){
				trans.commit();
				session.close();
				return false;
			}
			trans.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return true;
		}
	}

}
