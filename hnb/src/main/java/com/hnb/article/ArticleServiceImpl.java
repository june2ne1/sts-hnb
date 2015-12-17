package com.hnb.article;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.ArticleMapper;
import com.hnb.mapper.MemberMapper;
import com.hnb.movie.MovieController;

@Service
public class ArticleServiceImpl implements ArticleService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	
	@Override
	public int write(ArticleVO article) {
		logger.info("ArticleServiceImpl : write");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.insert(article);
	}

	@Override
	public List<ArticleVO> getList(Command command) {
		logger.info("ArticleServiceImpl : getList");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectAll(command);
	}

	@Override
	public List<ArticleVO> searchByKeyword(Command command) {
		logger.info("ArticleServiceImpl : searchByKeyword");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectSomeBy(command);
	}

	@Override
	public ArticleVO searchById(int rcdNo) {
		logger.info("ArticleServiceImpl : searchById");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectOneBy(rcdNo);
	}

	@Override
	public int count() {
		logger.info("ArticleServiceImpl : count");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.count();
	}

	@Override
	public int countByKeyword(Command command) {
		logger.info("ArticleServiceImpl : countByKeyword");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.countByKeyword(command);
	}

	@Override
	public int change(ArticleVO article) {
		logger.info("ArticleServiceImpl : change");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.update(article);
	}

	@Override
	public int remove(int rcdNo) {
		logger.info("ArticleServiceImpl : remove");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.delete(rcdNo);
	}

}
