package top.hittzj.dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/17
 * 
 */
public class ModifyCNDao {
	private Session session;
	private Transaction trans;

	public boolean modify(Commodity_Need cn) {
		Commodity_Need cn2 = new GetCNDao().getCommodity_Need(cn);
		if (cn2 == null) {
			return false;
		}
		try {
			if (cn.getDesc() != null) {
				cn2.setDesc(cn.getDesc());
			}
			if (cn.getImg() != null) {
				cn2.setImg(cn.getImg());
			}
			if (cn.getLocation() != null) {
				cn2.setLocation(cn.getLocation());
			}
			if (cn.getMoney() != null) {
				cn2.setMoney(cn.getMoney());
			}
			if (cn.getName() != null) {
				cn2.setName(cn.getName());
			}
			if (cn.getNumber() != null) {
				cn2.setNumber(cn.getName());
			}
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			session.update(cn2);
			trans.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			trans.rollback();
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return false;
		}
	}
}
