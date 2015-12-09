package com.hnb.ticket;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hnb.member.MemberController;




@Controller
@RequestMapping("/ticket")
public class TichetCotroller {
	private static final Logger logger = LoggerFactory.getLogger(TichetCotroller.class);	
	@Autowired
	TicketService ticketService;
	@Autowired
	TicketVO ticketVO;
	List movieListRate = new ArrayList();
	List movieListAsc = new ArrayList();
	List theaterList = new ArrayList();
	List dateList = new ArrayList();
	List timeList = new ArrayList();
	List seatList = new ArrayList();
	@RequestMapping("/ticket")
	public String ticket(){
		return "/ticket/ticket";
	}
	@RequestMapping("/movieSelect")
	public String movieSelect(
			@RequestParam("movie")String movie,
			@RequestParam("theater")String theater,
			@RequestParam("date")String date,
			Model model
			){
		if (theater==null && date!=null) {
			logger.info("극장널");
			theaterList = ticketService.getTheaterListByMD(movie,date);
		} else if (theater!=null && date==null) {
			logger.info("날짜널");
			dateList = ticketService.getShowDateListByMT(movie,theater);
		} else if (theater==null && date==null) {
			System.out.println("다널");
			theaterList = ticketService.getTheaterListByM(movie);
			dateList = ticketService.getShowDateListByM(movie);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
		}
		List movieSelectList = new ArrayList();
		logger.info("극장 "+theaterList);
		logger.info("날짜 "+dateList);
		movieSelectList.add(theaterList);
		movieSelectList.add(dateList);
		movieSelectList.add(timeList);
		model.addAttribute("movieCheckedList", movieSelectList);
		
		return "/ticket/movieSelect";
	}
	@RequestMapping("/theaterSelect")
	public String theaterSelect(
			@RequestParam("movie")String movie,
			@RequestParam("theater")String theater,
			@RequestParam("date")String date,
			Model model
			){
		if (movie==null && date!=null) {
			movieListRate = ticketService.getMovieRateByTD(theater,date);
			movieListAsc = ticketService.getMovieAscByTD(theater,date);
		} else if (movie!=null && date==null) {
			dateList = ticketService.getShowDateListByMT(movie, theater);
		}else if (movie==null && date==null) {
			movieListRate = ticketService.getMovieRateByT(theater);
			movieListAsc = ticketService.getMovieAscByT(theater);
			dateList = ticketService.getShowDateListByT(theater);
		}else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
		}  
		List theaterSelectList = new ArrayList();
		theaterSelectList.add(movieListRate);
		theaterSelectList.add(movieListAsc);
		theaterSelectList.add(dateList);
		theaterSelectList.add(timeList);
		model.addAttribute("theaterCheckedList", theaterSelectList);
		return "/ticket/theaterSelect";
	}
	@RequestMapping("/dateSelect")
	public String dateSelect(
			@RequestParam("movie")String movie,
			@RequestParam("theater")String theater,
			@RequestParam("date")String date,
			Model model
			){
		if (movie==null && theater!=null) {
			movieListRate = ticketService.getMovieRateByTD(theater,date);
			movieListAsc = ticketService.getMovieAscByTD(theater,date);
		} else if (movie!=null && theater==null) {
			theaterList = ticketService.getTheaterListByMD(movie,date);
		} else if (movie==null && theater==null) {
			movieListRate = ticketService.getMovieRateByD(date);
			movieListAsc = ticketService.getMovieAscByD(date);
			theaterList = ticketService.getTheaterListByD(date);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
		} 
		List dateSelectList = new ArrayList();
		dateSelectList.add(movieListRate);
		dateSelectList.add(movieListAsc);
		dateSelectList.add(theaterList);
		dateSelectList.add(timeList);
		logger.info("타임리스트 ", timeList );
		model.addAttribute("dateCheckedList", dateSelectList);
		return "/ticket/dateSelect";
	}
	@RequestMapping("/choiceseat")
	public String choiceseat(
			@RequestParam("movie")String movie,
			Model model,
			String filmNumber,
			String theater,
			String date,
			String time,
			int result
			){
			filmNumber = ticketService.getFilmNumberBy(movie);
			logger.info("filmNumber", filmNumber);
			ticketVO.setFilmNumber(filmNumber);
			ticketVO.setTheaterName(theater);
			ticketVO.setDate(date);
			ticketVO.setRoomName(time.split(" ")[0]);
			ticketVO.setStartTime(time.split(" ")[1]);
			logger.info(ticketVO.getFilmNumber());
			logger.info(ticketVO.getTheaterName());
			logger.info(ticketVO.getDate());
			logger.info(ticketVO.getRoomName());
			logger.info(ticketVO.getStartTime());
			
			if (result == 1) {
				model.addAttribute("result", "success");
			} else {
				model.addAttribute("result", "success");
			}
		return "/ticket/choiceseat";
	}
	@RequestMapping("/initList")
	public String initList(){
		return "/ticket/initList";
	}
	@RequestMapping("/Seats")
	public String Seats(){
		return "/ticket/Seats";
	}
	@RequestMapping("/initSeats")
	public String initSeats(){
		return "/ticket/initSeats";
	}
	@RequestMapping("/infoSave")
	public String infoSave(){
		return "/ticket/infoSave";
	}
	@RequestMapping("/Confirm")
	public String Confirm(){
		return "/ticket/Confirm";
	}
}
