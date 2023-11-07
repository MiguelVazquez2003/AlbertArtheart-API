package com.backend.app.tienda.services;

import java.util.List;

import com.backend.app.tienda.models.Store;

public interface StoreService {
public List<Store> findAll();
public Store findById(Long id, int cantidad);
}
