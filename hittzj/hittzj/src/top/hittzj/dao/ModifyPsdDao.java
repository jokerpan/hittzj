package top.hittzj.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

public class ModifyPsdDao {
	private Session session;
	private Transaction trans;

	/**
	 * @param user
	 *            (账号 保密问题 保密答案 修改后的密码) 有问题
	 * @return false/true
	 */
	public boolean modifyPsd(User user) {
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			String hql = "from User user where user.count=" + user.getCount()
					+ " and user.question.id=" + user.getQuestion().getId();
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			if (list.isEmpty()) {
//				System.out.println("没有账号");
				return false;
			}
//			System.out.println("有账号");
			// 得到完整的信息
			User u = list.get(0);
			if (u.getAnswer().equals(user.getAnswer())) {
//				System.out.println("新的密码是："+user.getPsd());
				u.setPsd(user.getPsd());
				session.update(u);
				trans.commit();
				session.close();
				return true;
			}
			return false;
		} catch (Exception e) {
			trans.rollback();
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return false;
		}
	}
}
