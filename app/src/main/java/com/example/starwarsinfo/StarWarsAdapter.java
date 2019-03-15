package com.example.starwarsinfo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StarWarsAdapter extends RecyclerView.Adapter<StarWarsAdapter.StarWarsViewHolder> {
    private ArrayList<String> mSWList;

    public void updateStarWarsResults(StarWarsUtils.StarWarsList[] items){
        mSWList = items; //arraylist and list not working out
        notifyDataSetChanged();
    }

    public StarWarsAdapter() {
        mSWList = new ArrayList<String>();
    }

    public void addSWList(String starwarslist) {
        mSWList.add(starwarslist);
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
        String todo = mSWList.get(mSWList.size() - i - 1);
        starWarsViewHolder.bind(todo);
    }

    class StarWarsViewHolder extends RecyclerView.ViewHolder {
        private TextView mStarWarsTV;

        public StarWarsViewHolder(View itemView) {
            super(itemView);
            mStarWarsTV = itemView.findViewById(R.id.tv_starwars_text); // -------------------- HELP
        }

        public void bind(String SWdetail) {
            mStarWarsTV.setText(SWdetail);
        }
    }
}