package com.bestbuy.cucumber.steps;

import com.bestbuy.model.StorePojo;
import com.bestbuy.productinfo.StoreSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class Storestepdefination {
    static int id;
    static String name = null;
    static ValidatableResponse response;
    private StorePojo.Services services;
    @Steps
    StoreSteps storeSteps;

    @When("^I create a new store by providing the information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" addresstwo \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\"$")
    public void iCreateANewStoreByProvidingTheInformationNameTypeAddressAddresstwoCityStateZipLatLngHours(String _name, String type, String address, String address2, String city, String state, String zip, int lat, int lng, String hours){
        name = TestUtils.getRandomValue() + _name;
        response = storeSteps.createStore(name, type, address,address2, city, state, zip, lat, lng, hours,services);
        id = response.extract().path("id");
        System.out.println(id);
    }

    @Then("^I verify that the store with name \"([^\"]*)\" is created$")
    public void iVerifyThatTheStoreWithNameIsCreated(String _name) {
        // Write code here that turns the phrase above into concrete actions
        response.statusCode(201);
        response = storeSteps.getStoreInfoById(id).statusCode(200);
        HashMap<String,Object> value = response.extract().path("");
        id = (int) value.get("id");
        Assert.assertThat(value,hasValue(name));
    }


    @And("^I update store by providing the information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" addresstwo \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\"$")
    public void iUpdateStoreByProvidingTheInformationNameTypeAddressAddressCityStateZipLatLngHours(String _name, String type, String address, String address2, String city, String state, String zip, int lat, int lng, String hours){
        name = name + "_Updated";
        response = storeSteps.updateStore(id,name, type, address,address2, city, state, zip, lat, lng, hours,services);
    }

    @And("^The store with name \"([^\"]*)\" is updated successfully$")
    public void theStoreWithNameIsUpdatedSuccessfully(String _name){
        response.statusCode(200);
        response =  storeSteps.getStoreInfoById(id).statusCode(200);
        HashMap<String,Object> value = response.extract().path("");
        Assert.assertThat(value,hasValue(name));
    }

    @And("^I delete the store that created with name \"([^\"]*)\"$")
    public void iDeleteTheStoreThatCreatedWithName(String _name){
        storeSteps.deleteStore(id);
    }

    @Then("^The store deleted successfully from the application$")
    public void theStoreDeletedSuccessfullyFromTheApplication() {
        response.statusCode(200);
        storeSteps.getStoreInfoById(id).statusCode(404);
    }
}
