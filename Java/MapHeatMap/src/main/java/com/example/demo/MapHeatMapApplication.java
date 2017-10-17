package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.WKTReader;

@SpringBootApplication
public class MapHeatMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapHeatMapApplication.class, args);
	}
	@Bean
	@Autowired
    public CommandLineRunner commandLineRunner(AreaRepository repository, AreaHeatMapRepository re) {
        return (args) -> {
           // repository.save()

            WKTReader reader2 = new WKTReader();
            
            //GeometryFactory geometryFactory = GeometryFactory.createPointFromInternalCoord(coord, exemplar)
           // Geometry geom2 =reader2.read("0103000020110F00000300000045000000474423D1CEDA1E416DE60B78987C59412EA1CFE149DC1E41949C61D0C97C594126C513AF84DE1E41009A2673FB7C59414054560ECEDF1E41966741CD1D7D5941F38556691AE11E41F1BCB02A3A7D5941576EDD3B32E11E411707DA8C3C7D594127948FE973E11E417D5A3720437D5941D27FAEC97DE21E41257D48BB5D7D5941DD1A81F7BEE31E41DDD2CA067C7D594139F4021B1AE51E4129157AF49C7D59412A7E6316A4E61E410D8457F7BC7D59413A9D907960E81E414B06B35FE47D59412B9D4E5873E91E410BB1AD16FF7D594176D8CA8EB5E91E4105996B71007E59414373386EDCE91E4153B85CB6FF7D59411BAD7176F9E91E4171C8A827FD7D5941533108DADBE91E41BCBA9534FA7D59418262AFCC19E91E4183F61BC6E07D59417EF031E30BEB1E417DD383E1D77D594189CC978923EF1E412F7A66E8CE7D59414BCCCC8FE2EF1E41A56E9E42BD7D59417D5F268194EF1E41C12894D59A7D5941D6920BE493EE1E413C1C7D3F817D59414F34F977C6EA1E4196C810E0497D5941EF5E0AA4F9E91E41FBFB004C407D594182B21ED4F9E81E41A85064BA3A7D59418439D05286E81E41140335BC2E7D59417029B32786E71E4181029A8E1F7D59412A9BD64B79E61E4128F62896137D5941218B48EC52E51E413E78E09E077D5941079B8F9412E51E416D0BA16AFC7C5941907E8EC885E41E413AA4A4D5F67C5941923CCF68ABE41E4110CD7B9BE37C594143F3EF3450E51E418E5C7C9ABD7C59417838B8D642E61E41F86C79D7BC7C59416568F21D9CE61E41C88BD1D2B87C5941FD72AAFF0EE71E411E3D06CDB47C594185ED59465BE71E41AAC79A61AA7C59419A948D2F5BE71E4198DF0EC7A87C5941407DDFFBB3E61E41B20783C68C7C59416BC27E7DF3E51E4142AC55FC777C594183B240B7F4DE1E41EB758F9C4A7C59412994F5949ADF1E4107FEA060437C5941126B452E40E01E41848C07BE357C5941A38C9992B2E01E419839D0B4257C5941E67D3B53FDE11E4172099139FF7B5941B5D6832723E41E41C7494DF2077C5941E064DCC055E71E41CF7D3DA41C7C5941586CA9F763E61E41C25CDA4E367C59414D50E3FC31E81E41EB1DAE496A7C594109CC0A7862E91E4187B5A261317C5941EC09B345D4EA1E41A0E8AAE81E7C59413CBDB7C1ACEC1E415F2A1DD4167C5941EE35AC7D05EE1E41AF2FA55E107C5941E6E3F812DEEE1E41B5551552007C594107344926FEF11E41185E057AEA7B594174F2CD793FED1E4146D6EBF9C47B59411D74369FB3E21E415681EAEE757B5941EDAE828D9AE21E4120BAD978787B5941F084B4B776E11E41C3B630A89E7B59412F64792C54E01E416BADE663CF7B594139C822E422DF1E41664B75AAFB7B5941DCD08BD94EDE1E41AF33B6111D7C5941D661CBE478DD1E41DEFD2AC3367C594138C2B1DC73DD1E413EE0C772377C59412F34EDA494DC1E41959D42D6557C5941865A11BC1EDC1E41C42F6D476C7C59411DF364B5BDDB1E41CBDA92C07E7C5941474423D1CEDA1E416DE60B78987C594106000000244A3420DDDD1E41F1BC006C727C5941F9192FDF42DE1E41F60CFF64667C5941A7D4E2FA75DF1E41ED8AA4C2707C5941C8D4C306B6E21E41BA39F611977C594192084AE636E21E41B3CAADE8A77C5941244A3420DDDD1E41F1BC006C727C594105000000FAD354A1B8E91E412DC38D5DDE7B5941711E1D3E1EEA1E41CF50A755CE7B594177DE884051EC1E41C6BF4F43E27B594121AB098978EB1E41006B30E9EF7B5941FAD354A1B8E91E412DC38D5DDE7B5941");
           /* Geometry geom2 = reader2.read("POINT(-105 40)");
            UUID featureId=UUID.fromString( "00004245-3200-3c00-0000-00005968978a");
            repository.save(new Area(1,featureId, geom2,"Forest"));*/
           for(Area area: repository.findAll()) {
               System.out.println(area.toString());
           } 
           WKTReader reader = new WKTReader();
           
           
          Geometry geom =reader.read("POINT(-110 23)");
          UUID featureId=UUID.fromString( "00004245-3200-3c00-0000-00005968978a");
          List<Area> search = null;
          try {
                  search = repository.findByFeatureId(featureId);
                  SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy");
                  String dateInString2 = "31-08-2016";
                  System.out.println(search);
                  Date date2 = sdf2.parse(dateInString2);
                  if(search.get(0).getGeometry()!= geom) {
                      re.save(new AreaHeatMap(1,featureId, geom,date2));
                  }

                  if(search==null) {
                      re.save(new AreaHeatMap(1,featureId, geom,date2));
                  }
                  
          }
          catch(NullPointerException ne) {
              System.out.println(ne);
                  
          }
          // Area e = new Area("00004245-3200-3c00-0000-000059689789",geom,"Forest");
          /* try {
               ArrayList<Area> search =null;
               UUID featureId2=UUID.fromString("00004245-3200-3c00-0000-000059689789");
               search = repository.findByFeatureId(featureId2);
               SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy");
               String dateInString2 = "31-08-2016";
               Date date2 = sdf2.parse(dateInString2);
               if(search.get(0).getGeometry()!=geom) {
                   
                   re.save(new AreaHeatMap(1,featureId2, geom,date2));
               }
               if(search==null) {
                   re.save(new AreaHeatMap(1,featureId2, geom,date2));
               }
           }
           catch(NullPointerException ne) {
               System.out.println(ne);
                   
           }*/
            
        };
	}
}            // save a couple of customers
      /*  repository.save(new Employee(Long.parseLong("2312"), "Amit K", 130000, "E"));
            repository.save(new Employee(Long.parseLong("2313"), "Adi R", 160000, "D"));
            repository.save(new Employee(Long.parseLong("2314"), "Shlomi V", 140000, "G"));
            repository.save(new Employee(Long.parseLong("2315"), "Marina V", 145000, "M"));
            
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Employee emp : repository.findAll()) {
                log.info(emp.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Employee em = null; 
            
            try{
                 em = repository.findOne(2315L);
                 //EmployeeHeat e ;
                 //log.info("em has the value "+em.toString());
                 if(em==null) {
                    
                     
                //repository.save(new Employee(Long.parseLong("2315"), "Itsik I", 150000, "M"));
                 re.save(new EmployeeHeat(Long.parseLong("2315"), "Itsik I", 150000, "M",true));
                    log.info("Customer found with findOne(2315L):");
                    log.info("--------------------------------");
                    //log.info(em.toString());
                    for (EmployeeHeat bauer : re.findByName("Itsik I")) {
                        log.info(bauer.toString());
                    }
                    log.info("");
                 }
                
                 
            }
            catch(NullPointerException ne) {
                System.out.println(ne);
                    
            }
            
            
            // fetch all customers
                        log.info("Customers found with findAll():");
                        log.info("-------------------------------");
                        for (Employee employee1 : repository.findAll()) {
                            log.info(employee1.toString());
                        }
                        log.info("");
            
            // fetch customers by last name
            log.info("Customer found with findByLastName('Adi'):");
            log.info("--------------------------------------------");
            for (Employee bauer : repository.findByName("Adi R")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
            
    }

}*/
