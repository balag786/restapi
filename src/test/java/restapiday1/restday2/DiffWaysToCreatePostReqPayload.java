package restapiday1.restday2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
public class DiffWaysToCreatePostReqPayload {
	
	int id;
	//post request using hashmap	
	@Test
	public void testPostUsingHashMap()
	{
		HashMap data=new HashMap();
		data.put("name","myname");
		data.put("grade",12);		
		String courseArr[] = {"Selenium","Java"};
		data.put("courses", courseArr);
		
		given()
		  .contentType("application/json")
		  .body(data)
		.when()
		  .post("http://localhost:3000/employee");
		  //.jsonPath().getInt("id");
		
/*	.then()
	 .statusCode(201)
		 .body("name",equalTo("myname"))
		 .body("grade",equalTo("2"))
		 .body("maths",equalTo("70"))
		 .body("physics",equalTo("60"))
		 .body("chemistry",equalTo("50"))
		 .body("courses[0]",equalTo("Selenium"))
		 .body("courses[1]",equalTo("Java"))
	 .header("Content-type","applications/json")
	 .log().all();*/
		
	}
  //deleting student record
	//@Test(priority=2)
	public void testDelete()
	{
		given()
		.when()
		    .delete("http://localhost:3000/employee/id")
		.then()
		   .statusCode(200);
	}
}
