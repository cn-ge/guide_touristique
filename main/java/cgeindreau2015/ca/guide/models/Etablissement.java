package cgeindreau2015.ca.guide.models;

import java.io.Serializable;

/**
 * Created by cgeindreau2015 on 26/04/2017.
 */

public class Etablissement implements Serializable{


    private String name;
    private String category;
    private String email;
    private String phone;
    private String url;
    private String image;

    public Etablissement(String name, String category, String email, String phone, String url, String image) {
        this.name = name;
        this.category = category;
        this.email = email;
        this.phone = phone;
        this.url = url;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
