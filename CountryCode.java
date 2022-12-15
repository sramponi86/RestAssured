import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CountryCode {

    @SerializedName("post code")
    @Expose
    private String postCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("country abbreviation")
    @Expose
    private String countryAbbreviation;
    @SerializedName("places")
    @Expose
    private List<Places> places = null;

    public CountryCode() {}
    public CountryCode(String postCode, String country, String shortCountry, List<Places> listPlaces) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = shortCountry;
        this.setPlaces(listPlaces);
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public CountryCode withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryCode withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public CountryCode withCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
        return this;
    }

    public List<Places> getPlaces() {
        return places;
    }

    public void setPlaces(List<Places> places) {
        this.places = places;
    }

    public CountryCode withPlaces(List<Places> places) {
        this.places = places;
        return this;
    }

}
