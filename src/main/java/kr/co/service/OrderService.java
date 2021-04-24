package kr.co.service;

import java.util.List;

import kr.co.domain.BookVO;
import kr.co.domain.OrderVO;

public interface OrderService {

	public List<OrderVO> orderList();
	
	public List<OrderVO> readOrderList(int user_number);
	public List<BookVO> readBookList(int user_number);
	
	public void oneBookadd(int book_id);
	
	public void addorder(OrderVO order);
}
