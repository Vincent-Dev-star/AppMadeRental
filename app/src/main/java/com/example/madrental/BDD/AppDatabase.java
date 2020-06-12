package com.example.madrental.BDD;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CarsDTO.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CarsDAO carsDAO();

}
