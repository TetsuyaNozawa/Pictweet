package com.example.business.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class Tweet {
	
	@ManyToOne
	@JoinColumn(updatable = false)
	private User user;
	
	@OneToMany(mappedBy = "tweet")
    private List<Comment> comments;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String image;
	
	private String text;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName()  {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {		
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text =text;
	}
	public User getuser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
