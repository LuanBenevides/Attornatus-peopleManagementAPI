package br.com.attornatus.peopleManagement.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "adresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "public_place", nullable = false, length = 80)
	private String publicPlace;
	
	@Column(name = "zip_code", nullable = false, length = 9)
	private String zipCode;
	
	@Column(name = "residence_number",nullable = false)
	private int number;
	
	@Column(nullable = false, length = 60)
	private String city;
	
	@JoinColumn
	private Long peopleId;
	
	public Address() {}
	
	private Address (Long id, String publicPlace, String zipCode, int number, String city, Long peopleId) {
		this.id = id;
		this.publicPlace = publicPlace;
		this.zipCode = zipCode;
		this.number = number;
		this.city = city;
		this.peopleId = peopleId;
	}
	public Long getId() {
		return id;
	}
	public String getPublicPlace() {
		return publicPlace;
	}
	public String getZipCode() {
		return zipCode;
	}
	public int getNumber() {
		return number;
	}
	public String getCity() {
		return city;
	}
	public Long getPeopleId() {
		return peopleId;
	}
	
	//Design Pattern Builder
	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static final class Builder {
		
		private Long id;
		
		private String publicPlace;
		
		private String zipCode;
		
		private int number;
		
		private String city;
		
		private Long peopleId;
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder publicPlace(String publicPlace) {
			this.publicPlace = publicPlace;
			return this;
		}
		
		public Builder zipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}
		
		public Builder number(int number) {
			this.number = number;
			return this;
		}
		
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		
		public Builder peopleId(Long peopleId) {
			this.peopleId = peopleId;
			return this;
		}
		
		public Address build() { return new Address(id, publicPlace, zipCode, number, city, peopleId); }
	}
}
