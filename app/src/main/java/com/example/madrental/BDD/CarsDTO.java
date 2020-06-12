package com.example.madrental.BDD;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Arrays;
import java.util.List;

@Entity(tableName = "cars")
public class CarsDTO
{
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;

    public String image;
    public int prixjournalier;
    public int promotion;
    public int agemin;
    public char categorieco2;


    public CarsDTO(long id, String name, String image, int prixjournalier, int promotion, int agemin, char categorieco2) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.prixjournalier = prixjournalier;
        this.promotion = promotion;
        this.agemin = agemin;
        this.categorieco2 = categorieco2;
    }

}
