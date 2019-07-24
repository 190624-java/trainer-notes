package hibernate;

import org.junit.Test;

import com.revature.data.HibernateUtils;

public class Hbm2DdlTest {

	@Test
	public void testDDLCreation() {
		HibernateUtils.getSessionFactory();
	}
	
}
