package hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Player;
import com.revature.data.HibernateUtils;
import com.revature.data.PlayerDAO;

public class PlayerDAOTest {
	
	private static Session session;
	private static Transaction tx;

	@BeforeClass
	public static void beforeClass() {
		session = HibernateUtils.getSessionFactory().openSession();
	}
	
	@Before
	public void before() {
		tx = session.beginTransaction();
	}
	
	@After
	public void after() {
		tx.rollback();
	}
	
	@Test
	public void testSave() {
		Player player = new Player(0, "NedStark", 25);
		PlayerDAO dao = new PlayerDAO();
		dao.save(player);
		System.out.println("Success!");
	}
	
	@Test
	public void testFindPlayer() {
		Player player = new PlayerDAO().findPlayer(1);
		System.out.println(player);
		assertNotNull(player);
		
		//test negative case
		Player player2 = null;
		try {
			player2 = new PlayerDAO().findPlayer(50);
		} catch (Exception e) {
			assertEquals(ObjectNotFoundException.class, e.getClass());
			System.out.println("An exception was thrown.");
		} finally {
			assertNull(player2);
		}
		
	}
	
}
