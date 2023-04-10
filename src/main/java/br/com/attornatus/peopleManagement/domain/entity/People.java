package br.com.attornatus.peopleManagement.domain.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peoples")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "people_name", nullable = false, length = 60)
	private String name;
	
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@Column(name = "main_address_id")
	private Long mainAddressId = null;
	
	public People() {}
	
	private People(Long id, String name, Date birthDate, Long mainAddressId) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.mainAddressId = mainAddressId;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public Long getMainAddressId() {
		return mainAddressId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birthDate, id, mainAddressId, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(id, other.id)
				&& Objects.equals(mainAddressId, other.mainAddressId) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "People [id=" + id 
				+ ", name=" + name 
				+ ", birthDate=" + birthDate 
				+ ", mainAddressId=" + mainAddressId
				+ "]";
	}
	
	//Design Pattern Builder
	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static final class Builder {
		
		private Long id;
		
		private String name;
		
		private Date birthDate;
		
		private Long mainAddressId;
		
		private Builder() {}
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder birthDate(Date birthDate) {
			this.birthDate = birthDate;
			return this;
		}
		
		public Builder mainAddressId(Long mainAddressId) {
			this.mainAddressId = mainAddressId;
			return this;
		}
		
		public People build() { return new People(id, name, birthDate, mainAddressId); }
	}
}
