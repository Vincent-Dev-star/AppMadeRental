package com.example.madrental.BDD;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cars")
public class CarsDTO
{

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String nom;
    public String image;
    public int disponible;
    public int prixjournalierbase;
    public int promotion;
    public int agemin;
    public char categorieco2;

    public CarsDTO(long id, String nom, String image, int disponible, int prixjournalierbase, int promotion, int agemin, char categorieco2) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.disponible = disponible;
        this.prixjournalierbase = prixjournalierbase;
        this.promotion = promotion;
        this.agemin = agemin;
        this.categorieco2 = categorieco2;
    }

}
