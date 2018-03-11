package com.example.android.bakingapp.utilities;

/**
 * Created by hjadhav on 12/31/2017.
 */

public class RecepieProfileData {
    String id,name,servings,image;
    String quantity,measure,ingredient;
    String idSteps,shortDescription,description,videoURL,thumbnailURL;

    public RecepieProfileData (String id,String name,String servings,String image,String quantity,String measure,String ingredient,String idSteps,
                               String shortDescription,String description,String videoURL, String thumbnailURL){
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.image = image;
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
        this.idSteps = idSteps;
        this.shortDescription = shortDescription;
        this.description = description;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;
    }
    // Getter and Setter Methods
    public String getId(){return id;}
    public void setId (String id){this.id = id;}

    public String getName(){return name;}
    public void setName (String name){this.name = name;}

    public String getServings(){return servings;}
    public void setServings (String servings){this.servings = servings;}

    public String getImage(){return image;}
    public void setImage (String image){this.image = image;}

    public String getQuantity(){return quantity;}
    public void setQuantity (String quantity){this.quantity = quantity;}

    public String getMeasure(){return measure;}
    public void setMeasure (String measure){this.measure = measure;}

    public String getIngredient(){return ingredient;}
    public void setIngredient (String ingredient){this.ingredient = ingredient;}

    public String getIdSteps(){return idSteps ;}
    public void setIdSteps (String idSteps){this.idSteps = idSteps;}

    public String getShortDescription(){return shortDescription;}
    public void setShortDescription (String shortDescription){this.shortDescription = shortDescription;}

    public String getDescription(){return description;}
    public void setDescription (String description){this.description = description;}

    public String getVideoURL(){return videoURL;}
    public void setVideoURL (String videoURL){this.videoURL = videoURL;}

    public String getThumbnailURL(){return thumbnailURL;}
    public void setThumbnailURL (String thumbnailURL){this.thumbnailURL = thumbnailURL;}
}
