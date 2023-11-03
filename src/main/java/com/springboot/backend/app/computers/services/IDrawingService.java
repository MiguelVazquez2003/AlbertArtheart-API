package com.springboot.backend.app.computers.services;

import java.util.Date;
import java.util.List;

import com.springboot.backend.app.computers.entity.Drawing;

public interface IDrawingService {

	public List<Drawing> findAll();

	public Drawing findById(Long id);


	public Drawing getByDate(Date date);
	
	public List<Drawing> getAllByDate(String day);

}
