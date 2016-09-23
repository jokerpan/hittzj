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
	 *            (�˻� ����) �޸ĺ��qq phone nickname
	 * @return fales/true
	 */
	public boolean change(User user) {
		try {
			session = HibernateSessionUtil.getSession();
			// �ж��û��Ƿ��Ѿ�ע�Ტ������
			String hql = "from User user where user.count=" + user.getCount()
					+ "and user.psd=" + user.getPsd();
			// System.out.println("��ѯ�Ƿ��Ѿ�ע���sql���"+hql);
			List<User> users = session.createQuery(hql).list();
			// System.out.println("�鵽�������ǣ�"+users);
			if (!users.isEmpty()) {
				// ���˻�
				// System.out.println("���˻�");
				User u = users.get(0);
//				System.out.println("�ӵ��ĵ������ǣ�"+user.getNickName());
				if (user.getNickName() != null) {
					u.setNickName(user.getNickName());
				}
				if (user.getPhone() != null) {
					u.setPhone(user.getPhone());
				}
				if (user.getQq() != null) {
					u.setQq(user.getQq());
				}
//				System.out.println("����֮��������ǣ�"+u.getNickName());
				session.saveOrUpdate(u);
				session.beginTransaction().commit();
				session.close();
				return true;
			} else {
				// ���˻�
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
