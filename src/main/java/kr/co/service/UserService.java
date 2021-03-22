package kr.co.service;

import java.util.List;

import kr.co.domain.UserVO;

public interface UserService {

	public void join(UserVO join);
	
	public List<UserVO> getList();
	
	public boolean idcheck(String user_id);
	
	public void joinSelectKey(UserVO user);
	
	public UserVO login(UserVO user);
}
