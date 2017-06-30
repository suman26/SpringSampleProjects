package com.example.Springsolr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSolrApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringSolrApplication.class, args);
	}
 
	@Autowired
	ProductRepository repository;
	
//	@Bean
//    public SolrClient solrClient() {
//        return new HttpSolrClient("http://localhost:8983/solr/");
//    }
// 
//    @Bean
//    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
//        return new SolrTemplate(client);
//    }
//	
	@Override
	public void run(String... arg0) throws Exception {
		
		this.repository.deleteAll();

		// insert some products
		this.repository.save(new Product("2", "Sony Ericssion"));
		this.repository.save(new Product("1", "Samsumg"));
		this.repository.save(new Product("3", "Philps"));

		// fetch all
		System.out.println("Products found by findAll():");
		System.out.println("----------------------------");
		for (Product product : this.repository.findAll()) {
			System.out.println(product);
		}
		System.out.println();

		// fetch a single product
		System.out.println("Products found with findByNameStartingWith('S'):");
		System.out.println("--------------------------------");
		for (Product product : this.repository.findByNameStartingWith("S")) {
			System.out.println(product);
		}
		System.out.println("deletin record from solr ");
		System.out.println("------------------------------");
		this.repository.delete("1");
		System.out.println();
	}
}
