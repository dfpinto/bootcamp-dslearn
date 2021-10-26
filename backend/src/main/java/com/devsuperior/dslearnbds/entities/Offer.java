package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_offer")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String edition;
	private Instant starMoment;
	private Instant endMoment;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@OneToMany(mappedBy = "offer")
	private Set<Resource> resources = new HashSet<>();
	
	
	public Offer() {
	}

	public Offer(Long id, String edition, Instant starMoment, Instant endMoment) {
		super();
		this.id = id;
		this.edition = edition;
		this.starMoment = starMoment;
		this.endMoment = endMoment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Instant getStarMoment() {
		return starMoment;
	}

	public void setStarMoment(Instant starMoment) {
		this.starMoment = starMoment;
	}

	public Instant getEndMoment() {
		return endMoment;
	}

	public void setEndMoment(Instant endMoment) {
		this.endMoment = endMoment;
	}

	public Course getCourse() {
		return course;
	}
}
