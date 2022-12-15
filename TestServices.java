import io.restassured.mapper.ObjectMapperType;
import org.junit.Test;

import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


public class TestServices {

    String baseURI = "http://api.zippopotam.us/";
    @Test
    public void MainTest(){
        String countryShortName = "us";
        String postCode = "90210";

        List<Places> listPlaces = Arrays.asList(new Places("California","Beverly Hills","-118.4065","CA","34.0901"));
        CountryCode expectedResult = new CountryCode("90210","United States","US", listPlaces);

        CountryCode actualResult =
        given().when().get(baseURI + countryShortName + "/" + postCode)
                .as(CountryCode.class, ObjectMapperType.GSON);

        assertThat(actualResult.getPostCode(), equalTo(expectedResult.getPostCode()));
        assertThat(actualResult.getCountry(), equalTo(expectedResult.getCountry()));
        assertThat(actualResult.getCountryAbbreviation(), equalTo(expectedResult.getCountryAbbreviation()));
        List<Places> places = actualResult.getPlaces();
        for (Places place : places){
            assertThat(place.getState(), equalTo(listPlaces.get(0).getState()));
            assertThat(place.getPlaceName(), equalTo(listPlaces.get(0).getPlaceName()));
            assertThat(place.getLongitude(), equalTo(listPlaces.get(0).getLongitude()));
            assertThat(place.getStateAbbreviation(), equalTo(listPlaces.get(0).getStateAbbreviation()));
            assertThat(place.getLatitude(), equalTo(listPlaces.get(0).getLatitude()));
        }

    }
    @Test
    public void ExTest(){
        String countryShortName = "us";
        String postCode = "90210";

        given().when().get(baseURI + countryShortName + "/" + postCode)
                .then().log().body();
    }

    // goal to deserialize the json response and verify it based on the potential expected results.
    //then tests to be set in order to validate the boundaries of expected valid values
    //i.e. Range of available postcodes associated to a specific country
    // then validation of the HTTP code response based on the breaking of the service signature
    //i.e. insert an unsupported country code or invalid post code for a specific country -->
    // expected HTTP code 400 (with the validation as well)
    // Then of course validating also the new implementation regarding country/state/city combination

    @Test
    public void EmptyTest(){

        given().when().get(baseURI)
                .then().statusCode(400);
    }

    @Test
    public void NoCountryTest(){
        String countryShortName = "gg";
        String postCode = "90210";

        given().when().get(baseURI + countryShortName + "/" + postCode)
                .then().statusCode(404);
    }

}
