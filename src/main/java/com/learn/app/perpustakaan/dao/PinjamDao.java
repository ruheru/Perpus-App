package com.learn.app.perpustakaan.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learn.app.perpustakaan.model.PinjamD;

public interface PinjamDao extends PagingAndSortingRepository<PinjamD, String>{
}
