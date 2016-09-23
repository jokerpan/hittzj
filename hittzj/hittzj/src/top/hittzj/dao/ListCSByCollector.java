package top.hittzj.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.TzjList;
import top.hittzj.entity.User;
import top.hittzj.util.HibernateSessionUtil;

public class ListCSByCollector {
	private Session session;
	private Transaction trans;

	public TzjList<Commodity_Sell> list(TzjList<Commodity_Sell> tzjList,
			User user) {
		// �����û���û�
		try {
			String hql = "from User user where user.count =" + user.getCount()
					+ "and user.psd=" + user.getPsd();
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			if (list.isEmpty()) {
				return null;
			}
			// �õ��û�
			user = list.get(0);
			// �õ��û��ղ�
			Set<Commodity_Sell> set = user.getCollectCommodity_Sells();
			// ����һҳ��ʾ������
			tzjList.setPageItemCount(10);
			// �õ���ǰҳ
			int currentpage = tzjList.getCurrentPage();
			if (currentpage < 1) {
				tzjList.setCurrentPage(1);
			}
			// �õ�������
			tzjList.setTotalItemCount(set.size());
			// �õ���ҳ��
			int totalItemCount = tzjList.getTotalItemCount();
			int totalPageCount = totalItemCount / tzjList.getPageItemCount();
			if (totalItemCount % tzjList.getPageItemCount() > 0) {
				++totalPageCount;
			}
			tzjList.setTotalPageCount(totalPageCount);
			// ������ʾ������
			int start = (tzjList.getCurrentPage() - 1)
					* tzjList.getPageItemCount();
			int end = start + tzjList.getPageItemCount();
			Iterator<Commodity_Sell> iterator = set.iterator();
			List<Commodity_Sell> cns = new ArrayList<Commodity_Sell>();
			while (iterator.hasNext()) {
				cns.add(iterator.next());
			}
			List<Commodity_Sell> cns_ = new ArrayList<Commodity_Sell>();
			for (int a = start; a < end; a++) {
				cns_.add(cns.get(a));
			}
			tzjList.setList(cns_);
			trans.commit();
			session.close();
			return tzjList;
		} catch (HibernateException e) {
			
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return null;
		}
	}
}
