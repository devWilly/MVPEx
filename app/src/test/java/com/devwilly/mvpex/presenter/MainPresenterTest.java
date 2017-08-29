package com.devwilly.mvpex.presenter;

import com.devwilly.mvpex.DataManager;
import com.devwilly.mvpex.model.MainModel;
import com.devwilly.mvpex.view.MainView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


/**
 * Created by Willy on 24/08/2017.
 */
public class MainPresenterTest {

    @Mock
    private MainView mView;

    @Mock
    private MainModel mModel;

    private MainPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mView = mock(MainView.class);
        mModel = mock(MainModel.class);
        mPresenter = new MainPresenter(mView, mModel);
    }

    @Test
    public void onCreateTest() throws Exception {
        mPresenter.onCreate();

        verify(mView).setContentView();
        verify(mView).initRecyclerView();
    }

    @Test
    public void onSaveButtonClick_noDataTest() throws Exception {
        String note = "";
        mPresenter.onSaveButtonClick(note);

        verify(mView).showEmptyToast(mModel.getEmptyMsg());
    }

    @Test
    public void onSaveButtonClick_withDataTest() throws Exception {
        String note = "test";

        mPresenter.onSaveButtonClick(note);

        verify(mModel).addToNoteList(note);
        verify(mView).clearEditText();
        verify(mView).updateRecyclerView(mModel.getNoteList());

    }

    @Test
    public void onDeleteButtonClick() throws Exception {
        int index = 0;

        mPresenter.onDeleteButtonClick(index);

        verify(mModel).removeNoteFromList(index);
        verify(mView).updateRecyclerView(mModel.getNoteList());
    }

    @Test
    public void onSaveToSharePreference_withDataTest() throws Exception {
        DataManager dataManager = mock(DataManager.class);
        mModel.setDataManager(dataManager);

        ArrayList<String> list = new ArrayList<>();
        list.add(0, "first item");

        mPresenter.onSaveToSharePreference();

        when(dataManager.getNoteList()).thenReturn(list);

        verify(mModel, times(1)).saveToSharePreference();
        verify(mView, times(1)).showSaveSharedPreferenceSuccessMsg(mModel.getSaveSuccessMsg());

    }
}