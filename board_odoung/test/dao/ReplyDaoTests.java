package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import domain.Reply;
import lombok.extern.log4j.Log4j;

@Log4j
class ReplyDaoTests {
	private ReplyDao replyDao = ReplyDao.getInstance();
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		assertNotNull(replyDao);
	}
	
	@Test
	public void testList() {
		replyDao.list(169L).forEach(log::info);
	}
	
	@Test 
	void testGet() {
		log.info(replyDao.get(41L));
	}
	
	@Test
	void testRegister() {
		Reply reply = new Reply(null, "test case", null, 169L, "javaman");
		replyDao.register(reply);
	}
 
}
