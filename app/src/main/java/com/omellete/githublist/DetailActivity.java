package com.omellete.githublist;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    public static final String PARCEL_NIH = "parcel_nih";
    public String nameShare,unameShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        TextView uname = findViewById(R.id.uname);
        TextView name = findViewById(R.id.name);
        ImageView image = findViewById(R.id.image);
        TextView company = findViewById(R.id.company);
        TextView location = findViewById(R.id.location);
        TextView follower = findViewById(R.id.followers);
        TextView following = findViewById(R.id.following);
        TextView repo = findViewById(R.id.repo);
        FloatingActionButton share = findViewById(R.id.btnShare);

        GithubUser githubUser = getIntent().getParcelableExtra(PARCEL_NIH);
        nameShare = githubUser.getName();
        unameShare = githubUser.getUsername();
        uname.setText (githubUser.getUsername());
        name.setText(githubUser.getName());
        company.setText(githubUser.getCompany());
        location.setText(githubUser.getLocation());
        repo.setText(githubUser.getRepository());
        follower.setText(githubUser.getFollower());
        following.setText(githubUser.getFollowing());
        int imageUrl = githubUser.getAvatar();
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hey! Im viewing "+nameShare+" ("+unameShare+")"+" on Github User List!";
                String shareSub = "Hey! Im using Github User List!";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(DetailActivity.this,MainActivity.class));
        return super.onOptionsItemSelected(item);
    }

}