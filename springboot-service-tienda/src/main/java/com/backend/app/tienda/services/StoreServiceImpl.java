package com.backend.app.tienda.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.app.tienda.models.Drawing;
import com.backend.app.tienda.models.Store;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private RestTemplate clientRest;

	@Override
	public List<Store> findAll() {
		List<Drawing> drawings = Arrays.asList(clientRest.getForObject("http://localhost:8002/all", Drawing[].class));

		return drawings.stream().map(d -> new Store(d, 5)).collect(Collectors.toList());

	}

	@Override
	public Store findById(Long id, int cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		
		pathVariables.put("id", id.toString());
		
		Drawing drawing = clientRest.getForObject("http://localhost:8002/{id}", Drawing.class, pathVariables);
		
		return new Store(drawing,cantidad);
	}

}
