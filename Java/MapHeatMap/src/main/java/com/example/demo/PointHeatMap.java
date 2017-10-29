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

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "pointheatmap")
public class PointHeatMap {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name="ID")
       private long id;
       
       @Column(name="feature_id")
      UUID featureId;
      
       @Temporal(TemporalType.TIMESTAMP)
       public Date date;
        @Column(name = "geom")
       Geometry geometry;
        public PointHeatMap() {}
        public PointHeatMap(int id,UUID newValFeature, Geometry newValGeom,Date date) {
            this.id = id;
            this.featureId = newValFeature;
            this.geometry = newValGeom;
            this.date =date;
            
        }

        @Override
        public String toString() {
            return String.format(
                    "Point[id=%d, FeatureID ='%s', type='%s',Geom = '%s',attributes = '%s',time ='%s']",
                    id, featureId, geometry,date);
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

        

        public Date getDate() {
            return date;
        }

        
        public void setDate(Date date) {
            this.date = date;
        }

        
        public Geometry getGeometry() {
            return geometry;
        }

        
        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }
}
