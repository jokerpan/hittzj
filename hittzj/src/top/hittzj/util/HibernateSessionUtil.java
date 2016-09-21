package top.hittzj.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {
	// 放回session，需要再开启事物才可以继续进行工作
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();
		Session session = configuration.buildSessionFactory().openSession();
		return session;
	}

}
