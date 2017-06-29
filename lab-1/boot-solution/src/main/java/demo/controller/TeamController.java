package demo.controller;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Domain;
import demo.domain.Team;
import demo.repository.DomainRepository;
import demo.repository.TeamRepository;

@RestController
public class TeamController {

	@Autowired TeamRepository teamRepository;
	@Autowired DomainRepository domainRepository;
	
	//Added for Solr Client 
	
	@Autowired SolrClient solrClient;
	
	@RequestMapping("/solrFind/{id}")
	public String findRecord(@PathVariable String id) throws SolrServerException, IOException {
		return solrClient.getById(id).toString();
	}
	
	@RequestMapping("/solrdelete/{id}")
	public int deleteRecord(@PathVariable String id) throws SolrServerException, IOException
	{
		UpdateResponse up= solrClient.deleteById(id);
		    solrClient.commit();
		    return up.getStatus();
	}
	@RequestMapping("/teams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}
	
	@RequestMapping("/teams/{id}")
	public Team getTeam(@PathVariable Long id){
		return teamRepository.findOne(id);
	}
	
	@RequestMapping("/domains")
	public Iterable<Domain> getMongoList(){
		return domainRepository.findAll();
	}
	@RequestMapping("/domains/{domain}/{displayAds}")
	public String update(@PathVariable("domain")String domain,@PathVariable("displayAds")boolean displayAds){
		if (domainRepository.updateDomain(domain, displayAds) == 0)
			return "not updated";
		else
			return "successfully updated";
	}
	
	//for rest client we need to input the header as Content-Type: application/json
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value="/domains/insert" ,consumes ="application/json")
	public  ResponseEntity<?> insertDomain(@RequestBody Domain domain)
	{
		String response=null;
		
		if( domainRepository.insertDomain(domain)==1)
			response="successfully inserted for domain :"+domain.getDomain();
		else
			response="Already id existed so it wont be inserted for domain :"+domain.getDomain();
		 return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
	}
	
}
