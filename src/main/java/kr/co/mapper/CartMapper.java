package kr.co.mapper;

import java.util.List;

import kr.co.domain.BookVO;
import kr.co.domain.CartVO;
import kr.co.domain.UserVO;

public interface CartMapper {

	public void insert(CartVO cart);
	
	public String select(CartVO cart);
	
	public void addupdate(CartVO cart);
	
	public List selectlist(int user_number);
	
	
}
