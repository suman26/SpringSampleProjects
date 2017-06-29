package demo.repository;

import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import demo.domain.Domain;

public class DomainRepositoryImpl implements DomainRepositoryCustom{

	 @Autowired
	    MongoTemplate mongoTemplate;

	    @Override
	    public int updateDomain(String domain, boolean displayAds) {

	        Query query = new Query(Criteria.where("domain").is(domain));
	        Update update = new Update();
	        update.set("displayAds", displayAds);

	        WriteResult result = mongoTemplate.updateFirst(query, update, Domain.class);

	        if(result!=null)
	            return result.getN();
	        else
	            return 0;

	    }

		@Override
		public int insertDomain(Domain domain) {
			
			if(domain!=null)
			{
				Query query = new Query();
				query.addCriteria(Criteria.where("_id").is(domain.getId()));
				if(mongoTemplate.findOne(query, Domain.class)==null)
				{ mongoTemplate.insert(domain);
				return 1;
				}
			}
			return 0;
		}

}
