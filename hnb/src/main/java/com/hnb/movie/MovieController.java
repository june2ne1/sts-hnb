package com.hnb.movie;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.admin.AdminController;

@Controller
@RequestMapping("/movie")
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieServiceImpl service;
	@Autowired
	MovieVO movie;
	
	@RequestMapping("/Movie")
	public String movie(){
		logger.info("MovieController-movie() 진입");
		return "movie/Movie.tiles";
	}
	@RequestMapping("/movie_info")
	public Model movieInfo(Model model){
		logger.info("MovieController-movieInfo() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList", list );
		logger.info("영화리스트 조회결과 : {}", list);
		return model;
	}
	@RequestMapping("/movie_name")
	public @ResponseBody MovieVO movieName(String filmNumber){
		logger.info("MovieController-movieName() 진입");
		logger.info("영화아이디 : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("영화제목 : {}",movie.getFilmName());
		return movie;
	}
	@RequestMapping("/movie_Cut")
	public Model movieCut(String filmNumber,Model model){
		logger.info("MovieController-movieCut() 진입");
		logger.info("영화cut : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		String cut = movie.getCut();
		String[]arr = cut.split("/");
		logger.info("arr {}", arr);
		model.addAttribute("arr", arr);
		return model;
	}
	@RequestMapping("/movie_Tra")
	public Model movieTra(String filmNumber,Model model){
		logger.info("MovieController-movieTra() 진입");
		logger.info("영화 tra : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		String tra = movie.getTrailer();
		logger.info("getTrailer : {}",tra);
		String[]arrt = tra.split("/");
		logger.info("arrt : {}",arrt);
		model.addAttribute("arrt", arrt);
		return model;
	}
	@RequestMapping("/movie_Basic")
	public @ResponseBody MovieVO movieBasic(String filmNumber,Model model){
		logger.info("MovieController-movieBasic() 진입");
		logger.info("영화 Basic : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("movieBasic컷의영화제목 : {}",movie.getFilmName());
		model.addAttribute("movie", movie);
		return movie;
	}
	@RequestMapping("/movie_Chart")
	@ModelAttribute("")
	public Model movieChart(String filmNumber,Model model){
		logger.info("MovieController-movieChart() 진입");
		List<MovieVO> list = service.getList();
		list = service.getList();
		logger.info("영화차트 조회결과 : {}", list);
		model.addAttribute("movieList2", list );
		return model;
	}
	
}
