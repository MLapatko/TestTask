package com.example.user.testtask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.testtask.model.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 03.12.2017.
 */

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {
    private static List<Film> filmsList;
    private static Context context;

    public FilmsAdapter(List<Film> filmsList,Context context) {
        this.context=context;
        this.filmsList = filmsList;
    }

    @Override
    public FilmsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.films_item,parent,
                false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.name.setText(filmsList.get(position).getName());
        holder.name_eng.setText(filmsList.get(position).getName_eng());
        Picasso.with(context)
                .load(filmsList.get(position).getImage())
                .error(R.drawable.default_picture)
                .into(holder.imageFilm);
    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        TextView name_eng;
        ImageView imageFilm;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.film_name);
            name_eng=(TextView) itemView.findViewById(R.id.film_name_eng);
            imageFilm=(ImageView)itemView.findViewById(R.id.film_image);
            itemView.setOnClickListener(this);
        }
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,FilmInformation.class);
                intent.putExtra("films",filmsList.get(this.getLayoutPosition()));
                context.startActivity(intent);
            }

    }
}
