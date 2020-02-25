package com.farhan.volleywithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class AnimeActivity extends AppCompatActivity {

    private TextView nameTVx,nameTVa,studioTVx,category_TVx,rating_TVx,description_TvX;
    private ImageView img_Thumbx;
    private  String  url= "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);


//        getSupportActionBar().hide();



        String name = getIntent().getExtras().getString("anime_name");
        String category = getIntent().getExtras().getString("anime_category");
        String rating = getIntent().getExtras().getString("anime_rating");
        String studio = getIntent().getExtras().getString("anime_studio");
        String img = getIntent().getExtras().getString("anime_img");
        String description = getIntent().getExtras().getString("anime_des");



        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitleEnabled(true);

         nameTVx = findViewById(R.id.nameTv_a);
         studioTVx = findViewById(R.id.studioTv_a);
         category_TVx = findViewById(R.id.categoriesTv_a);
         rating_TVx = findViewById(R.id.ratingTv_a);
         img_Thumbx = findViewById(R.id.imageX_a);
         description_TvX = findViewById(R.id.anime_des);



         nameTVx.setText(name);
         category_TVx.setText(category);
         rating_TVx.setText(rating);
         studioTVx.setText(studio);
         description_TvX.setText(description);
         collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ic_star_black_24dp).error(R.drawable.ic_star_black_24dp);


        Glide.with(this).load(url).apply(requestOptions).into(img_Thumbx);






    }
}
