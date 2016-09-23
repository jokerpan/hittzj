package top.hittzj.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.util.HibernateSessionUtil;

/**
 *@author zy_q
 *
 */
public class GetCNDao {
	private Session session;
	private Transaction trans;
	public Commodity_Need getCommodity_Need(Commodity_Need cn){
		try {
			int id =cn.getId();
			if(id<1){
				return null;
			}
			session=HibernateSessionUtil.getSession();
			trans=session.beginTransaction();
			String hql="From Commodity_Need  cn where cn.id="+id;
			Query query = session.createQuery(hql);
			List<Commodity_Need> list = query.list();
			if(list.isEmpty()){
				return null;
			}
			cn=list.get(0);
			session.close();
			return cn;
			
		} catch (Exception e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			return null;
		}
	}

}
