package kr.co.service;

import java.util.List;

import kr.co.domain.NoticeVO;

public interface NoticeService {

	public List<NoticeVO> getList();
	
	public void register(NoticeVO notice);
	
}
