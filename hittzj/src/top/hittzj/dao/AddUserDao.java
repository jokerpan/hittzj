package top.hittzj.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @time 8/13
 * @version 1.0
 * 
 */
// 添加用户(用于注册场景)

public class AddUserDao {
	private Session session;

	/**
	 * @param user（所有信息）
	 * @return true/false
	 */
	public boolean saveUser(User user) {
		try {
			session = HibernateSessionUtil.getSession();
			Transaction transaction=session.getTransaction();
			
			//判断用户是否已经注册
			String hql="from User user where user.count="+user.getCount();
//			System.out.println("查询是否已经注册的sql语句"+hql);
			Query query=session.createQuery(hql);
			List<User> users = query.list();
			System.out.println("查到的内容是："+users);
			for(User u : users){
				if(u.getCount().equals(user.getCount())){
					System.out.println("有相同的账号");
					session.close();
					return false;
				}
			}
			// 储存用户,数据不齐就会抛出异常
			session.save(user);
			// 提交关闭事物
			session.beginTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// 回滚
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.beginTransaction().rollback();
			session.close();
			return false;
		}
	}

}
