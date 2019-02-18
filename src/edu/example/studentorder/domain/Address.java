package edu.example.studentorder.domain;

public class Address {
    private String postCode;
    private String streetName;
    private String building;
    private String extension;
    private String apartment;

    public Address(String index, String streetName, String building, String extension , String apartment) {
        this.postCode = index;
        this.streetName = streetName;
        this.building = building;
        this.extension = extension;
        this.apartment = apartment;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostcode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
