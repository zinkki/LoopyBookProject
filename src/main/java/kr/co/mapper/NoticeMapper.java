package kr.co.mapper;

import java.util.List;

import kr.co.domain.NoticeVO;

public interface NoticeMapper {

	public List<NoticeVO> getList();
	
	public void insert(NoticeVO notice);
	
	
}
