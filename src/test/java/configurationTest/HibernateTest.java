package configurationTest;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.framework.core.config.HibernateConfig;
import com.framework.core.model.AppUser;
import com.framework.core.model.Client;
import com.framework.core.model.Organization;

public class HibernateTest {

	static final Logger logger = Logger.getLogger(HibernateTest.class);
	public static void main(String[] args) {
		System.out.println("Application test");
		logger.info("hi");
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		AppUser user1 = new AppUser();
		user1.setUsername("100");
		user1.setEmail("100");
		user1.setPassword("100");
		
		Client client = new Client();
		client.setValue("client");
		client.setName("client");
		
		Organization organization = new  Organization();
		organization.setClient(client);
		organization.setName("Org");
		organization.setValue("Org");
		
		AppUser user = new AppUser();
		user.setClient(client);
		user.setOrganization(organization);
		user.setUsername("Aziz");
		user.setEmail("azizshaikh912@gmail.com");
		user.setPassword("aziz@123");
		user.setCreatedBy(user1);
		user.setUpdatedBy(user1);
		session.save(user);
		
		
		//client.setCreatedBy(user1);
		//client.setUpdatedBy(user1);
		//session.save(client);
		
		session.getTransaction().commit();
		session.close();
	}

}
