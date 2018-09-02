package com.learn.app.perpustakaan.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learn.app.perpustakaan.model.Buku;

public interface BukuDao extends PagingAndSortingRepository<Buku, String>{

	
}
