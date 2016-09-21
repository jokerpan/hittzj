package top.hittzj.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.util.HibernateSessionUtil;

public class CSSearchDao {
	private Session session;
	private Transaction trans;

	public List<Commodity_Sell> search(Commodity_Sell cs) {
		try {
			String hql = "from Commodity_Sell c where c.name like " + "'%" + cs.getName() + "%'";
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<Commodity_Sell> list = query.list();
			if (list.size() > 10) {
				list = list.subList(0, 10);
			} else {
				list = list.subList(0, list.size());
			}
			trans.commit();
			session.close();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
			return null;
		}
	}
}
