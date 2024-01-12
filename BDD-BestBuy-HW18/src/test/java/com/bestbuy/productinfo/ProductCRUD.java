package com.bestbuy.productinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBaseBestBuyApi;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductCRUD extends TestBaseBestBuyApi {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    int ID;
    static String name = "Tablet" + TestUtils.getRandomValue();
    static String type = "canon" + TestUtils.getRandomValue();
    static Integer price = 1200 + TestUtils.getRandomNumber();
    static Integer shipping = 0 + TestUtils.getRandomNumber();
    static String upc = "string" + TestUtils.getRandomValue();
    static String description = "string" + TestUtils.getRandomValue();
    static String manufacturer = "string" + TestUtils.getRandomValue();
    static String model = "string" + TestUtils.getRandomValue();
    static String url = "string" + TestUtils.getRandomValue();
    static String image = "string" + TestUtils.getRandomValue();

    @Test
    public void getAllPructs(){
        response = given().log().all()
                .when()
                .get();
        response.then().log().all().statusCode(200);
    }
    @Test
    public void createproduct(){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);
     given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(productPojo)
                .post()
       .then().log().all().statusCode(201);

    }
    @Title("Update the user and verify the updated information")
    @Test
    public void test004() {
        name = name + "updated";
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);

        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",ID )
                .body(productPojo)
                .when()
                .patch(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then().log().all().statusCode(200);}

    @Title("Delete the product and verify if the student is deleted")
    @Test
    public void test005() {
        SerenityRest.given()
                .pathParam("id", ID)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then()
                .statusCode(200);
        given().log().all()
                .pathParam("id",ID)
                .when()
                .get(EndPoints.DELETE_PRODUCT_BY_ID)
                .then().log().all();

}}