package com.skilldistillery.kibblebrands.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="logo_url")
	private String imageLogo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "brand")
	private List<Kibble> kibbles;

	public Brand() {
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

	public String getImageLogo() {
		return imageLogo;
	}

	public void setImageLogo(String imageLogo) {
		this.imageLogo = imageLogo;
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
		Brand other = (Brand) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", imageLogo=" + imageLogo + "]";
	}

	public List<Kibble> getKibbles() {
		return kibbles;
	}

	public void setKibbles(List<Kibble> kibbles) {
		this.kibbles = kibbles;
	}
}
