package com.backend.app.tienda.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.tienda.models.Drawing;
import com.backend.app.tienda.models.Store;
import com.backend.app.tienda.services.StoreService;
import com.backend.app.tienda.services.StoreServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

public class StoreController {
	
	@Autowired
	private StoreService storeService;

	@GetMapping("/list")
	public List<Store> findAll() {
		return storeService.findAll();
	}
	
	@HystrixCommand(fallbackMethod="metodoRespuesta")
	@GetMapping("/{id}/{cantidad}")
	public Store details(@PathVariable Long id, @PathVariable int cantidad) {
	    return storeService.findById(id, cantidad);
	}
	public Store metodoRespuesta(Long id, int cantidad) {
		  Drawing defaultDrawing = new Drawing();
		    defaultDrawing.setId(-1L);  // ID predeterminado
		    defaultDrawing.setTitulo("Dibujo de muestra");
		    defaultDrawing.setDescripcion("Esta es una descripción de un dibujo de muestra.");
		    defaultDrawing.setImagen("https://firebasestorage.googleapis.com/v0/b/dibujos-2c099.appspot.com/o/Imagenes%2F1.jpg?alt=media&token=953f16d4-8b9a-40b4-9dfc-ada9068cf943");
		    defaultDrawing.setDiaCreacion(new Date());
		    defaultDrawing.setCategoria("Arte abstracto");

		    // Crea un objeto Store con valores inventados
		    Store fallbackStore = new Store(defaultDrawing, 1);  // Cantidad predeterminada de 1
		    return fallbackStore;
	}
}
