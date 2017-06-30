package com.example.Springsolr;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.geo.Point;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "product")
public class Product {

	@Id
	@Field
	private String id;

	@Field
	private String name;

	

	public Product() {
	}

	public Product(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

	


}