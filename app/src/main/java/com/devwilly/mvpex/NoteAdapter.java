package com.devwilly.mvpex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Willy on 24/08/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    public interface DeleteButtonListener {
        void onDeleteButtonClick(int index);
    }

    private ArrayList<String> mNoteList;

    private DeleteButtonListener mDeleteButtonListener;

    public NoteAdapter(ArrayList<String> noteList, DeleteButtonListener listener) {
        this.mNoteList = noteList;
        this.mDeleteButtonListener = listener;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NoteViewHolder holder, int position) {
        holder.noteText.setText(mNoteList.get(position));
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDeleteButtonListener.onDeleteButtonClick(holder.getLayoutPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }

    public void updateNotes(ArrayList<String> list) {
        mNoteList.clear();
        mNoteList.addAll(list);
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        public TextView noteText;
        public Button deleteButton;

        public NoteViewHolder(View itemView) {
            super(itemView);

            noteText = itemView.findViewById(R.id.item_note);
            deleteButton = itemView.findViewById(R.id.delete_button);

        }
    }
}
