package com.springboot.backend.app.computers.controllers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.app.computers.dao.IDrawingDao;
import com.springboot.backend.app.computers.entity.Drawing;
import com.springboot.backend.app.computers.services.IDrawingService;

@RestController

public class DrawingController {

	private final IDrawingDao drawingDao;
	private final IDrawingService drawingService;

	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	public DrawingController(IDrawingDao drawingDao, IDrawingService drawingService) {
		this.drawingDao = drawingDao;
		this.drawingService = drawingService;
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public List<Drawing> getAllDrawings() {
		return drawingService.findAll().stream().map(drawing -> {
			drawing.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return drawing;
		}).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Drawing> getDrawingById(@PathVariable Long id) {
		Drawing drawing = drawingService.findById(id);
//		try {
//			Thread.sleep(2000L);
//			
//		}catch(InterruptedException e) {
//			e.printStackTrace();
			return ResponseEntity.ok(drawing);
		
	}

	@PostMapping("")
	public ResponseEntity<Drawing> createDrawing(@RequestBody Drawing drawing) {
		drawingDao.save(drawing);
		return ResponseEntity.status(HttpStatus.CREATED).body(drawing);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Drawing> modifyDrawing(@PathVariable Long id, @RequestBody Drawing updatedDrawing) {
		Drawing existingDrawing = drawingService.findById(id);

		if (existingDrawing != null) {
			existingDrawing.setTitulo(updatedDrawing.getTitulo());
			existingDrawing.setDescripcion(updatedDrawing.getDescripcion());
			existingDrawing.setImagen(updatedDrawing.getImagen());
			existingDrawing.setCategoria(updatedDrawing.getCategoria());

			drawingDao.save(existingDrawing);

			return ResponseEntity.ok(existingDrawing);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDrawing(@PathVariable Long id) {
		Drawing drawing = drawingService.findById(id);
		if (drawing != null) {
			drawingDao.delete(drawing);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/byDate")
	public ResponseEntity<Drawing> getDrawingByDate(@RequestParam(name = "date") @DateTimeFormat Date date) {
		Drawing drawing = drawingService.getByDate(date);
		if (drawing != null) {
			return ResponseEntity.ok(drawing);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/dia")
	public ResponseEntity<List<Drawing>> getDrawingsByCurrentDate() {
		
		
		// Obtén el día actual en formato UTC
		LocalDate currentDateUtc = LocalDate.now(ZoneId.of("UTC"));

		// Convierte el día actual en un valor numérico (yyyyMMdd) en formato UTC
		String currentDateValueUtc = currentDateUtc.format(DateTimeFormatter.ISO_DATE);

		// Pasa el día actual en formato UTC como parámetro para obtener los dibujos
		List<Drawing> drawings = drawingService.getAllByDate(currentDateValueUtc);
		
		
		
		if (!drawings.isEmpty()) {
			return ResponseEntity.ok(drawings);
		} else {
			throw new RuntimeException("No se encontraron dibujos el dia de hoy");
		}
		

	}

}
