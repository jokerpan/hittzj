package top.hittzj.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/13
 */
public class ModifyUserInfoDao {
	private Session session;

	/**
	 * @param user
	 *            (账户 密码) 修改后的qq phone nickname
	 * @return fales/true
	 */
	public boolean change(User user) {
		try {
			session = HibernateSessionUtil.getSession();
			// 判断用户是否已经注册并切密码
			String hql = "from User user where user.count=" + user.getCount()
					+ "and user.psd=" + user.getPsd();
			// System.out.println("查询是否已经注册的sql语句"+hql);
			List<User> users = session.createQuery(hql).list();
			// System.out.println("查到的内容是："+users);
			if (!users.isEmpty()) {
				// 有账户
				// System.out.println("有账户");
				User u = users.get(0);
//				System.out.println("接到的的名字是："+user.getNickName());
				if (user.getNickName() != null) {
					u.setNickName(user.getNickName());
				}
				if (user.getPhone() != null) {
					u.setPhone(user.getPhone());
				}
				if (user.getQq() != null) {
					u.setQq(user.getQq());
				}
//				System.out.println("更新之后的名字是："+u.getNickName());
				session.saveOrUpdate(u);
				session.beginTransaction().commit();
				session.close();
				return true;
			} else {
				// 无账户
				session.close();
				return false;
			}
		} catch (Exception e) {
			session.beginTransaction().rollback();
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return false;

		}

	}

}
