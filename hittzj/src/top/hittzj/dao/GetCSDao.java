package top.hittzj.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * 
 *         通过id获得商品
 */

public class GetCSDao {
	private Session session;
	private Transaction trans;

	public Commodity_Sell getCommodity_Sell(Commodity_Sell cs) {
		int id = cs.getId();
		if (id < 1) {
			return null;
		}
		try {
			String hql = "from Commodity_Sell cs where cs.id=" + id;
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<Commodity_Sell> list = query.list();
			if (list.isEmpty()) {
				return null;
			}
			cs = list.get(0);
			// 运用懒加载
			User user = cs.getUser();
			user.getPhone();
			trans.commit();
			session.close();
			return cs;
		} catch (HibernateException e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return null;
		}
	}
}
