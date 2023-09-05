package com.springboot.backend.app.computers.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.backend.app.computers.entity.Drawing;

@Service
public class DrawingServiceImpl implements IDrawingService{
	private List<Drawing> lista;

	public DrawingServiceImpl() {
		
	}
	
	@Override
	public Drawing getByDate(Date date) {
		this.lista = lista;
		Drawing drawingResult = null;
		
		for(Drawing drawing : this.lista) {
			if(date == drawing.getDiaCreacion()) {
				drawingResult = drawing;
				break;
			}
		}
		return drawingResult; 
	}
}
