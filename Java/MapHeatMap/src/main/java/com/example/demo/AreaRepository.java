package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vividsolutions.jts.geom.Geometry;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface AreaRepository extends CrudRepository<Area, Long>  {

    
    ArrayList<Area> findByFeatureId(String featureId);

    List<Area> findByGeometry(Geometry geometry);
}
