package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


public interface PointHeatMapRepository extends CrudRepository<PointHeatMap, Long>  {

    
    List<PointHeatMap> findByFeatureId(String featureId);
}
