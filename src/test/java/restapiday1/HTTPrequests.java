package restapiday1;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


/*given()-prerequisites like content type,setcookies,authentication,add param,set headers info etc
 * 
when()-get,post,put ,delete
then()-validations status code,extract response,header,cookies*/
public class HTTPrequests {
	int id;
	@Test
	public void getUsers()
	{
		given()
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		  .statusCode(200)
		  .body("page",equalTo(2))
		  .log().all();
	}
	@Test
	public void createUser()
	{
		HashMap hm =new HashMap();// not used in real project
		hm.put("name","myname");
		hm.put("job","trainer");
		id=given()
			.contentType("application/json")
			.body(hm)
	         
		.when()
		      .post("https://reqres.in/api/users")
		       .jsonPath().getInt("id");
		      
		
//		.then()
//		       .statusCode(201)
//		       .log().all();
//		       
	}



}
