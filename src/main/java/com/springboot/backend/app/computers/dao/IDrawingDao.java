package com.springboot.backend.app.computers.dao;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.app.computers.entity.Drawing;

public interface IDrawingDao extends CrudRepository<Drawing,Long> {
    List<Drawing> findByDiaCreacionBetween(Date startOfDay, Date endOfDay);

}
