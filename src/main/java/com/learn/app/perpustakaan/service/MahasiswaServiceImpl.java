package com.learn.app.perpustakaan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.app.perpustakaan.dao.MahasiswaDao;
import com.learn.app.perpustakaan.model.Mahasiswa;

@Service
public class MahasiswaServiceImpl implements MahasiswaService{
	@Autowired
	MahasiswaDao mahasiswaDao;

	@Override
	public List<Mahasiswa> findAll() {
		return (List<Mahasiswa>) mahasiswaDao.findAll();
	}

	@Override
	public Mahasiswa findOne(String id) {
		return mahasiswaDao.findOne(id);
	}
	
	
	
}
