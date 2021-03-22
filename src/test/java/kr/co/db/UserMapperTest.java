package kr.co.db;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.UserVO;
import kr.co.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserMapperTest {
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void insertTest() {
		log.info("User Insert Test................");
		UserVO vo = new UserVO();
		vo.setUser_id("haru");
		vo.setUser_pw("1111");
		log.info(vo);
		
		userMapper.insert(vo);
	}
	
	@Test
	public void getListTest() {
		log.info("User List Test...................");
		List<UserVO> vo1 = userMapper.getList();
		for(UserVO userVO : vo1) {
			log.info(userVO);
		}
	}
}
