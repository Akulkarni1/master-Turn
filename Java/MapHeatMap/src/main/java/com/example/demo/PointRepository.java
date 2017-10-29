package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.vividsolutions.jts.geom.Geometry;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface PointRepository extends CrudRepository<Point, Long>  {

    
    List<Area> findByFeatureId(UUID featureId);

    List<Area> findByGeometry(Geometry geometry);
}
