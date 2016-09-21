package top.hittzj.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.Commodity_Type;
import top.hittzj.entity.TzjList;
import top.hittzj.util.HibernateSessionUtil;

public class ListCSByTypeDao {
	private Session session;
	private Transaction trans;

	public TzjList<Commodity_Sell> getList(TzjList<Commodity_Sell> list,
			Commodity_Type type) {
		// 用户一页显示10个
		list.setPageItemCount(10);
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			// 如果没用户总数
			if (list.getTotalItemCount() < 1) {
				// 查询一共有多少个,并设置
				String hql = "select count(*) from Commodity_Sell as commodity_sell where commodity_sell.type.id="
						+ type.getId();
				Query q = session.createQuery(hql);
				Iterator i = q.iterate();
				int totalItemCount = ((Long) i.next()).intValue();
				list.setTotalItemCount(totalItemCount);
			}
			// 如果没有总页数
			if (list.getTotalPageCount() < 1) {
				// 设置总页数

				int totalItemCount = list.getTotalItemCount();
				int totalPageCount = totalItemCount / list.getPageItemCount();
				if (totalItemCount % list.getPageItemCount() > 0) {
					++totalPageCount;
				}
				list.setTotalPageCount(totalPageCount);

			}
			// 没有当前页数
			if (list.getCurrentPage() < 1) {
				list.setCurrentPage(1);
			}
			// 根据当前页数查询内容
			// 确定的起点
			int nowPage = list.getCurrentPage();
			int start = (nowPage - 1) * list.getPageItemCount();
			int end = start + list.getPageItemCount();
			String hql = "from Commodity_Sell commodity_sell where commodity_sell.type.id="
					+ type.getId();
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(end);
			List<Commodity_Sell> commodity_sells = query.list();
			list.setList(commodity_sells);
			trans.commit();
			session.close();
			return list;
		} catch (HibernateException e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return null;
		}
	}
}
