package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.CartVO;
import kr.co.mapper.CartMapper;

@Service
public class CartServiceImp implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Override
	public void addcart(CartVO cart) {
		cartMapper.insert(cart);
	}

	@Override
	public String findcartbook(CartVO cart) {
		return cartMapper.select(cart);
	}

	@Override
	public void addModify(CartVO cart) {
		cartMapper.addupdate(cart);
	}

	@Override
	public List<CartVO> readlist(int user_number) {
		return cartMapper.selectlist(user_number);
		
	}
	
	

}
