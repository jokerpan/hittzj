package top.hittzj.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/15
 *
 */
public class DeleCNDao {

	private Session session;
	private Transaction trans;
	
	/**
	 * @param cn
	 *            id
	 * @return false true
	 */
	public boolean delet(Commodity_Need cn){
		try {
			session=HibernateSessionUtil.getSession();
			String hql="from Commodity_Need cn where cn.id="+cn.getId();
			trans=session.beginTransaction();
			List<Commodity_Need> list= session.createQuery(hql).list();
			if(!list.isEmpty()){
				Commodity_Need cn2=list.get(0);
				session.delete(cn2);
				trans.commit();
				session.close();
				return true;
			}
			return false;
		} catch (HibernateException e) {
			trans.rollback();
			session.close();
			return false;
		}

	}
	
}
