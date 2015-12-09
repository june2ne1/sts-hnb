package com.hnb.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/member")
public class MemberController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);	
	@Autowired
	MemberService service;
	@Autowired 
	MemberVO member;
	
	@RequestMapping("/admin_home")
	public String adminHome(){
		return "member/admin_home";
	}
	@RequestMapping("/provision")
	public String provision(){
		return "member/provision";
	}
	@RequestMapping("/join_member")
	public Model joinMember(String id,String password,String name,
				String birth,String addr,String gender,String email,
				String phone,Model model
			){
		logger.info("아이디 : {}",id);
		logger.info("비번 : {}",password);
		logger.info("이름 : {}",name);
		logger.info(" 생년 : {}",birth);
		logger.info("주소 : {}",addr);
		logger.info("성별 : {}",gender);
		logger.info("이메일 : {}",email);
		logger.info("전화번호 : {}",phone);
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(birth);
		member.setAddr(addr);
		member.setGender(gender);
		member.setEmail(email);
		member.setPhone(phone);
		
		int result = service.join(member);
		if (result == 1) {
			logger.info("회원가입 성공");
			model.addAttribute("result", "success");
			model.addAttribute("name", member.getName());
			model.addAttribute(model);
			
		} else {
			logger.info("회원가입 실패");
			model.addAttribute("result", "fail");
			model.addAttribute(model);
		}

		return model;
	}
	@RequestMapping("/join_Result")
	public String joinResult(){
		return "member/join_Result";
	}
	@RequestMapping("/logout")
	public String logout(Model model){
		logger.info("MemberController : logout() ");
		model.addAttribute("result", "success");
		
		return "member/logout";
	}
	@RequestMapping("/login")
	public Model login(String id,String password,Model model){
		logger.info("MemberController : login()");
		logger.info("아이디 : {}",id);
		logger.info("비번 : {}",password);
		 member = service.login(id, password);
		 if (member==null) {
			model.addAttribute("result", "fail");
		} else {
			model.addAttribute("result", "success");
			model.addAttribute("id", id);
			model.addAttribute("pw", password);
			if (id.equals("choa")) {
				model.addAttribute("admin","yes");
			} else {
				model.addAttribute("admin","no");
			}
		}
		return model;
	}
	@RequestMapping("/check_Overlap")
	public String checkOverlap(String id,Model model){
		logger.info("MemberController : checkOverlap()");
		if (service.selectById(id).getId() == null) {
			model.addAttribute("result", "usable");
			model.addAttribute("id", id);
		} else {
			model.addAttribute("result", "unusable");
			model.addAttribute("id", id);
		}
		return "member/check_Overlap";
	}
	@RequestMapping("/mypage")
	public String mypage(){
		logger.info("MemberController : mypage()");
		return "member/mypage";
	}
	@RequestMapping("/detail")
	public String detail(){
		logger.info("MemberController : detail()");
		return "member/detail";
	}
	
	
}
