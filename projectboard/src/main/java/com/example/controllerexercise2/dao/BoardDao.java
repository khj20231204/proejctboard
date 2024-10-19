package com.example.controllerexercise2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.controllerexercise2.model.Board;

@Mapper
public interface BoardDao {

	public int getListCount();
	public List<Board> getList(int limitStartNumber);

}
