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

	//�õ��û������������Ϣ ����User����Ҫ��count��psd�Ϳ���
	/**
	 * @param user���˺� ���룩
	 * @return
	 */
	public User findUser(User user) {
		try{
		session = HibernateSessionUtil.getSession();
		trans = session.beginTransaction();	
		String hql="From User user where user.count="+user.getCount()+" and user.psd="+user.getPsd();
		Query query = session.createQuery(hql);
		List<User> list=query.list();
//		System.out.println("list�������ǣ�"+list);
		if(!list.isEmpty()){
			//���û�����
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
