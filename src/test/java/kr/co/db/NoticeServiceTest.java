package kr.co.db;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.NoticeVO;
import kr.co.service.NoticeService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeServiceTest {

	@Autowired
	NoticeService ns;
	
	@Test
	
	public void getListTest() {
		log.info("getList......");
		List<NoticeVO> vo = ns.getList();
		for(NoticeVO noticeVO : vo) {
			log.info(noticeVO);
		}
	}
	@Test
	public void registerTest() {
		log.info("registerTest......");
		NoticeVO vo = new NoticeVO();
		vo.setNotice_title("Hello");
		vo.setNotice_content("My name is ZINKKI!!!");
		vo.setNotice_writer("zinkkiii");
		log.info(vo);
		ns.register(vo);
		this.getListTest();
	}
	
}
