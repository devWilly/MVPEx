package com.devwilly.mvpex;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;


/**
 * Created by Willy on 28/08/2017.
 */

public class DataManager {

    private static final String PREF_NAME = "pref_note_name";
    private static final String KEY_NOTE_LIST_TO_JSON_STRING = "key.note.list.to.json.string";
    private ArrayList<String> mNoteList = new ArrayList<>();
    private SharedPreferences mSharedPreferences;
    private Context mContext;
    private Gson mGson = new Gson();

    public DataManager(Context context) {
        this.mContext = context;
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void addNoteToFirstIndexOfList(String note) {
        mNoteList.add(0, note);
    }

    public ArrayList<String> getNoteList() {
        return mNoteList;
    }

    public String getEmptyMsg() {
        return mContext.getString(R.string.empty_message);
    }

    public void removeNoteFromList(int index) {
        mNoteList.remove(index);
    }

    public void saveToSharePreference() {
        mSharedPreferences.edit().putString(KEY_NOTE_LIST_TO_JSON_STRING, mGson.toJson(mNoteList)).apply();
    }

    public String getSaveSuccessMsg() {
        ArrayList<String> list = mGson.fromJson(mSharedPreferences.getString(KEY_NOTE_LIST_TO_JSON_STRING, null), new TypeToken<ArrayList<String>>() {}.getType());
        return mContext.getString(R.string.save_sharedpreference_success_message, String.valueOf(list.size()));
    }
}
