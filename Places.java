import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Places {

    @SerializedName("place name")
    @Expose
    private String placeName;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("state abbreviation")
    @Expose
    private String stateAbbreviation;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    public Places() {}
    public Places(String state, String city, String longitude, String shortState, String latitude) {
        this.state = state;
        this.placeName = city;
        this.longitude = longitude;
        this.stateAbbreviation = shortState;
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Places withPlaceName(String placeName) {
        this.placeName = placeName;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Places withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Places withState(String state) {
        this.state = state;
        return this;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public Places withStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Places withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

}
