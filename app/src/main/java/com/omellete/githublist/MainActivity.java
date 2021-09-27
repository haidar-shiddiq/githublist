package com.omellete.githublist;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvChar;
    private final ArrayList<GithubUser> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvChar = findViewById(R.id.rv_char);
        rvChar.setHasFixedSize(true);

        list.addAll(getUserData());
        showRecyclerList();
    }

    private ArrayList<GithubUser> getUserData() {
        String[] unamex = getResources().getStringArray(R.array.username);
        String[] namex = getResources().getStringArray(R.array.name);
        TypedArray avatx = getResources().obtainTypedArray(R.array.avatar);
        String[] locationx = getResources().getStringArray(R.array.location);
        String[] compx = getResources().getStringArray(R.array.company);
        String[] followerx = getResources().getStringArray(R.array.followers);
        String[] followingx = getResources().getStringArray(R.array.following);
        String[] repox = getResources().getStringArray(R.array.repository);

        ArrayList<GithubUser> list = new ArrayList<>();
        for (int pos = 0; pos < unamex.length; pos++) {
            GithubUser githubUser = new GithubUser();
            githubUser.setUsername(unamex[pos]);
            githubUser.setName(namex[pos]);
            githubUser.setAvatar(avatx.getResourceId(pos, -1));
            githubUser.setCompany(compx[pos]);
            githubUser.setLocation(locationx[pos]);
            githubUser.setFollower(followerx[pos]);
            githubUser.setFollowing(followingx[pos]);
            githubUser.setRepository(repox[pos]);
            list.add(githubUser);
        }
        avatx.recycle();
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