package configurationTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.framework.core.config.HibernateConfig;
import com.framework.core.model.AppUser;

public class HibernateTest {

	public static void main(String[] args) {
		System.out.println("Application test");
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		AppUser user = new AppUser();
		user.setUsername("Aziz");
		user.setEmail("azizshaikh912@gmail.com");
		user.setPassword("aziz@123");
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

}
