package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.enums.DeliveryStatus;

@Entity
@Table(name = "tb_deliver")
public class Deliver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uri;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	private DeliveryStatus status;
	private String feedback;
	private Integer correctCount;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "user_id"),@JoinColumn(name = "offer_id")})
	private Enrollment enrollment;
	
	@ManyToOne
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;
	
	public Lesson getLesson() {
		return lesson;
	}

	public Deliver() {
	}

	public Deliver(Long id, String uri, Instant moment, DeliveryStatus status, String feedback, Integer conectCount) {
		super();
		this.id = id;
		this.uri = uri;
		this.moment = moment;
		this.status = status;
		this.feedback = feedback;
		this.correctCount = conectCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getConectCount() {
		return correctCount;
	}

	public void setConectCount(Integer conectCount) {
		this.correctCount = conectCount;
	}

	public Enrollment getEnrollment() {
		return enrollment;
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
		Deliver other = (Deliver) obj;
		return Objects.equals(id, other.id);
	}
}
