package kr.co.service;

import java.util.List;

import kr.co.domain.CartVO;

public interface CartService {

	public void addcart(CartVO cart);
	
	public String findcartbook(CartVO cart);
	
	public void addModify(CartVO cart);
	
	public List<CartVO> readlist(int user_number);
}
