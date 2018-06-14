package home.com.br.geradordepessoas;

import android.graphics.Bitmap;

/**
 * Created by jefferson on 13/06/2018.
 */

public class User {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postCode;
    private String email;
    private String pictureLargeUrl;
    private Bitmap picture;

    public Bitmap getPicture(){
        return picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureLargeUrl() {
        return pictureLargeUrl;
    }

    public void setPictureLargeUrl(String pictureLargeUrl) {
        this.pictureLargeUrl = pictureLargeUrl;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }
}
