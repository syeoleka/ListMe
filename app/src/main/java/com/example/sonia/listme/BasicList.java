package com.example.sonia.listme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import android.view.View.OnClickListener;

public class BasicList extends AppCompatActivity {

    private ArrayList <String> listArray;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list);
        listArray = new ArrayList <String> (5);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listArray);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter_one, View v, int position,
                                    long arg3)
            {
                listArray.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void clearText(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("");
    }

    /** Called when the user taps the + button */
    public void addTask(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String new_task = editText.getText().toString();

        this.listArray.add(0, new_task);
        this.adapter.notifyDataSetChanged();


    }

}
