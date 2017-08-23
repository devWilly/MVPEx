package com.devwilly.mvpex.presenter;

import com.devwilly.mvpex.model.MainModel;
import com.devwilly.mvpex.view.MainView;


/**
 * Created by Willy on 23/08/2017.
 */

public class MainPresenter {

    private MainView mView;
    private MainModel mModel;

    public MainPresenter(MainView view, MainModel model) {
        this.mView = view;
        this.mModel = model;
    }

    public void onSaveButtonClick(String note) {
        if (note.isEmpty()) {
            mView.showEmptyToast(mModel.getEmptyMsg());
            return;
        }

        mModel.addToNoteList(note);
        mView.clearEditText();
        mView.updateRecyclerView(mModel.getNoteList());
    }
}
