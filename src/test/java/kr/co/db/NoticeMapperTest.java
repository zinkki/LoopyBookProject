package kr.co.db;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.NoticeVO;
import kr.co.mapper.NoticeMapper;
import lombok.extern.log4j.Log4j2;


@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeMapperTest {

	@Autowired
	NoticeMapper nm;
	
	@Test
	public void getListTest() {
		log.info("getListTest.......");
		List<NoticeVO> vo = nm.getList();
		for(NoticeVO noticeVO : vo) {
			log.info(noticeVO);
		}
	}
	@Test
	public void insertTest() {
		log.info("insertTest......");
		NoticeVO vo = new NoticeVO();
		vo.setNotice_title("Haru is cute");
		vo.setNotice_content("Haru is my cat. So cute!!");
		vo.setNotice_writer("zinkki");
		log.info(vo);
		nm.insert(vo);
		this.getListTest();
		
	}
	
	
	
}
