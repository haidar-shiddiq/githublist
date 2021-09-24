package com.omellete.githublist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.TypedArray;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvChar;
    private ArrayList<Charv> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvChar = findViewById(R.id.rv_char);
        rvChar.setHasFixedSize(true);

        list.addAll(getUserData());
        showRecyclerList();
    }

    private ArrayList<Charv> getUserData() {
        String[] unamex = getResources().getStringArray(R.array.username);
        String[] namex = getResources().getStringArray(R.array.name);
        TypedArray avatx = getResources().obtainTypedArray(R.array.avatar);
        String[] locationx = getResources().getStringArray(R.array.location);
        String[] compx = getResources().getStringArray(R.array.company);
        String[] followerx = getResources().getStringArray(R.array.followers);
        String[] followingx = getResources().getStringArray(R.array.following);
        String[] repox = getResources().getStringArray(R.array.repository);

        ArrayList<Charv> list = new ArrayList<>();
        for (int pos = 0; pos < unamex.length; pos++) {
            Charv charv = new Charv();
            charv.setUsername(unamex[pos]);
            charv.setName(namex[pos]);
            charv.setAvatar(avatx.getResourceId(pos, -1));
            charv.setCompany(compx[pos]);
            charv.setLocation(locationx[pos]);
            charv.setFollower(followerx[pos]);
            charv.setFollowing(followingx[pos]);
            charv.setRepository(repox[pos]);
            list.add(charv);
        }
        return list;
    }

    private void showRecyclerList() {
        rvChar.setLayoutManager(new LinearLayoutManager(this));
        ListCharAdapter listHeroAdapter = new ListCharAdapter(list);
        rvChar.setAdapter(listHeroAdapter);
    }

    public void onBackPressed() {
        finishAffinity();
        finish();
    }

}