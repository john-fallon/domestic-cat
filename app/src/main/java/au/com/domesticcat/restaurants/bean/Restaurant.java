package au.com.domesticcat.restaurants.bean;

public class Restaurant {
    private String name;
    private String address;
    private String featureImageUrl;

    public Restaurant() {}

    public Restaurant(String name, String address, String featureImageUrl) {
        this.name = name;
        this.address = address;
        this.featureImageUrl = featureImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFeatureImageUrl() {
        return featureImageUrl;
    }

    public void setFeatureImageUrl(String featureImageUrl) {
        this.featureImageUrl = featureImageUrl;
    }
}
