package top.hittzj.dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 *
 */
public class ModifyCSDao {
	private Session session;
	private Transaction trans;

	public boolean modify(Commodity_Sell cs) {
		Commodity_Sell cs2 = new GetCSDao().getCommodity_Sell(cs);
		if (cs2 == null) {
			return false;
		}
		try {
			if (cs.getDesc() != null) {
				cs2.setDesc(cs.getDesc());
			}
			if (cs.getFlaw() != null) {
				cs2.setFlaw(cs.getFlaw());
			}
			if (cs.getImg() != null) {
				cs2.setImg(cs.getImg());
			}
			if (cs.getLocation() != null) {
				cs2.setLocation(cs.getLocation());
			}
			if (cs.getMoney() != null) {
				cs2.setMoney(cs.getMoney());
			}
			if (cs.getName() != null) {
				cs2.setName(cs.getName());
			}
			if (cs.getNumber() != null) {
				cs2.setNumber(cs.getNumber());
			}
			if (cs.getType() != null) {
				cs2.setType(cs.getType());
			}
			session=HibernateSessionUtil.getSession();
			trans=session.beginTransaction();
			session.saveOrUpdate(cs2);
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
