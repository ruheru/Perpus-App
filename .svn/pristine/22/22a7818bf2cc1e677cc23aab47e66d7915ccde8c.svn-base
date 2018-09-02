package com.learn.app.perpustakaan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.app.perpustakaan.dao.PenerbitDao;
import com.learn.app.perpustakaan.model.Penerbit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class penerbittest {
	
	@Autowired
	PenerbitDao penerbitDao;
	
	@Test
	public void testInsert() {
		Penerbit pen = new Penerbit();
		pen.setCode("P001");
		pen.setNama("Penerbit Test 1");
		penerbitDao.save(pen);
	}

}
