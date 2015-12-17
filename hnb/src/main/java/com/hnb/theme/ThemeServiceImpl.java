package com.hnb.theme;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hnb.global.Command;

import com.hnb.mapper.ThemeMapper;

@Service
public class ThemeServiceImpl implements ThemeService{
	private static final Logger logger = LoggerFactory.getLogger(ThemeServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	
	@Override
	public int add(ThemeVO theme) {
		logger.info("ThemeServiceImpl : add");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.add(theme);
	}

	@Override
	public List<ThemeVO> getList(Command command) {
		logger.info("ThemeServiceImpl : getList");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.getList(command);
	}

	@Override
	public List<ThemeVO> searchByKeyword(Command command) {
		logger.info("ThemeServiceImpl : searchByKeyword");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.searchByKeyword(command);
	}

	@Override
	public ThemeVO searchById(int rcdNo) {
		logger.info("ThemeServiceImpl : searchById");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.searchById(rcdNo);
	}

	@Override
	public int count() {
		logger.info("ThemeServiceImpl : count");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.count();
	}

	@Override
	public int countByKeyword(Command command) {
		logger.info("ThemeServiceImpl : countByKeyword");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.countByKeyword(command);
	}

	@Override
	public int change(ThemeVO article) {
		logger.info("ArticleServiceImpl : change");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.change(article);
	}

	@Override
	public int remove(int rcdNo) {
		logger.info("ThemeServiceImpl : remove");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.remove(rcdNo);
	}

}
