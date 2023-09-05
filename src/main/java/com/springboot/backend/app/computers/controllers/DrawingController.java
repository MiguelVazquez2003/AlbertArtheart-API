package com.springboot.backend.app.computers.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.backend.app.computers.dao.DrawingDaoImpl;
import com.springboot.backend.app.computers.dao.IDrawingDao;
import com.springboot.backend.app.computers.entity.Drawing;
import com.springboot.backend.app.computers.services.DrawingServiceImpl;
import com.springboot.backend.app.computers.services.IDrawingService;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/drawings")
public class DrawingController {

    private final IDrawingDao drawingDao;
    private final IDrawingService drawingService;

    @Autowired
    public DrawingController(IDrawingDao drawingDao,IDrawingService drawingService) {
        this.drawingDao = drawingDao;
		this.drawingService = drawingService;
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity<List<Drawing>> getAllDrawings() {
        List<Drawing> drawings = drawingDao.findAll();
        return ResponseEntity.ok(drawings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drawing> getDrawingById(@PathVariable Long id) {
        Drawing drawing = drawingDao.findOne(id);
        if (drawing != null) {
            return ResponseEntity.ok(drawing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Drawing> createDrawing(@RequestBody Drawing drawing) {
        drawingDao.save(drawing);
        return ResponseEntity.status(HttpStatus.CREATED).body(drawing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrawing(@PathVariable Long id) {
        Drawing drawing = drawingDao.findOne(id);
        if (drawing != null) {
            drawingDao.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byDate")
    public ResponseEntity<Drawing> getDrawingByDate(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Drawing drawing = drawingService.getByDate(date);
        if (drawing != null) {
            return ResponseEntity.ok(drawing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


