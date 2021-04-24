package kr.co.mapper;

import java.util.List;

import kr.co.domain.BookVO;
import kr.co.domain.CartVO;
import kr.co.domain.UserVO;

public interface CartMapper {
	
	public List<CartVO> getList();
	//장바구니 리스트 불러오기
	public List<CartVO> getCartList(int user_number);
	public List<BookVO> getBookList(int user_number);

	public void insert(CartVO cart);
	
	//cart리스트에서 이미 존재하는지 ??
	public String select(CartVO cart);
	
	public int update(CartVO cart);
	
	public int addupdate(CartVO cart);
	
	public int amountUpdate(CartVO cart);
	
	//장바구니에서 삭제
	public int delete(int book_id);
}
