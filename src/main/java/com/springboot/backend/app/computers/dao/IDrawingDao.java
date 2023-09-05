package com.springboot.backend.app.computers.dao;

import java.util.Date;
import java.util.List;

import com.springboot.backend.app.computers.entity.Drawing;

public interface IDrawingDao {
	
	public List<Drawing> findAll();

	
	public void save(Drawing drawing);

	
	public Drawing findOne(Long id);

	
	public void delete(Long id);
	
}
