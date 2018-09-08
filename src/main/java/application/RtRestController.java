package application;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RtRestController {

	// inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";
		
	@RequestMapping("/home")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "rtflowcheck";
	}
	
	@RequestMapping("/getAnalysedData")
	@ResponseBody
	public String getAnalysedData(Map<String, Object> model) {
		
		CloudantClient client = ClientBuilder.account("dce230af-1b29-4ee3-83c5-bac721d40d7b-bluemix")
                .username("dce230af-1b29-4ee3-83c5-bac721d40d7b-bluemix")
                .password("f9acafd2fc5b36c4aeb5203b8029eaa619154dbdf12c669a7d5f247a6a2b1ecd")
                .build();
		System.out.println("Server Version: " + client.serverVersion());
		// Delete a database we created previously.
		client.deleteDB("example_db");
		client.createDB("example_db");
		// Get a Database instance to interact with, but don't create it if it doesn't already exist
		Database db = client.database("example_db", false);
		System.out.println("$$$$$$$$$$$$"+db);
		// Get a List of all the databases this Cloudant account
		List<String> databases = client.getAllDbs();
		System.out.println("#######All my databases : ");
		for ( String db1 : databases ) {
			System.out.println(db1);
		}
		//Status 0,1,2,3,4
		DamOverview d1 = new DamOverview("1", "D1", "500", "200", "0");
		DamOverview d2 = new DamOverview("2", "D2", "4000", "3000", "1");
		DamOverview d3 = new DamOverview("3", "D3", "5000", "4990", "2");
		DamOverview d4 = new DamOverview("4", "D4", "2500", "2501", "3");
		
		db.save(d1);
		db.save(d2);
		db.save(d3);
		db.save(d4);
		
		DamOverview doc1 = db.find(DamOverview.class,"1");
		DamOverview doc2 = db.find(DamOverview.class,"2");
		DamOverview doc3 = db.find(DamOverview.class,"3");
		DamOverview doc4 = db.find(DamOverview.class,"4");
				
		List<DamOverview> damList = new ArrayList<DamOverview> ();
		
		damList.add(doc1);
		damList.add(doc2);
		damList.add(doc3);
		damList.add(doc4);
		

	    final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();

	    try {
			mapper.writeValue(out, damList);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    final byte[] data = out.toByteArray();
	    String jsonData = new String(data);
	    model.put("message", jsonData);
		return jsonData;
	}
}
