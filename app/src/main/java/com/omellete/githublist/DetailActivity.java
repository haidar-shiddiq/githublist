package com.omellete.githublist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailActivity extends Activity {
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView name = findViewById(R.id.name);
        TextView detail = findViewById(R.id.detail);
        ImageView image = findViewById(R.id.image);
        back = (Button) findViewById(R.id.back);

        name.setText (getIntent().getStringExtra("charuname"));
        detail.setText (getIntent().getStringExtra("charname"));
        int imageurl = getIntent().getIntExtra("charava",0);
        Glide.with(this)
                .asBitmap()
                .load(imageurl)
                .into(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent inte = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(inte);
            }
        });
    }
}