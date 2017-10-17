package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


public interface AreaHeatMapRepository extends CrudRepository<AreaHeatMap, Long>  {

    
    List<AreaHeatMap> findByFeatureId(String featureId);
}
