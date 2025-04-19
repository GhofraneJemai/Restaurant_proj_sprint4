package com.ghofrane.restaurants.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import jakarta.persistence.*;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;
    
    @NotNull
    @Size(min = 3, max = 30)
    private String nomRestaurant;
    
    @NotNull
    @Size(min = 5, max = 50)
    private String adresse;
    
    @ManyToOne
    private Type type; 
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
	private Date dateOuverture;
    @Min(0)
    @Max(5)
    private Double note;
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(String nomRestaurant, String adresse, Date dateOuverture, Double note) {
		super();
		this.nomRestaurant = nomRestaurant;
		this.adresse = adresse;
		this.dateOuverture = dateOuverture;
		this.note = note;
	}
	public Long getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(Long idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public String getNomRestaurant() {
		return nomRestaurant;
	}
	public void setNomRestaurant(String nomRestaurant) {
		this.nomRestaurant = nomRestaurant;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Restaurant [idRestaurant=" + idRestaurant + ", nomRestaurant=" + nomRestaurant + ", adresse=" + adresse
				+ ", dateOuverture=" + dateOuverture + ", note=" + note + "]";
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
    
    
}