package top.hittzj.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {
	// �Ż�session����Ҫ�ٿ�������ſ��Լ������й���
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();
		Session session = configuration.buildSessionFactory().openSession();
		return session;
	}

}
