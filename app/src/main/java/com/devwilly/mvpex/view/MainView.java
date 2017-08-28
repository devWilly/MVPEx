package com.devwilly.mvpex.view;

import java.util.ArrayList;


/**
 * Created by Willy on 23/08/2017.
 */

public interface MainView {

    void setContentView();

    void initRecyclerView();

    void updateRecyclerView(ArrayList<String> noteList);

    void clearEditText();

    void showEmptyToast(String emptyMsg);

    void showSaveSharedPreferenceSuccessMsg(String saveSuccessMsg);
}
