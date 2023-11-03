package com.backend.app.store.client;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
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

import com.backend.app.store.models.Drawing;

@FeignClient(name = "service.drawings", url = "localhost:8002")
public interface DrawingClientFeign {
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public List<Drawing> getAllDrawings();

	@GetMapping("/{id}")
	public Drawing getDrawingById(@PathVariable("id") Long id);

	@GetMapping("/byDate")
	public Drawing getDrawingByDate(
			@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date);
}
