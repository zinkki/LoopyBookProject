package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.BookVO;
import kr.co.domain.OrderVO;
import kr.co.mapper.OrderMapper;

@Service
public class OrderServiceImp implements OrderService{

	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public List<OrderVO> orderList() {
		return orderMapper.getList();
	}

	@Override
	public void addorder(OrderVO order) {
		 orderMapper.insert(order);
	}

	@Override
	public List<OrderVO> readOrderList(int user_number) {
		return orderMapper.getOrderList(user_number);
	}

	@Override
	public List<BookVO> readBookList(int user_number) {
		return orderMapper.getBookList(user_number);
	}

	@Override
	public void oneBookadd(int book_id) {
		 orderMapper.oneBookInsert(book_id);
	}

	

	
}
