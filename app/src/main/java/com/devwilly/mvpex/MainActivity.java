package com.devwilly.mvpex;

import com.devwilly.mvpex.model.MainModel;
import com.devwilly.mvpex.presenter.MainPresenter;
import com.devwilly.mvpex.view.MainView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MainView, NoteAdapter.DeleteButtonListener {

    private MainPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private NoteAdapter mNoteAdapter;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new MainPresenter(MainActivity.this, new MainModel());
        mPresenter.onCreate();
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.input_edit_text);
        findViewById(R.id.note_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onSaveButtonClick(mEditText.getText().toString());
            }
        });
    }

    @Override
    public void initRecyclerView() {
        mNoteAdapter = new NoteAdapter(new ArrayList<String>(), MainActivity.this);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mNoteAdapter);
    }

    @Override
    public void updateRecyclerView(ArrayList<String> noteList) {
        mNoteAdapter.updateNotes(noteList);
    }

    @Override
    public void clearEditText() {
        mEditText.setText("");
    }

    @Override
    public void showEmptyToast(String emptyMsg) {
        Toast.makeText(MainActivity.this, emptyMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteButtonClick(int index) {
        mPresenter.onDeleteButtonClick(index);
    }
}
