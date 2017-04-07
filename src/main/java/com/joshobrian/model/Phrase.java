package com.joshobrian.model;

/**
 * Created by josh on 4/6/17.
 */
public class Phrase {
	private Integer id;
	private Integer categoryId;
	private String categoryType;
	private String phrase;

	public Phrase(Integer id, Integer categoryId, String categoryType, String phrase) {
		this.id = id;
		this.categoryId = categoryId;
		this.categoryType = categoryType;
		this.phrase = phrase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
}
