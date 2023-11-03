package com.backend.app.notificaciones.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.app.notificaciones.models.Drawing;
import com.backend.app.notificaciones.models.Notificacion;


public interface NotificacionService {
	
	public List<Notificacion> getDrawingsForCurrentDay();
    public void sendDrawingsByEmail(List<Drawing> drawings, String recipient);
}