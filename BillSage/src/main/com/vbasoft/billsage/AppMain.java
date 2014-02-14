package com.vbasoft.billsage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.vbasoft.billsage.model.entity.User;

public class AppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory buildSessionFactory = null;
		
		try {
			buildSessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.out.println("AppMain.main(): Failed to connect DB server.\n Please check server is up and running");
			System.exit(1);
		}
		
		Session session = buildSessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		tx.begin();
		for(int i =0 ; i<10;i++) {
			User user = new User("User-" + (i+1), "user-" + (i+1) + "@billsage.com");
			session.save(user);
		}
		tx.commit();
		
		session.close();
		if(session.isOpen()) {
			System.out.println("Session is still open");
			System.out.println(session.getStatistics());
			System.exit(0);
		}
		
		//Get Operation
		Session session2 = buildSessionFactory.openSession();
//		session2.get(arg0, arg1)
		Query query = session2.createQuery("from User");// where userName='Balaji'");
		query.setFirstResult(4);
		query.setMaxResults(3);
		List<User> users2 = query.list();
		System.out.println(users2.size());
		
		for(User user : users2) {
			System.out.println(user.getUserName() + "\t" + user.getEmailId());
		}
		//Another way HQL - Criteria APIs
		
		User exampleUser = new User();
		exampleUser.setUserId(6);
		exampleUser.setEmailId("%@billsage.com");
		
		Example example = Example.create(exampleUser).excludeProperty("emailId");
		
		Criteria criteria = session2.createCriteria(User.class);
//		criteria.setProjection(Projections.property("userName"))
//				.addOrder(Order.desc("userId"))
//				.add(Restrictions.between("userId", 5L, 9L));

		criteria.add(example)
				.addOrder(Order.desc("userId"));
//				.add(Restrictions.like("userName", "%-%"));
		
		
		System.out.println("Thru Criteria API" + criteria.list());
		/*List<String> users3 = (List<String>)criteria.list();
		for(String user : users3) {
			System.out.println(user);
		}*/
		List<User> users3 = criteria.list();
		for(User user : users3) {
			System.out.println(user.getUserName());
		}
		session2.close();

	}

}
