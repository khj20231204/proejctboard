package com.example.controllerexercise2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controllerexercise2.dao.BoardDao;
import com.example.controllerexercise2.model.Board;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;

	public int getListCount() {
		// TODO Auto-generated method stub
		return dao.getListCount();
	}

	public List<Board> getList(int limitStartNumber) {
		// TODO Auto-generated method stub
		return dao.getList(limitStartNumber);
	}

}
