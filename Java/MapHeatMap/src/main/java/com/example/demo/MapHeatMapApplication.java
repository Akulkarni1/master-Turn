package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.WKTReader;

@SpringBootApplication
public class MapHeatMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapHeatMapApplication.class, args);
	}
	@Bean
	@Autowired
    public CommandLineRunner commandLineRunner(AreaRepository areaRepository, AreaHeatMapRepository areaHeatMapRepo,PointRepository pointRepository, PointHeatMapRepository pointHeatMapRepo) {
        return (args) -> {
            CreateArea area = new CreateArea();
            HashMap<UUID,GeomType> table =new HashMap<UUID, GeomType>();
            table=area.createArea();
            int i =0;//will be adding 10 area feature elements in the table for now.
           for(Map.Entry entry2 : table.entrySet()) {
               i++;
               GeomType e =(GeomType)entry2.getValue();
               
               areaRepository.save(new Area(i,(UUID)entry2.getKey(),e.getGeometry(),e.getType()));
           }
           
           //need to read the feature via stream and get the geom into the value for the comparision.
           //currently creating single area geom and comparing the geom below with the featureID.
           
           double x = 1;
           double y = 1;
           double w = 2;
           double h = 10; 
           GeometryFactory gf=new GeometryFactory();
           //Geometry.getFactory();
           Coordinate[] coordinates=new Coordinate[5];
           coordinates[0]=new Coordinate(x,y);
           coordinates[1]=new Coordinate(x + w,y);
           coordinates[2]=new Coordinate(x + w,y + h);
           coordinates[3]=new Coordinate(x,y + h);
           coordinates[4]=new Coordinate(x,y);
           LinearRing lr=gf.createLinearRing(coordinates);
           Polygon polygon=gf.createPolygon(lr,new LinearRing[]{});
           Geometry geom_polygon = polygon.convexHull();
           
          UUID featureId_heatMap=UUID.fromString( "00004245-3200-3c00-0000-00005968978a");
          List<Area> search = null;
          try {
                  search = areaRepository.findByFeatureId(featureId_heatMap);
                  SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy");
                  String dateInString2 = "31-08-2016";
                  System.out.println(search);
                  Date date2 = sdf2.parse(dateInString2);
                  if(!search.get(0).getGeometry().equals( geom_polygon)) {
                      areaHeatMapRepo.save(new AreaHeatMap(1,featureId_heatMap, geom_polygon,date2));
                  }

                  if(search==null) {
                      areaHeatMapRepo.save(new AreaHeatMap(1,featureId_heatMap, geom_polygon,date2));
                  }
                  
          }
          catch(NullPointerException ne) {
              System.out.println(ne);
                  
          }
          
          //Below is code of checking Geom.
          
          HashMap<UUID,GeomType> pointTable =new HashMap<UUID, GeomType>();
          pointTable = area.createPointArea();
          int j =0;//will be adding 10 area feature elements in the table for now.
          for(Map.Entry entry2 : table.entrySet()) {
              i++;
              GeomType e =(GeomType)entry2.getValue();
              
              pointRepository.save(new Point(i,(UUID)entry2.getKey(),e.getGeometry(),e.getType()));
          }
          
          //Creating point for now to compare the existing geom.
          WKTReader reader2 = new WKTReader();
		  
		  Geometry geom =reader2.read("POINT(-110 23)");
          UUID featureIdHeatMapPoint=UUID.fromString( "00004245-3200-3c00-0000-00005968978a");
          List<Area> searchPoint = null;
          try {
                  searchPoint = pointRepository.findByFeatureId(featureIdHeatMapPoint);
                  SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy");
                  String dateInString2 = "31-08-2016";
                  System.out.println(searchPoint);
                  Date date2 = sdf2.parse(dateInString2);
                  if(!searchPoint.get(0).getGeometry().equals( geom)) {
                      pointHeatMapRepo.save(new PointHeatMap(1,featureIdHeatMapPoint, geom,date2));
                  }

                  if(search==null) {
                      pointHeatMapRepo.save(new PointHeatMap(1,featureIdHeatMapPoint, geom,date2));
                  }
                  
          }
          catch(NullPointerException ne) {
              System.out.println(ne);
                  
          }
          
          
        };
	}
}           