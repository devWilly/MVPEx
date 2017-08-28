package com.devwilly.mvpex.model;

import com.devwilly.mvpex.DataManager;

import java.util.ArrayList;


/**
 * Created by Willy on 23/08/2017.
 */

public class MainModel {

    private DataManager mDataManager;

    public MainModel(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    public void addToNoteList(String note) {
        mDataManager.addNoteToFirstIndexOfList(note);
    }

    public ArrayList<String> getNoteList() {
        return mDataManager.getNoteList();
    }

    public String getEmptyMsg() {
        return mDataManager.getEmptyMsg();
    }

    public void removeNoteFromList(int index) {
        mDataManager.removeNoteFromList(index);
    }

    public void saveToSharePreference() {
        mDataManager.saveToSharePreference();
    }

    public String getSaveSuccessMsg() {
        return mDataManager.getSaveSuccessMsg();
    }
}
