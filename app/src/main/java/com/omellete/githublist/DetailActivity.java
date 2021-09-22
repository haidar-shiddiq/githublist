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
    public static final String PARCELNIH = "parcelnih";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView uname = findViewById(R.id.name);
        TextView name = findViewById(R.id.detail);
        ImageView image = findViewById(R.id.image);
        back = (Button) findViewById(R.id.back);

        Charv charv = getIntent().getParcelableExtra(PARCELNIH);
        uname.setText (charv.getUsername());
        name.setText(charv.getName());
        int imageurl = charv.getAvatar();
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