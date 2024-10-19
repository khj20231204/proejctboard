package com.example.controllerexercise2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.controllerexercise2.model.Board;
import com.example.controllerexercise2.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("list")
    public String list(@RequestParam(value="page", defaultValue="1") int page) {
       
    	int limit = 10;
    	
    	//총 데이터 갯수
    	int listCount = service.getListCount();
    	System.out.println("listcount : " + listCount);
    	
    	//mysql은 limit와 offset에서 직접적인 사칙연산을 지원하지 않기 때문에 여기서 page를 구한다
    	page = (page-1)*10;
    	List<Board> list = service.getList(page);
    	System.out.println(list);
    	
    	//페이지 네이션 [1] [2] [3] ... [10]
    	int startPage = ((page-1)/limit)*limit + 1; 
		int endPage = startPage + limit - 1;
		int pageCount = listCount/limit + ((listCount % limit == 0) ? 0 : 1);

		System.out.println();
		
       return "board/list";
    }
}
