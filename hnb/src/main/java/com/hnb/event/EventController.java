package com.hnb.event;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hnb.global.Command;
import com.hnb.global.CommandFactory;
import com.hnb.member.MemberController;
import com.hnb.member.MemberService;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;


@Controller
@RequestMapping("/event")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	@Autowired
	MemberServiceImpl service;
	@Autowired
	MemberVO member;
	@RequestMapping("/boardList/{}")
	public String boardList(
			@RequestParam(value="pageNo",defaultValue="1")String pageNo,
			@RequestParam(value="column",required=false)String column,
			@RequestParam(value="searchKey",required=false)String searchKey,
			Model model){
		logger.info("이벤트컨트롤러아티클");
		Command command = CommandFactory.list(pageNo);
		List<MemberVO> list = service.getList(command);
		model.addAttribute("memberList", list);
		int count = service.count();
		model.addAttribute("count", count);
		model.addAttribute("pageNo", 1);
		return "event/boardList.tiles";
	}
}