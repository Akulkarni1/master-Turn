package com.example.demo;
import java.util.Date;
import com.vividsolutions.jts.geom.Geometry;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "point")
public class Point {

       @Id  
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name="ID")
       private long id;
       @Column(name="featureId")
      UUID featureId;
       @Column(name = "type") 
       String type; 
       //Map<String, Object> attributes;
       
        @Column(name = "geom")
        Geometry geometry;
        
        protected Point() {}

        public Point(int id,UUID newValFeature, Geometry newValGeom, String newValType) {
            this.id = id;
            this.featureId = newValFeature;
            this.geometry = newValGeom;
            this.type = newValType;
            
        }

        @Override
        public String toString() {
            return String.format(
                    "Point[id=%d, FeatureID ='%s', type='%s',Geom = '%s']",
                    id, featureId, type,geometry);
        }

        
        public long getId() {
            return id;
        }

        
        public void setId(long id) {
            this.id = id;
        }

        
        public UUID getFeatureId() {
            return featureId;
        }

        
        public void setFeatureId(UUID featureId) {
            this.featureId = featureId;
        }

        
        public String getType() {
            return type;
        }

        
        public void setType(String type) {
            this.type = type;
        }


        
        
        public Geometry getGeometry() {
            return geometry;
        }

        
        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }
}
