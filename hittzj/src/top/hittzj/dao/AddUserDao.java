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
// ����û�(����ע�᳡��)

public class AddUserDao {
	private Session session;

	/**
	 * @param user��������Ϣ��
	 * @return true/false
	 */
	public boolean saveUser(User user) {
		try {
			session = HibernateSessionUtil.getSession();
			Transaction transaction=session.getTransaction();
			
			//�ж��û��Ƿ��Ѿ�ע��
			String hql="from User user where user.count="+user.getCount();
//			System.out.println("��ѯ�Ƿ��Ѿ�ע���sql���"+hql);
			Query query=session.createQuery(hql);
			List<User> users = query.list();
			System.out.println("�鵽�������ǣ�"+users);
			for(User u : users){
				if(u.getCount().equals(user.getCount())){
					System.out.println("����ͬ���˺�");
					session.close();
					return false;
				}
			}
			// �����û�,���ݲ���ͻ��׳��쳣
			session.save(user);
			// �ύ�ر�����
			session.beginTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// �ع�
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.beginTransaction().rollback();
			session.close();
			return false;
		}
	}

}
