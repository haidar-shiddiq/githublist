package com.omellete.githublist;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private RecyclerView rvChar;
    private ArrayList<Charv> list = new ArrayList<>();
    Button profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvChar = findViewById(R.id.rv_char);
        rvChar.setHasFixedSize(true);

        list.addAll(getUserData());
        showRecyclerList();

        profil = (Button) findViewById(R.id.profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(MainActivity.this, biodata.class);
                startActivity(inte);
            }
        });
    }

    private void showSelectedChar(Charv charv) {
        Toast.makeText(this, "Menampilkan Karakter " + charv.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("charuname", charv.getUsername());
        intent.putExtra("charnamee", charv.getName());
        intent.putExtra("charava", charv.getAvatar());
        startActivity(intent);
    }

    private ArrayList<Charv> getUserData() {
        String[] datauname = getResources().getStringArray(R.array.username);
        String[] datanamee = getResources().getStringArray(R.array.name);
        TypedArray datava = getResources().obtainTypedArray(R.array.avatar);
        moveWithObjectIntent.putParcelableArrayListExtra(parcelnih,Charv);
        ArrayList<Charv> list = new ArrayList<>();
        for (int pos = 0; pos < datauname.length; pos++) {
            Charv charv = new Charv();
            charv.setUsername(datauname[pos]);
            charv.setName(datanamee[pos]);
            charv.setAvatar(datava.getResourceId(pos, -1));
            list.add(charv);
        }
        return list;
    }

    private void showRecyclerList(){
        rvChar.setLayoutManager(new LinearLayoutManager(this));
        ListCharAdapter listHeroAdapter = new ListCharAdapter(list);
        rvChar.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListCharAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Charv data) {
                showSelectedChar(data);
            }
        });
    }

    public void onBackPressed() {
        finishAffinity();
        finish();
    }

}