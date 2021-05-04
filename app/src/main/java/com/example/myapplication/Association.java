package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Association {
    @SerializedName("_id")
    private String id;
    private String nom;
    @SerializedName("images")
    private String[] urlImages;
    private String description;
    private String adresse;
    private String telephone;
    private String email;

    public Association() {}

    public Association(String nom, String[] urlImages,
                       String description, String adresse,
                       String telephone, String email) {
        this.nom = nom;
        this.urlImages = urlImages;
        this.description = description;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public Association(String id, String nom, String[] urlImages,
                       String description, String adresse,
                       String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.urlImages = urlImages;
        this.description = description;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String[] getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(String[] urlImages) {
        this.urlImages = urlImages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
