package com.androidhands.todolistsqlite;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button addNewItem;
    RecyclerView recyclerView;
   public RecyclerView.Adapter adapter;
   public List<ToDoModel> toDoModelList = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("To Do List");
        addNewItem = findViewById(R.id.addNewItemActivityBtn);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NewToDoItem.class));
                finish();
            }
        });

        recyclerView = findViewById(R.id.toDoRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        String json = getIntent().getStringExtra("list");
        if (json != null){
            Gson gson = new Gson();
            TypeToken<List<ToDoModel>> typeToken = new TypeToken<List<ToDoModel>>() {
            };
            List<ToDoModel> newItems = gson.fromJson(json, typeToken.getType());
            Log.d("TAG", "onActivityResult: "+gson.toJson(newItems));
            toDoModelList.addAll(newItems);

        }else{
            toDoModelList.add(new ToDoModel("Buy Orange","2020-03-07","11:00 AM",false));
        }
        adapter = new ToDoRecyclerAdapter(toDoModelList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }






}


