package com.example.demo;
import java.util.Date;
import com.vividsolutions.jts.geom.Geometry;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "areas")
public class Area {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name="ID")
       private long id;
       @Column(name="featureId")
      String featureId;
       @Column(name = "type") 
       String type; 
       Map<String, Object> attributes;
       
        @Column(name = "geom")
       Geometry geometry;
        
        protected Area() {}

        public Area(String newValFeature, Geometry newValGeom, String newValType) {
            this.featureId = newValFeature;
            this.geometry = newValGeom;
            this.type = newValType;
            
        }

        @Override
        public String toString() {
            return String.format(
                    "Area[id=%d, FeatureID ='%s', type='%s',Geom = '%s',Attributes = '%s']",
                    id, featureId, type,geometry,attributes);
        }

        
        public long getId() {
            return id;
        }

        
        public void setId(long id) {
            this.id = id;
        }

        
        public String getFeatureId() {
            return featureId;
        }

        
        public void setFeatureId(String featureId) {
            this.featureId = featureId;
        }

        
        public String getType() {
            return type;
        }

        
        public void setType(String type) {
            this.type = type;
        }

        
        public Map<String, Object> getAttributes() {
            return attributes;
        }

        
        public void setAttributes(Map<String, Object> attributes) {
            this.attributes = attributes;
        }

        
        public Geometry getGeometry() {
            return geometry;
        }

        
        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }
}
