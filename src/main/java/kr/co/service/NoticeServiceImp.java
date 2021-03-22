package kr.co.service;


import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.domain.NoticeVO;
import kr.co.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImp implements NoticeService {

	final private NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeVO> getList() {
		return noticeMapper.getList();
	}

	@Override
	public void register(NoticeVO notice) {
		noticeMapper.insert(notice);
	}

}
