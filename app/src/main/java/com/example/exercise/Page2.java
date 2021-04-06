package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Page2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, SearchView.OnQueryTextListener {

    private ListView list;
    private ListViewAdapter adapter;
    String[] listNama;
    public static ArrayList<Nama> classNamaArrayList = new ArrayList<>();
    Bundle bundle = new Bundle();
    Intent intent;
    SearchView Cari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        listNama = new String[] {"Yasmina", "Sekar", "Fadhil", "Rio", "Arif", "Adel", "Indah"};
        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();
        for (int i = 0; i < listNama.length; i++)
        {
            Nama classNama = new Nama(listNama[i]);
            classNamaArrayList.add(classNama);
        }
        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);
        SearchView searchView = findViewById(R.id.search);
        Cari = searchView;
        searchView.setOnQueryTextListener(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getNama();
                bundle.putString("a",nama.trim());
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                pm.setOnMenuItemClickListener(Page2.this);
                pm.inflate(R.menu.detailkontak);
                pm.show();
            }
        });
    }
    public boolean onMenuItemClick (MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case  R.id.mnnomor:
                Toast.makeText(getApplicationContext(),"Ini Nomer nya", Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filter(s);
        return false;
    }
}