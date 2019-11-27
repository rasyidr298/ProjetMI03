package com.example.projectmio3;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.projectmio3.room.AppDatabase;
import com.example.projectmio3.room.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

import static com.example.projectmio3.AppAplication.db;


public class DetailActivity extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecycleAdapter recycleAdapter;
    List<Mahasiswa>listMahasiswa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mRecyclerview =findViewById(R.id.mRecyclerView);
        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom(){
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
        listMahasiswa = db.userDao().getAll();

        for (int i = 0; i<listMahasiswa.size(); i++) {
            Log.e("Aplikasi ", listMahasiswa.get(i).getAlamat() + i);
            Log.e("Aplikasi ", listMahasiswa.get(i).getKejuruan() + i);
            Log.e("Aplikasi ", listMahasiswa.get(i).getNama() + i);
            Log.e("Aplikasi ", listMahasiswa.get(i).getNim() + i);
        }
        Log.e( "cek list",""+listMahasiswa.size());
    }

    private void initRecyclerView(){
        mRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(llm);
        recycleAdapter = new RecycleAdapter(this,listMahasiswa);
    }

    private void setAdapter(){
        mRecyclerview.setAdapter(recycleAdapter);
    }
}
