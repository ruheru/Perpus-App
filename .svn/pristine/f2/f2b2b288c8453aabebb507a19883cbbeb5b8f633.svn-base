package com.learn.app.perpustakaan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Buku {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	
	@Column
	@NotEmpty @NotNull
	private String nama;
	
	@Column
	private Integer tahunTerbit;
	
	@ManyToOne
	@JoinColumn(name="id_penerbit", referencedColumnName = "id")
	private Penerbit penerbit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getTahunTerbit() {
		return tahunTerbit;
	}

	public void setTahunTerbit(Integer tahunTerbit) {
		this.tahunTerbit = tahunTerbit;
	}

	public Penerbit getPenerbit() {
		return penerbit;
	}

	public void setPenerbit(Penerbit penerbit) {
		this.penerbit = penerbit;
	}

}
