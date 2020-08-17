package com.example.macromanager.macrostorage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    MacroDao dao;
    LiveData<List<MacroStorage>> allmacros;

    public Repository(Application application) {
        MacroDatabase database = MacroDatabase.getInstance(application);
        dao = database.macroDao();
        allmacros = dao.getallmacros();
    }

    public LiveData<List<MacroStorage>> getAllmacros() {
        return allmacros;
    }


    public void delete(MacroStorage obj) {
        new DeleteAsync(dao).execute(obj);
    }


    public void update(MacroStorage obj) {
        new UpdateAsync(dao).execute(obj);
    }

    public void insert(MacroStorage obj) {
        new InsertAsync(dao).execute(obj);
    }


    private static class InsertAsync extends AsyncTask<MacroStorage, Void, Void> {

        MacroDao dao;

        InsertAsync(MacroDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(MacroStorage... macroStorages) {
            dao.insert(macroStorages[0]);
            return null;
        }
    }

    private static class DeleteAsync extends AsyncTask<MacroStorage, Void, Void> {

        MacroDao dao;

        DeleteAsync(MacroDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(MacroStorage... macroStorages) {
            dao.delete(macroStorages[0]);
            return null;
        }
    }

    private static class UpdateAsync extends AsyncTask<MacroStorage, Void, Void> {

        MacroDao dao;

        UpdateAsync(MacroDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(MacroStorage... macroStorages) {
            dao.update(macroStorages[0]);
            return null;
        }
    }


}
