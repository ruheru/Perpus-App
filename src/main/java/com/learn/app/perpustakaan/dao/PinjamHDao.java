package com.learn.app.perpustakaan.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learn.app.perpustakaan.model.Pinjam;

public interface PinjamHDao extends PagingAndSortingRepository<Pinjam, String>{

}
