package com.springboot.backend.app.computers.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.app.computers.dao.IDrawingDao;
import com.springboot.backend.app.computers.entity.Drawing;

@Service
public class DrawingServiceImpl implements IDrawingService {
	private List<Drawing> lista;
	@Autowired
	private IDrawingDao drawingDao;

	public DrawingServiceImpl() {
	}

	@Override
	public Drawing getByDate(Date date) {
		Drawing drawingResult = null;

		for (Drawing drawing : this.lista) {
			if (date == drawing.getDiaCreacion()) {
				drawingResult = drawing;
				break;
			}
		}
		return drawingResult;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Drawing> findAll() {
		return (List<Drawing>) drawingDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Drawing findById(Long id) {

		return drawingDao.findById(id).orElse(null);

	}

}
