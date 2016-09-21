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
import top.hittzj.entity.TzjList;
import top.hittzj.util.HibernateSessionUtil;

public class ListAllCSDao {
	private Session session;
	private Transaction trans;

	public TzjList<Commodity_Sell> getList(TzjList<Commodity_Sell> list) {
		// 用户一页显示10个
		list.setPageItemCount(10);
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			// 设置项目总数
			if (list.getTotalItemCount() < 1) {
				String hql = "select count(*) from Commodity_Sell as commodity_sell";
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
			String hql = "From Commodity_Sell commodity_sell";
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(end);
			List<Commodity_Sell> commodity_sells = query.list();
			list.setList(commodity_sells);
			trans.commit();
			session.close();
			return list;
		} catch (Exception e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return null;
		}
	}
}
