package com.devwilly.mvpex.model;

import java.util.ArrayList;


/**
 * Created by Willy on 23/08/2017.
 */

public class MainModel {

    private ArrayList<String> mNoteList = new ArrayList<>();

    public void addToNoteList(String note) {
        mNoteList.add(0, note);
    }

    public ArrayList<String> getNoteList() {
        return mNoteList;
    }

    public String getEmptyMsg() {
        return "Note list is empty, please enter note!!";
    }

    public void removeNoteFromList(int index) {
        mNoteList.remove(index);
    }
}
