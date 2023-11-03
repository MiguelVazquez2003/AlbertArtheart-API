package com.springboot.backend.app.computers.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	 @Transactional(readOnly = true)
	    @Override
	    public List<Drawing> getAllByDate(String currentDateUtc) {
	        // Parsea la fecha actual a un formato de tipo LocalDateTime
	        LocalDateTime currentDate = LocalDate.parse(currentDateUtc, DateTimeFormatter.ISO_DATE).atStartOfDay();

	        // Calcula la fecha de inicio y fin del día actual
	        LocalDateTime startOfDay = currentDate;
	        LocalDateTime endOfDay = currentDate.plusDays(1).minusNanos(1);

	        // Convierte LocalDateTime a java.util.Date
	        Date startOfDayAsDate = Date.from(startOfDay.atZone(ZoneId.of("UTC")).toInstant());
	        Date endOfDayAsDate = Date.from(endOfDay.atZone(ZoneId.of("UTC")).toInstant());

	        // Utiliza una consulta de rango para buscar los dibujos dentro del día actual
	        return drawingDao.findByDiaCreacionBetween(startOfDayAsDate, endOfDayAsDate);
	    }



}
