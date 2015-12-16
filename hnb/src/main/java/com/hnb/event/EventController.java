package com.hnb.event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.article.ArticleServiceImpl;
import com.hnb.article.ArticleVO;
import com.hnb.global.Command;
import com.hnb.global.CommandFactory;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;

@Controller
@RequestMapping("/event")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	@Autowired MemberServiceImpl service;
	@Autowired MemberVO memberVO;
	@Autowired ArticleVO article;
	@Autowired ArticleServiceImpl articleService;
	
	
	@RequestMapping("/boardList/{pageNo}")
	public @ResponseBody List<ArticleVO> boardList(
			@PathVariable("pageNo")String pageNo, //default값을 jsp에서 지정함.
			Model model){
		logger.info("EventController - boardList() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		Command command = CommandFactory.list(pageNo);
		List<ArticleVO> list = articleService.getList(command);
		/*int count = service.count();
		model.addAttribute("memberList",list);
		model.addAttribute("count",service.count());
		model.addAttribute("pageNo",pageNo);*/
		return list;
	}
	
	@RequestMapping("/boardList")
	public String goList(){
		logger.info("EventController - article() 진입");
		return "event/boardList.tiles";
	}
	
	
}