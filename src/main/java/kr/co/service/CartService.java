package kr.co.service;

import java.util.List;

import kr.co.domain.CartVO;
import kr.co.domain.BookVO;

public interface CartService {

	public List<CartVO> cartList();
	
	public void addcart(CartVO cart);
	
	public String findcartbook(CartVO cart);
	
	public void addModify(CartVO cart);
	
	//장바구니 리스트 불러오기
	public List<CartVO> readCartList(int user_number);
	public List<BookVO> readBookList(int user_number);
	
	//삭제
	public int remove(int book_id);
}
