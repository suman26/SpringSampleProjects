package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import demo.domain.Domain;
import demo.domain.Player;
import demo.domain.Team;
import demo.repository.DomainRepository;
import demo.repository.TeamRepository;

@SpringBootApplication
@EnableSolrRepositories
public class Application {

	@Autowired TeamRepository teamRepository;
	@Autowired DomainRepository domainRepository;
	

	@Bean
    public SolrClient solrClient() {
        return new HttpSolrClient("http://localhost:8983/solr/product");
    }
 
    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Set<Player> set = new HashSet<>();
		set.add(new Player("Big Easy", "Showman"));
		set.add(new Player("Buckets", "Guard"));
		set.add(new Player("Dizzy", "Guard"));
		
		list.add(new Team("Harlem", "Globetrotters", set));
		list.add(new Team("Washington","Generals",null));

		teamRepository.save(list);
//		List<Domain> mongoList = new ArrayList<>();
//		Domain d= new Domain(7L,"abhi.com",false);
//		mongoList.add(d);
//		domainRepository.save(mongoList);
//		System.out.println("saved List is:"+mongoList);
	}    
    
}
