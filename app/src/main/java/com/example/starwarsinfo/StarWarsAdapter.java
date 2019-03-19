package com.example.starwarsinfo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class StarWarsAdapter extends RecyclerView.Adapter<StarWarsAdapter.StarWarsViewHolder> {
    private List<StarWarsUtils.StarWarsPerson> mSWList;

    public void updateStarWarsResults(List<StarWarsUtils.StarWarsPerson> items){
        mSWList = items; //arraylist and list not working out
        notifyDataSetChanged();
    }

    public StarWarsAdapter(){
    }

    public void addSWList(StarWarsUtils.StarWarsPerson swPerson) {
        mSWList.add(swPerson);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return mSWList.size();
    }

    @NonNull
    @Override
    public StarWarsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.starwars_list_item, viewGroup, false);
        return new StarWarsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StarWarsViewHolder starWarsViewHolder, int i) {
        StarWarsUtils.StarWarsPerson todo = mSWList.get(mSWList.size() - i - 1);
        starWarsViewHolder.bind(todo);
    }

    class StarWarsViewHolder extends RecyclerView.ViewHolder {
        private TextView mStarWarsTV;

        public StarWarsViewHolder(View itemView) {
            super(itemView);
            mStarWarsTV = itemView.findViewById(R.id.tv_starwars_text); // -------------------- HELP
        }

        public void bind(StarWarsUtils.StarWarsPerson SWdetail) {
            mStarWarsTV.setText(SWdetail.name);
            mStarWarsTV.setText(SWdetail.height);
            mStarWarsTV.setText(SWdetail.mass);
        }
    }
}