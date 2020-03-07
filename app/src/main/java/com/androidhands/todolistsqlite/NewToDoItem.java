package com.androidhands.todolistsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class NewToDoItem extends AppCompatActivity {

    MaterialEditText itemName;
    TextView toDoDate,toDoTime;
    Button setToDoDate,setToDoTime,saveNewItem;
    List<ToDoModel> toDoModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do_item);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add New Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String items = gson.toJson(toDoModelList);
                Intent intent = new Intent(NewToDoItem.this,MainActivity.class);
                intent.putExtra("list",items);
                startActivity(intent);
                finish();
            }
        });

        itemName = findViewById(R.id.itemName);
        toDoDate = findViewById(R.id.toDoDate);
        toDoTime = findViewById(R.id.toDoTime);



        saveNewItem = findViewById(R.id.saveNewItemBtn);
        saveNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             toDoModelList.add(new ToDoModel(itemName.getText().toString(),toDoDate.getText().toString(),toDoTime.getText().toString(),false));
               itemName.setText("");
                Toast.makeText(NewToDoItem.this, "Item saved", Toast.LENGTH_SHORT).show();
            }
        });


        setToDoDate = findViewById(R.id.toDoDateBtn);
        setToDoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                int year = calendar.get(java.util.Calendar.YEAR);
                int month = calendar.get(java.util.Calendar.MONTH);
                int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(NewToDoItem.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final java.util.Calendar c = java.util.Calendar.getInstance(Locale.ENGLISH);
                        c.set(java.util.Calendar.YEAR, year);
                        c.set(java.util.Calendar.MONTH, month);
                        c.set(java.util.Calendar.DAY_OF_MONTH, dayOfMonth);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                        final String strDate = format.format(c.getTime());
                        String[] monthName = {"January", "February", "March", "April", "May", "June", "July",
                                "August", "September", "October", "November", "December"};
                        toDoDate.setText(strDate);
                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });

        setToDoTime = findViewById(R.id.toDoTimeBtn);
        setToDoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int minuts = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(NewToDoItem.this, R.style.Theme_AppCompat_Dialog
                        , new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat hformate = new SimpleDateFormat("K:mm a",Locale.ENGLISH);
                        String event_Time = hformate.format(c.getTime());
                        toDoTime.setText(event_Time);

                    }
                },hours,minuts,false);
                timePickerDialog.show();
            }
        });



    }


}
