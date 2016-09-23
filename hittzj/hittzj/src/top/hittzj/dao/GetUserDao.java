package top.hittzj.dao;

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
 * @version 1.0
 * @time 8/14
 * 
 */

public class GetUserDao {
	private Session session;
	private Transaction trans;

	//得到用户对象的所有信息 传入User对象要有count和psd就可以
	/**
	 * @param user（账号 密码）
	 * @return
	 */
	public User findUser(User user) {
		try{
		session = HibernateSessionUtil.getSession();
		trans = session.beginTransaction();	
		String hql="From User user where user.count="+user.getCount()+" and user.psd="+user.getPsd();
		Query query = session.createQuery(hql);
		List<User> list=query.list();
//		System.out.println("list的内容是："+list);
		if(!list.isEmpty()){
			//有用户存在
			User u=list.get(0);
			trans.commit();
			session.close();
			return u;
		}
		else{
			session.close();
			return null;
		}
		} catch (Exception e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return null;
		}
	}
}
