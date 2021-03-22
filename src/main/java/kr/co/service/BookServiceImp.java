package kr.co.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.domain.BookVO;
import kr.co.mapper.BookMapper;
import kr.co.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService{
	
	final private BookMapper bookMapper;
	
	@Override
	public List<BookVO> getList(String book_kategorie) {
		return bookMapper.getList(book_kategorie);
	}

	@Override
	public void register(BookVO book) {
		// TODO Auto-generated method stub
		bookMapper.insert(book);
	}

	@Override
	public BookVO get(int book_id) {
		// TODO Auto-generated method stub
		return bookMapper.read(book_id);
	}

	@Override
	public String kategorie(String book_kategorie) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public BookVO get(int book_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int modify(BookVO book) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int remove(int book_id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
