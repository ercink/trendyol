package com.trend.trendyol.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;

	@ManyToOne
	private Category parent;

	@OneToMany(mappedBy = "parent")
    private Set<Category> children;

	// private Integer parentCategoryId;

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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Set<Category> getChildren() {
		return children;
	}

	public void setChildren(Set<Category> children) {
		this.children = children;
	}

	
	/*
	 * public Integer getParentCategoryId() { return parentCategoryId; }
	 * 
	 * public void setParentCategoryId(Integer parentCategoryId) {
	 * this.parentCategoryId = parentCategoryId; }
	 */

}
