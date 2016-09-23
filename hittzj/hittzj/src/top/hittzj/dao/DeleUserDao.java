package top.hittzj.dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/16
 *
 */
public class DeleUserDao {
	private Session session;
	private Transaction trans;

	/**
	 * @param user
	 * @return false/true
	 */
	public boolean deletUser(User user) {
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			String hql = "Delete FROM User user Where user.count="
					+ user.getCount();
			Query q = this.session.createQuery(hql);
			int result = q.executeUpdate();
			trans.commit();
			if (result < 1) {
				session.close();
				return false;
			}
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
