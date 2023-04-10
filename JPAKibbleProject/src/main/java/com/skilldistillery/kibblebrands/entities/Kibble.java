package com.skilldistillery.kibblebrands.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
@Entity
public class Kibble {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String name;
	
	@Column(name = "kibble_url")
	private String kibbleUrl;
	
	@Column(name = "date_created")
	private LocalDate createDate;
	
	private String result;
	
	private String protein;
	
	public Kibble() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kibble other = (Kibble) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Kibble [id=" + id + ", name=" + name + "]";
	}

	public String getKibbleUrl() {
		return kibbleUrl;
	}

	public void setKibbleUrl(String kibbleUrl) {
		this.kibbleUrl = kibbleUrl;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}


}
