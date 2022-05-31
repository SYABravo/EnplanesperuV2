package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cuantity_bed", nullable = false)
	private int cuantityBed;

	@Column(name = "price_room", nullable = false)
	private double priceRoom;

	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private ServiceTravel serviceTravel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCuantityBed() {
		return cuantityBed;
	}

	public void setCuantityBed(int cuantityBed) {
		this.cuantityBed = cuantityBed;
	}

	public double getPriceRoom() {
		return priceRoom;
	}

	public void setPriceRoom(double priceRoom) {
		this.priceRoom = priceRoom;
	}

	public ServiceTravel getServiceTravel() {
		return serviceTravel;
	}

	public void setServiceTravel(ServiceTravel serviceTravel) {
		this.serviceTravel = serviceTravel;
	}

}
