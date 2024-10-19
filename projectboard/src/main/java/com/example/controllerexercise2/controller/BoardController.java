package com.example.controllerexercise2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.controllerexercise2.model.Board;
import com.example.controllerexercise2.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("boardlist")
    public String list(@RequestParam(value="page", defaultValue="1") int page, Model model) {
       
    	int limit = 10;
    	
    	//총 데이터 갯수
    	int listCount = service.getListCount();
    	System.out.println("listcount : " + listCount);
    	
    	//mysql은 limit와 offset에서 직접적인 사칙연산을 지원하지 않기 때문에 여기서 limit를 구한다
		/*
		한페이지에 보여줄 목록수 : 10개
		page 1 : 1,10 : select * from board limit 0,10;
		page 2 : 10,10 : select * from board limit 10,10;
		page 3 : 20,10 : select * from board limit 20,10;

		limit A B => A는 전체 데이터 중 시작번호, B는 보여줄 갯수 10개 고정
		limit = 1, 10, 20, 30, 으로 limt A B 
		limit값은 전체 데이터 중 시작번호
		*/ 
    	int limitStartNumber = (page-1)*limit;
    	List<Board> boardList = service.getList(limitStartNumber);
    	
    	//페이지 네이션 [1] [2] [3] ... [10]
    	int startPage = ((page-1)/limit)*limit + 1; 
		int endPage = startPage + limit - 1;
		int pageCount = listCount/limit + ((listCount % limit == 0) ? 0 : 1);

		/* System.out.println("page:"+page + " ,startPage:"+startPage + " ,endPage:"+endPage+" ,pageCount:"+pageCount); */
		
		/* 총 페이지수 */
		int maxPage = listCount/limit + (listCount % limit == 0 ? 0 : 1);


		if(endPage > maxPage){
			endPage = maxPage;
		}

		//페이지 목록 보여주기에 필요
		model.addAttribute("page", page);
		model.addAttribute("limit", limit);
		model.addAttribute("listCount", listCount);
		model.addAttribute("limitStartNumber", limitStartNumber);
		model.addAttribute("boardList", boardList);
		//페이지네이션에 필요
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("maxPage", maxPage);
		

      return "board/boardlist";
    }
}
