package com.omellete.githublist;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {
    public static final String PARCELNIH = "parcelnih";
    public String isiShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar balik = getSupportActionBar();
        balik.setDisplayHomeAsUpEnabled(true);

        TextView uname = findViewById(R.id.uname);
        TextView name = findViewById(R.id.name);
        ImageView image = findViewById(R.id.image);
        TextView company = findViewById(R.id.company);
        TextView location = findViewById(R.id.location);
        TextView follower = findViewById(R.id.followers);
        TextView following = findViewById(R.id.following);
        TextView repo = findViewById(R.id.repo);
        FloatingActionButton share = findViewById(R.id.btnShare);

        Charv charv = getIntent().getParcelableExtra(PARCELNIH);
        isiShare = charv.getName();
        uname.setText (charv.getUsername());
        name.setText(charv.getName());
        company.setText(charv.getCompany());
        location.setText(charv.getLocation());
        repo.setText(charv.getRepository());
        follower.setText(charv.getFollower());
        following.setText(charv.getFollowing());
        int imageurl = charv.getAvatar();
        Glide.with(this)
                .asBitmap()
                .load(imageurl)
                .into(image);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hey! Im viewing "+isiShare+" on Github User List!";
                String shareSub = "Hey! Im using Github User List!";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
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