package com.example.beerlens.presentation.datas;

public class BeerData {

    String name;
    String image_url;
    String first_brewed;
    String description;
    String brewers_tips;

    String id;
    public BeerData(String nombre, String url, String first_brewed, String description, String brewers_tips, String id) {
        this.name = nombre;
        this.image_url = url;
        this.first_brewed = first_brewed;
        this.description = description;
        this.brewers_tips = brewers_tips;
        this.id = id;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getFirst_brewed() {
        return first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public String getBrewers_tips() {
        return brewers_tips;
    }
}
