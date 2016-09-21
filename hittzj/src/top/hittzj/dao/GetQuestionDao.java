package top.hittzj.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.hittzj.entity.Question;
import top.hittzj.util.HibernateSessionUtil;

public class GetQuestionDao {
	private Session session;
	private Transaction trans;

	public Question getQuestionById(Question q) {
		try {
			int id = q.getId();
			if (id < 1) {
				return null;
			}
//			System.out.println("questionµÄidÊÇ£º"+q.getId());
			String hql = "from Question u where u.id=" + q.getId();
//			System.out.println("hql::"+hql);
			session = HibernateSessionUtil.getSession();
			trans = session.beginTransaction();
			Query query = session.createQuery(hql);
//			System.out.println("-----------------------");
			List<Question> list = query.list();
//			System.out.println("-----------------------");
			if (list.isEmpty()) {
				return null;
			}
			Question question = list.get(0);
			trans.commit();
			session.close();
			return question;
		} catch (HibernateException e) {
			Logger logger=Logger.getLogger(this.getClass().getName());
			BasicConfigurator.configure();
			logger.error(this.getClass().getName() +"error"+e);
			session.close();
			return null;
		}
	}

}
