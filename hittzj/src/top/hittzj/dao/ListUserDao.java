package top.hittzj.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

/**
 * @author zy_q
 * @version 1.0
 * @time 8/17
 */
public class ListUserDao {
	private Session session;
	private Transaction trans;

	public TzjList<User> getUserList(TzjList<User> list) {
		// 用户一页显示10个
		list.setPageItemCount(10);
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			// 如果没用户总数
			if (list.getTotalItemCount() < 1) {
				// 查询一共有多少个,并设置
				String hql = "select count(*) from User as user";
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
			String hql = "From User user";
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(end);
			List<User> userList = query.list();
			list.setList(userList);
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
