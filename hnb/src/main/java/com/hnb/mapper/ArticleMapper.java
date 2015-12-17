package com.hnb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnb.article.ArticleVO;
import com.hnb.global.Command;
@Repository
public interface ArticleMapper {
	// C : 추가
	public int insert(ArticleVO article);
	
	// R : 조회
	public List<ArticleVO> selectAll(Command command); //전체회원목록
	public List<ArticleVO> selectSomeBy(Command command); //임의의 값으로 검색
	public ArticleVO selectOneBy(int rcdNo); //아이디로 조회
	public int count(); //전체회원수 조회
	public int countByKeyword(Command command); //검색결과의 갯수만 조회
	// U : 개인정보 변경
	public int update(ArticleVO article);
	
	// D : 삭제 
	public int delete(int rcdNo);
}
