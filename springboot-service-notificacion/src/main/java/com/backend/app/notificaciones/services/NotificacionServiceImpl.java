package com.backend.app.notificaciones.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.app.notificaciones.models.Drawing;
import com.backend.app.notificaciones.models.Notificacion;

@Service
public class NotificacionServiceImpl implements NotificacionService {
	

    @Autowired
	private RestTemplate clientRest;
    
    LocalDate today = LocalDate.now();

    private JavaMailSender javaMailSender;
    @Override
    public List<Notificacion> getDrawingsForCurrentDay() {
        List<Drawing> drawings = Arrays.asList(clientRest.getForObject("http://localhost:8002/dia", Drawing[].class));
        
        String destinatario = "Destinatario";
        String asunto = "Asunto"; 

        String mensaje = "Dibujos del día: ";
        for (Drawing drawing : drawings) {
            mensaje += drawing.getTitulo() + ", ";
        }

        mensaje = mensaje.substring(0, mensaje.length() - 2);

        
        Notificacion notificacion = new Notificacion(null, destinatario, asunto, mensaje);

       
        return Collections.singletonList(notificacion);
    }

    @Override
    public void sendDrawingsByEmail(List<Drawing> drawings, String recipient) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipient); 

        String asunto = "Asunto del Correo";
        mailMessage.setSubject(asunto);

        // Crea el cuerpo del correo incluyendo los nombres de los dibujos
        StringBuilder mensaje = new StringBuilder("Dibujos del día:\n");
        for (Drawing drawing : drawings) {
            mensaje.append(drawing.getDescripcion()).append("\n");
        }
        mailMessage.setText(mensaje.toString());

        // Envía el correo electrónico
        javaMailSender.send(mailMessage);

    }


}
