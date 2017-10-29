package com.example.demo;

import java.util.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

class GeomType{
    Geometry geometry;
    
    public Geometry getGeometry() {
        return geometry;
    }
    
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    String type;
    
    GeomType(String newVal){
        type = newVal;
        geometry = createAreaGeom();
    }
    GeomType(){
        type = "Point";
        geometry = createPointGeom();
    }
    
    public Geometry createPointGeom() {
        double lat = (Math.random()*180.0)-90;
        double log = (Math.random() * 360.0) - 180.0;
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(new Coordinate(log, lat));
        return point;
        

    }
      public Geometry createAreaGeom() {
            int max = 4;
            int min =1;
            double x = ThreadLocalRandom.current().nextDouble(min, max);
            double y = ThreadLocalRandom.current().nextDouble(min, max);
            double w = ThreadLocalRandom.current().nextDouble(min, max);
            double h = ThreadLocalRandom.current().nextDouble(min, max);
            GeometryFactory gf=new GeometryFactory();
            
            Coordinate[] coordinates=new Coordinate[5];
            coordinates[0]=new Coordinate(x,y);
            coordinates[1]=new Coordinate(x + w,y);
            coordinates[2]=new Coordinate(x + w,y + h);
            coordinates[3]=new Coordinate(x,y + h);
            coordinates[4]=new Coordinate(x,y);
            LinearRing lr=gf.createLinearRing(coordinates);
            Polygon polygon=gf.createPolygon(lr,new LinearRing[]{});
            Geometry geom_polygon = polygon.convexHull();
            
            return geom_polygon;
        }
      public String toString() {
          return " "+type+" "+geometry;
      }
      
}
class CreateArea{
    public HashMap<UUID,GeomType> createArea() {
        HashMap<Integer,HashMap<UUID,GeomType>> table =new HashMap <Integer, HashMap<UUID, GeomType>>();
        HashMap<UUID,GeomType> uuidtable = new HashMap<UUID,GeomType>();
        UUID uuid = UUID.fromString( "00004245-3200-3c00-0000-00005968978a");
        
        for(int i =0;i<10;i++) {
            uuidtable.put(uuid.randomUUID(), new GeomType("Forest"));
            table.put(i, uuidtable);
        }
            
        return uuidtable;         
        }
        
    public HashMap<UUID,GeomType> createPointArea(){
        HashMap<Integer,HashMap<UUID,GeomType>> table =new HashMap <Integer, HashMap<UUID, GeomType>>();
        HashMap<UUID,GeomType> uuidtable = new HashMap<UUID,GeomType>();
        UUID uuid = UUID.fromString( "00004245-3200-3c00-0000-00005968978a");
        
        for(int i =0;i<10;i++) {
            uuidtable.put(uuid.randomUUID(), new GeomType());//currently point is create with label as point.
            table.put(i, uuidtable);
        }
            
        return uuidtable;
    }
    
    }
    
