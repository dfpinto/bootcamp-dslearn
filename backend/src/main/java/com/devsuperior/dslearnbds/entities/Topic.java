package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_topic")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String body;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;

	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	@OneToOne
	@JoinColumn(name = "answer_id")
	private Reply answer;

	@ManyToMany
	@JoinTable(name = "tb_topic_likes",
			joinColumns = @JoinColumn(name = "topic_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private Set<User> likes = new HashSet<>();
	
	@OneToMany(mappedBy = "topic")
	private Set<Reply> replies = new HashSet<>();
	
	public Topic() {
	}

	public Topic(Long id, String title, String body, Instant moment) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.moment = moment;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public Offer getOffer() {
		return offer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Topic other = (Topic) obj;
		return Objects.equals(id, other.id);
	}
}
