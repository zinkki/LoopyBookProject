package kr.co.db;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.BookVO;
import kr.co.mapper.BookMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookMapperTest {

	@Autowired
	BookMapper bm;

	@Test
	public void getListTest() {
		log.info("getListTest.....................");
		List<BookVO> vo1 = bm.getList("");

		for (BookVO bookVO : vo1) {
			log.info(bookVO);
		}
	}

	@Test
	public void insertTest() {
		log.info("insertTest................");
		BookVO vo = new BookVO();
		vo.setBook_title("다락원 일본어 독해");
		vo.setBook_writer("코가 마키코");
		vo.setBook_publisher("다락원");
		vo.setBook_price(12000);
		vo.setBook_kategorie("외국어");
		vo.setBook_intro("다락원 일본어 시리즈의 독해 버전 개념으로 새롭게 출간되는 독해 일본어 시리즈. 게임이나 패션 등 우리 생활에 가까운 주제부터, 일본의 옛날이야기나 위인전, 동물보호와 같은 사회문제까지 폭넓게 다루고 있다.");
		vo.setFileName("/resources/img/다락원독해.jpg");
		log.info(vo);

		bm.insert(vo);
		this.getListTest();
	}

	@Test
	public void readTest() {
		log.info("readTest...................");
		log.info(bm.read(3));
	}
}
