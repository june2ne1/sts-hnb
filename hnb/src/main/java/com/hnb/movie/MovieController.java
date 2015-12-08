package com.hnb.movie;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "movie/Movie";
	}
	@RequestMapping("/movie_info")
	public String movieInfo(Model model){
		logger.info("MovieController-movieInfo() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList", list );
		logger.info("영화리스트 조회결과 : {}", list);
		return "movie/movie_info";
	}
	@RequestMapping("/movie_name")
	public String movieName(String filmNumber,Model model){
		logger.info("MovieController-movieName() 진입");
		logger.info("영화아이디 : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("영화제목 : {}",movie.getFilmName());
		model.addAttribute("movie", movie);
		return "movie/movie_name";
	}
	@RequestMapping("/movie_Cut")
	public String movieCut(String filmNumber,Model model){
		logger.info("MovieController-movieCut() 진입");
		logger.info("영화cut : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		String cut = movie.getCut();
		String[]arr = cut.split("/");
		logger.info("arr {}", arr);
		model.addAttribute("arr", arr);
		return "movie/movie_Cut";
	}
	@RequestMapping("/movie_Tra")
	public String movieTra(String filmNumber,Model model){
		logger.info("MovieController-movieTra() 진입");
		logger.info("영화 tra : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		String tra = movie.getTrailer();
		logger.info("getTrailer : {}",tra);
		String[]arrt = tra.split("/");
		logger.info("arrt : {}",arrt);
		model.addAttribute("arrt", arrt);
		return "movie/movie_Tra";
	}
	@RequestMapping("/movie_Basic")
	public String movieBasic(String filmNumber,Model model){
		logger.info("MovieController-movieBasic() 진입");
		logger.info("영화 Basic : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("movieBasic컷의영화제목 : {}",movie.getFilmName());
		model.addAttribute("movie", movie);
		return "movie/movie_Basic";
	}
	@RequestMapping("/movie_Chart")
	public String movieChart(String filmNumber,Model model){
		logger.info("MovieController-movieChart() 진입");
		List<MovieVO> list = service.getList();
		list = service.getList();
		logger.info("영화차트 조회결과 : {}", list);
		model.addAttribute("movieList2", list );
		
		return "movie/movie_Chart";
	}
	
}
