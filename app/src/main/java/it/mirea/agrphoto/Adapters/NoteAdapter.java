package it.mirea.agrphoto.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import it.mirea.agrphoto.Model.Note;
import it.mirea.agrphoto.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder>{

    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_recycle_data,parent,false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note workNote = notes.get(position);
        holder.textTitle.setText(workNote.getTitle());
        holder.textDescription.setText(workNote.getDescription());
        holder.textDate.setText(workNote.getDate());
        holder.textPriority.setText(String.valueOf(workNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position){
        return notes.get(position);
    }

    class NoteHolder extends ViewHolder {

        private TextView textTitle;
        private TextView textDescription;
        private TextView textDate;
        private TextView textPriority;

        public NoteHolder(View itemView){
            super(itemView);
            textTitle = itemView.findViewById(R.id.textname);
            textDescription = itemView.findViewById(R.id.textlist);
            textDate = itemView.findViewById(R.id.textdate);
            textPriority = itemView.findViewById(R.id.textpriority);
        }
    }


}
