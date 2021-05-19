package restTestpackage;
import pages.Constants;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
//import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
//import static org.junit.Assert.assertThat;

import java.util.List;

public class restTest {
	
	@Test
	public void validateStatusCode() {
	Response res=given()	
		.baseUri(Constants.BASEURL)
	.when().
		get(Constants.basepath)
	.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK").extract().response();
	}
	
	@Test
	public void validateHeaderType() {
	ValidatableResponse res=given()	
		.baseUri(Constants.BASEURL)
	.when().
		get(Constants.basepath)
	.then()
		.assertThat().header("Content-Type", "application/json; charset=utf-8");



	}
	
	@Test
	public void validateUserId() {
		Response res=given()	
			.baseUri(Constants.BASEURL)
		.when().
			get(Constants.basepath)
		.then()
			.extract().response();
		

		JsonPath path=res.jsonPath();
				
		Assert.assertEquals(path.getInt("data[5].user_id"),14);
		int userid = path.get("data.find {i-> i.title=='Conitor tergiversatio non totus crustulum barba demulceo ocer ea attonbitus timidus infit auditor nesciunt.'}.user_id");
	
		System.out.println(userid);
		Assert.assertEquals(userid, 15);		
				
		


		}
	
	@Test
	public void validateTitle() {
		Response res=given()	
			.baseUri(Constants.BASEURL)
		.when().
			get(Constants.basepath)
		.then()
			.extract().response();
		

		JsonPath path=res.jsonPath();
				
		Assert.assertEquals(path.getString("data[6].title"),"Conitor tergiversatio non totus crustulum barba demulceo ocer ea attonbitus timidus infit auditor nesciunt.");
		String title = path.get("data.find {i-> i.user_id==17}.title");
	
		System.out.println(title);
		Assert.assertEquals(title, "Concedo sumo calco molestias rerum crur ulterius nostrum claro supellex succurro aeger expedita contabesco debeo.");		
				
		


		}
}

