package com.hnb.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnb.admin.AdminController;

@Controller
@RequestMapping("/movie")
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieServiceImpl service;
	@RequestMapping("/Movie")
	public String movie(){
		logger.info("MovieController-movie() 진입");
		return "movie/Movie";
	}
	@RequestMapping("/movie_info")
	public String movieInfo(){
		logger.info("MovieController-movieInfo() 진입");
		return "movie/movie_info";
	}
	@RequestMapping("/movie_name")
	public String movieName(){
		logger.info("MovieController-movieName() 진입");
		return "movie/movie_name";
	}
	@RequestMapping("/movie_Cut")
	public String movieCut(){
		logger.info("MovieController-movieCut() 진입");
		return "movie/movie_Cut";
	}
	@RequestMapping("/movie_Tra")
	public String movieTra(){
		logger.info("MovieController-movieTra() 진입");
		return "movie/movie_Tra";
	}
	@RequestMapping("/movie_Basic")
	public String movieBasic(){
		logger.info("MovieController-movieBasic() 진입");
		return "movie/movie_Basic";
	}
	@RequestMapping("/movie_Chart")
	public String movieChart(){
		logger.info("MovieController-movieChart() 진입");
		return "movie/movie_Chart";
	}
	
}
