package com.androidhands.todolistsqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoRecyclerAdapter extends RecyclerView.Adapter<ToDoRecyclerAdapter.MyViewHolder> {
    private List<ToDoModel> toDoModelList;

    ToDoRecyclerAdapter(List<ToDoModel> toDoModelList) {
        this.toDoModelList = toDoModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ToDoModel toDoModel = toDoModelList.get(position);
        holder.toDoItem.setText(toDoModel.getToDoItem());
        holder.toDoDate.setText(toDoModel.getToDoDate());
        holder.toDoTime.setText(toDoModel.getToDoTime());
    }

    @Override
    public int getItemCount() {
        return toDoModelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView toDoItem,toDoDate,toDoTime;
        Button edit,delete,complete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            toDoItem = itemView.findViewById(R.id.toDoItem);
            toDoDate = itemView.findViewById(R.id.toDoDate);
            toDoTime = itemView.findViewById(R.id.toDoTime);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
            complete = itemView.findViewById(R.id.complete);
        }
    }
}
