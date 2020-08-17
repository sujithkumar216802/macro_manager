package com.example.macromanager.macrostorage;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MacroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MacroStorage macroStorage);

    @Delete
    void delete(MacroStorage macroStorage);

    @Query("SELECT * FROM macros")
    LiveData<List<MacroStorage>> getallmacros();

    @Update
    void update(MacroStorage macroStorage);



}
