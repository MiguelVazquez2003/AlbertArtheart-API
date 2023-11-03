package com.backend.app.notificaciones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.notificaciones.models.Drawing;
import com.backend.app.notificaciones.models.Notificacion;
import com.backend.app.notificaciones.services.NotificacionServiceImpl;

@RestController
public class NotificacionController {
	 @Autowired
	 
	    private NotificacionServiceImpl notificacionService;

	 // Endpoint para obtener las notificaciones de dibujos del día
    @GetMapping("/notificaciones")
    public ResponseEntity<List<Notificacion>> getNotificaciones() {
        List<Notificacion> notificaciones = notificacionService.getDrawingsForCurrentDay();
        return ResponseEntity.ok(notificaciones);
    }

    // Endpoint para enviar notificaciones por correo electrónico
    @PostMapping("/enviarNotificaciones")
    public ResponseEntity<String> enviarNotificacionesPorCorreo(@RequestBody
    		List<Drawing> drawings, @RequestParam String recipient) {
        notificacionService.sendDrawingsByEmail(drawings, recipient);
        return ResponseEntity.ok("Notificaciones enviadas exitosamente");
    }
}
