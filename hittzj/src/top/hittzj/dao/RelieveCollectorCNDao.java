package top.hittzj.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/17
 * 
 */
public class RelieveCollectorCNDao {
	// ɾ���м����ɾ���û�����Ʒ
	private Session session;
	private Transaction trans;

	// ����û�����Ʒ���ղ�
	public boolean relieve(Commodity_Need cn, User user) {
		Commodity_Need c = new GetCNDao().getCommodity_Need(cn);
		if (c == null) {
			// System.out.println("û����Ʒ");
			return false;
		}
		int csid = c.getId();
		// ͨ��count��psd���û�
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			String hql = "from User user where user.count=" + user.getCount()
					+ "and user.psd=" + user.getPsd();
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			if (!list.isEmpty()) {
				User u = list.get(0);
				Set<Commodity_Need> set = u.getCollectCommodity_Needs();
				// System.out.println("û��ɾǰ��" + set);
				Iterator<Commodity_Need> iterator = set.iterator();
				while (iterator.hasNext()) {
					Commodity_Need next = iterator.next();
					if (next.getId() == csid) {
						set.remove(next);
						trans.commit();
						session.close();
						return true;

					}
				}
				trans.commit();
				session.close();
				return true;
			}
			session.close();
			return false;
		} catch (HibernateException e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return false;
		}
	}

}
