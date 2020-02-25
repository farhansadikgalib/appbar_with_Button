package com.farhan.volleywithrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Anime> animeModelList;
    RequestOptions options;

    public Adapter(Context mContext, List<Anime> animeModelList) {
        this.mContext = mContext;
        this.animeModelList = animeModelList;
        //options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_star_black_24dp);


        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_star_black_24dp)
                .error(R.drawable.ic_launcher_background);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_row,parent,false);

        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.view_Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,AnimeActivity.class);
                intent.putExtra("anime_name",animeModelList.get(viewHolder.getAdapterPosition()).getName());
                intent.putExtra("anime_category",animeModelList.get(viewHolder.getAdapterPosition()).getCategorie());
                intent.putExtra("anime_rating",animeModelList.get(viewHolder.getAdapterPosition()).getRating());
                intent.putExtra("anime_studio",animeModelList.get(viewHolder.getAdapterPosition()).getStudio());
                intent.putExtra("anime_img",animeModelList.get(viewHolder.getAdapterPosition()).getImg());
                intent.putExtra("anime_des",animeModelList.get(viewHolder.getAdapterPosition()).getDescription());


                mContext.startActivity(intent);
            }
        });

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nameTV.setText(animeModelList.get(position).getName());
        holder.category_TV.setText(animeModelList.get(position).getCategorie());
        holder.rating_TV.setText(animeModelList.get(position).getRating());
        holder.studioTV.setText(animeModelList.get(position).getStudio());
        //    holder.img_thumbnile.setText(animeModelList.get(position).getImg());

        Glide.with(mContext).load(animeModelList.get(position).getImg()).apply(options).into(holder.img_Thumb);




    }

    @Override
    public int getItemCount() {
        return animeModelList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView nameTV,studioTV,category_TV,rating_TV;
        ImageView img_Thumb;
        LinearLayout view_Container;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            nameTV = itemView.findViewById(R.id.nameTv);
            studioTV = itemView.findViewById(R.id.studioTv);
            category_TV = itemView.findViewById(R.id.categoriesTv);
            rating_TV = itemView.findViewById(R.id.ratingTv);
            img_Thumb = itemView.findViewById(R.id.imageX);
            view_Container = itemView.findViewById(R.id.containerX);

        }
    }



}
