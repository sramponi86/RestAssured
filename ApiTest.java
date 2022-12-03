package training;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import models.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    public void getCategories() {
        String endpoint = "http://127.0.0.1/api_testing/category/read.php";
        //var response =
                given().when().get(endpoint).then().assertThat().statusCode(200)
                        .body("records.size()", greaterThan(0))
                        .body("records.id",everyItem(notNullValue()))
                        .body("records.id[0]", equalTo("1"))
                        .header("Content-Type", equalTo("application/json; charset=UTF-8"));
        //response.log().body();
    }

    @Test
    public void getProduct() {
        String endpoint = "http://127.0.0.1/api_testing/product/read_one.php";
        //var response =
                given().queryParam("id",2).when().get(endpoint).then().assertThat().statusCode(200)
                        .body("id", equalTo("2")).body("name",equalTo("Cross-Back Training Tank"));
        //response.log().body();
    }

    @Test
    public void createProduct() {
    String endpoint = "http://127.0.0.1/api_testing/product/create.php";
    String body = """
            {
                "name": "Water",
                "description": "Blue",
                "price": 12,
                "category_id": 3
            }
            """;
    var response = given().body(body).when().post(endpoint).then();
        response.log().body();
}
    @Test
    public void updateProduct() {
        String endpoint = "http://127.0.0.1/api_testing/product/update.php";
        String body = """
            {
                "id": 19,
                "name": "Water",
                "description": "Red",
                "price": 15,
                "category_id": 3
            }
            """;
        var response = given().body(body).when().put(endpoint).then();
        response.log().body();
    }

    @Test
    public void deleteProduct() {
        String endpoint = "http://127.0.0.1/api_testing/product/delete.php";
        String body = """
            {
                "id": 19
            }
            """;
        var response = given().body(body).when().delete(endpoint).then();
        response.log().body();
    }

    @Test
    public void createSerializedProduct() {
        String endpoint = "http://127.0.0.1/api_testing/product/create.php";
        Product product = new Product("Water","Blue", 15,3);
        var response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void getDeserializedProduct() {
        String endpoint = "http://127.0.0.1/api_testing/product/read_one.php";
        Product expectedProducts = new Product(2,"Cross-Back Training Tank","The most awesome phone of 2013!",
                299.00,2,"Active Wear - Women");

        Product actualProduct = given().queryParam("id",2).when().get(endpoint)
                .as(Product.class);

        assertThat(actualProduct, samePropertyValuesAs(expectedProducts));
        //.then().assertThat()
          //      .statusCode(200)
            //    .body("id", equalTo("2"))
              //  .body("name",equalTo("Cross-Back Training Tank"));
    }
}
