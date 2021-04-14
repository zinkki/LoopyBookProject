package kr.co.mapper;

import java.util.List;

import kr.co.domain.BookVO;
import kr.co.domain.CartVO;
import kr.co.domain.UserVO;

public interface CartMapper {
	
	public List<CartVO> getList();

	public void insert(CartVO cart);
	
	public String select(CartVO cart);
	
	public void addupdate(CartVO cart);
	
	//장바구니 리스트 불러오기
	public List<CartVO> getCartList(int user_number);
	public List<BookVO> getBookList(int user_number);
	
	//장바구니에서 삭제
	public int delete(int book_number);
}
