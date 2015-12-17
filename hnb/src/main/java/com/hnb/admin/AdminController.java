package com.hnb.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.article.ArticleServiceImpl;
import com.hnb.article.ArticleVO;
import com.hnb.global.Command;
import com.hnb.global.CommandFactory;
import com.hnb.main.MainController;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;
import com.hnb.movie.MovieServiceImpl;
import com.hnb.movie.MovieVO;





@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired MemberServiceImpl memberservice;
	@Autowired MovieServiceImpl movieservice;
	@Autowired MemberVO member;
	@Autowired MovieVO movie;
	@Autowired List<MemberVO> list;
	@Autowired List<MovieVO> movie_list;

	@RequestMapping("/main")
	public String home(){
		logger.info("AdminController-home() 진입");
		return "admin/admin/main.tiles";
	}
	@RequestMapping("/movie_list")
	public String movieList(){
		logger.info("AdminController-movie_list() 진입");
		return "admin/movie_list";
	}

	@RequestMapping("/member_list/{pageNo}")
	public @ResponseBody Map<String,Object> memberList(
			@PathVariable("pageNo")String pageNo, //default값을 jsp에서 지정함.
			Model model){
		logger.info("AdminController - memberList() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		Command command = CommandFactory.list(pageNo);
		List<MemberVO> list = memberservice.getList(command);
		int count = memberservice.count();
		model.addAttribute("memberList",list);
		model.addAttribute("count",memberservice.count());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("count", memberservice.count());
		map.put("pageNo", pageNo);
		model.addAttribute("pageNo",pageNo);
		return map;
	}
	@RequestMapping("/member_profile")
	public String memberProfile(){
		logger.info("AdminController-member_profile() 진입");
		return "admin/member_profile";
	}
	@RequestMapping("/movie_profile")
	public String movieProfile(){
		logger.info("AdminController-movie_profile() 진입");
		return "admin/movie_profile";
	}
	@RequestMapping("/insert")
	public String insert(){
		logger.info("AdminController-insert() 진입");
		return "admin/insert";
	}
	@RequestMapping("/insert2")
	public String insert2(){
		logger.info("AdminController-insert2() 진입");
		return "admin/insert2";
	}
	@RequestMapping("/delete")
	public String delete(){
		logger.info("AdminController-delete() 진입");
		return "admin/delete";
	}
}
