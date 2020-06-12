package com.example.madrental.BDD;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
abstract class CarsDAO
{
    @Query("SELECT * FROM cars")
    public abstract List<CarsDTO> getListeCars();

    @Query("SELECT COUNT(*) FROM cars WHERE name = :name")
    public abstract  long countCarsParName(String name);

    @Insert
    public abstract void insert(CarsDTO... cars);

    @Update
    public abstract  void update(CarsDTO... cars);

    @Delete
    public abstract  void delete(CarsDTO... cars);

}
