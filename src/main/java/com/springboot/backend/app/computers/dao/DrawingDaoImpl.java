package com.springboot.backend.app.computers.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.app.computers.entity.Drawing;

@Repository
public class DrawingDaoImpl implements IDrawingDao{
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Drawing> findAll() {
		return em.createQuery("from Drawing").getResultList();
	}

	@Override
	@Transactional
	public void save(Drawing drawing) {
		if(drawing.getId() != null && drawing.getId() > 0) {
			em.merge(drawing);
		} else {
			em.persist(drawing);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Drawing findOne(Long id) {
		return em.find(Drawing.class, id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}
	

	
	

}
