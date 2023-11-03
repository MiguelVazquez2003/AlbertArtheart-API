package com.backend.app.notificaciones.models;

public class Notificacion {
	private Drawing drawing;
	private String destinatario;
    private String asunto;
    private String mensaje;

    public Notificacion() {
    }

	public Notificacion(Drawing drawing, String destinatario, String asunto, String mensaje) {
		this.drawing = drawing;
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}

	public Drawing getDrawing() {
		return drawing;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

    
}
