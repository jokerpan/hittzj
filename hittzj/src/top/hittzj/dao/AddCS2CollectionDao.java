package top.hittzj.dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/18
 *
 */
public class AddCS2CollectionDao {
	private Session session;
	private Transaction trans;

	public boolean add2Collection(Commodity_Sell cs, User user) {
		Commodity_Sell c = new GetCSDao().getCommodity_Sell(cs);
		if(c==null){
			return false;
		}
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			String hql = "from User user where user.count=" + user.getCount()
					+ "and user.psd=" + user.getPsd();
			Query query = session.createQuery(hql);
			List<User> list = query.list();
//			System.out.println("开始判断");
			if (!list.isEmpty()) {
				user = list.get(0);
//				System.out.println("有用户"+user);
				Set<Commodity_Sell> set = user.getCollectCommodity_Sells();
				set.add(c);
				session.update(user);
				trans.commit();
				session.close();
				return true;
			} else {
//				System.out.println("没用户");
				session.close();
				return false;
			}
		} catch (Exception e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			trans.rollback();
			session.close();
			return false;
		}

	}
}
