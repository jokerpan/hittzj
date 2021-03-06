package top.hittzj.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * 
 */
public class RelieveCollectorCSDao {
	private Session session;
	private Transaction trans;

	// 解除用户对商品的收藏
	public boolean relieve(Commodity_Sell cs, User user) {
		Commodity_Sell c = new GetCSDao().getCommodity_Sell(cs);
		if (c == null) {
			// System.out.println("没有商品");
			return false;
		}
		int csid = c.getId();
		// 通过count和psd找用户
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			String hql = "from User user where user.count=" + user.getCount()
					+ "and user.psd=" + user.getPsd();
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			if (!list.isEmpty()) {
				User u = list.get(0);
				Set<Commodity_Sell> set = u.getCollectCommodity_Sells();
//				System.out.println("没有删前：" + set);
				Iterator<Commodity_Sell> iterator = set.iterator();
				while (iterator.hasNext()) {
					Commodity_Sell next = iterator.next();
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
			session.close();
			return false;
		}
	}

}
