package kr.co.mapper;

import java.util.List;

import kr.co.domain.BookVO;
import kr.co.domain.OrderVO;

public interface OrderMapper {

	public List<OrderVO> getList();
	
	public List<OrderVO> getOrderList(int user_number);
	public List<BookVO> getBookList(int user_number);
	
	public void oneBookInsert(int book_id);
	
	public void insert(OrderVO order);
	
}
