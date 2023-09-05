package com.springboot.backend.app.computers.services;

import java.util.Date;
import java.util.List;

import com.springboot.backend.app.computers.entity.Drawing;

public interface IDrawingService {
	public Drawing getByDate(Date date);
}
