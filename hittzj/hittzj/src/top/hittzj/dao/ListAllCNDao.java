package top.hittzj.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.TzjList;
import top.hittzj.util.HibernateSessionUtil;

public class ListAllCNDao {
	private Session session;
	private Transaction trans;

	public TzjList<Commodity_Need> getUserList(TzjList<Commodity_Need> list) {
		// �û�һҳ��ʾ10��
		list.setPageItemCount(10);
		try {
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			// ���û�û�����
			if (list.getTotalItemCount() < 1) {
				// ��ѯһ���ж��ٸ�,������
				String hql = "select count(*) from Commodity_Need as commodity_need";
				Query q = session.createQuery(hql);
				Iterator i = q.iterate();
				int totalItemCount = ((Long) i.next()).intValue();
				list.setTotalItemCount(totalItemCount);
			}
			// ���û����ҳ��
			if (list.getTotalPageCount() < 1) {
				// ������ҳ��

				int totalItemCount = list.getTotalItemCount();
				int totalPageCount = totalItemCount / list.getPageItemCount();
				if (totalItemCount % list.getPageItemCount() > 0) {
					++totalPageCount;
				}
				list.setTotalPageCount(totalPageCount);

			}
			// û�е�ǰҳ��
			if (list.getCurrentPage() < 1) {
				list.setCurrentPage(1);
			}
			// ���ݵ�ǰҳ����ѯ����
			// ȷ�������
			int nowPage = list.getCurrentPage();
			int start = (nowPage - 1) * list.getPageItemCount();
			int end = start + list.getPageItemCount();
			String hql = "From Commodity_Need commodity_need";
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(end);
			List<Commodity_Need> commodity_Needs = query.list();
			list.setList(commodity_Needs);
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
