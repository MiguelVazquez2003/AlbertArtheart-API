package com.backend.app.tienda.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.backend.app.tienda.client.DrawingClientFeign;
import com.backend.app.tienda.models.Store;

@Service("serviceFeign")
@Primary


public class StoreServiceFeign implements StoreService {

	@Autowired
	private DrawingClientFeign drawingFeign;
	
	@Override
	public List<Store> findAll() {
	    return drawingFeign.getAllDrawings().stream()
	        .map(p -> new Store(p, 5))
	        .collect(Collectors.toList());
	}


	@Override
	public Store findById(Long id, int cantidad) {
		return new Store(drawingFeign.getDrawingById(id),cantidad);
	}

}
