package com.backend.app.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.store.models.Store;
import com.backend.app.store.services.StoreService;
import com.backend.app.store.services.StoreServiceImpl;

@RestController
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreService storeService;

	@GetMapping("/list")
	public List<Store> findAll() {
		return storeService.findAll();
	}

	@GetMapping("/{id}/{cantidad}")
	public Store details(@PathVariable Long id, @PathVariable int cantidad) {
	    return storeService.findById(id, cantidad);
	}
}
