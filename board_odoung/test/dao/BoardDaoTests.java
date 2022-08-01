package dao;

import org.junit.Assert;
import org.junit.Test;

import lombok.extern.log4j.Log4j;


@Log4j
public class BoardDaoTests {
//	private Logger logger = Logger.getLogger(BoardDaoTests.class.getName()); 
	private BoardDao boardDao = BoardDao.getInstance(); 
	
	@Test
	public void testExist() {
		log.info(boardDao.toString());
		Assert.assertNotNull(boardDao);
	}
}
