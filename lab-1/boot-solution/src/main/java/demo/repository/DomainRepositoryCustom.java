package demo.repository;

import demo.domain.Domain;

public interface DomainRepositoryCustom {

    int updateDomain(String domain, boolean displayAds);
    int insertDomain(Domain domain);

}