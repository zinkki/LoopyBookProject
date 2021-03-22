package kr.co.mapper;

import java.util.List;
import kr.co.domain.UserVO;

public interface UserMapper {

	public void insert(UserVO user);
	
	public List<UserVO> getList();
	
	public Long idcheck(String user_id);
	
	public UserVO read(UserVO user);
	
	public int update(UserVO user);
	
	public int delete(int user_number);
	
}
