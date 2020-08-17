package com.example.macromanager.macrostorage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = MacroStorage.class, version = 5, exportSchema = false)

@TypeConverters({Converter.class})
public abstract class MacroDatabase extends RoomDatabase {

    private static MacroDatabase instance;

    public abstract MacroDao macroDao();

    public static synchronized MacroDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MacroDatabase.class, "macrosstorage")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
