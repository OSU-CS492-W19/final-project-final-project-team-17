package com.example.starwarsinfo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SpeciesAdapter  extends RecyclerView.Adapter<SpeciesAdapter.StarWarsViewHolder>{
    private List<SpeciesUtils.StarWarsSpecies> mSWList;

    public void updateSpeciesResults(List<SpeciesUtils.StarWarsSpecies> items){
        mSWList = items; //arraylist and list not working out
        notifyDataSetChanged();
    }

    public SpeciesAdapter(){
    }

    public void addSWList(SpeciesUtils.StarWarsSpecies swSpecies) {
        mSWList.add(swSpecies);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return mSWList.size();
    }

    @NonNull
    @Override
    public SpeciesAdapter.StarWarsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.starwars_list_item, viewGroup, false);
        return new SpeciesAdapter.StarWarsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesAdapter.StarWarsViewHolder starWarsViewHolder, int i) {
        SpeciesUtils.StarWarsSpecies todo = mSWList.get(mSWList.size() - i - 1);
        starWarsViewHolder.bind(todo);
    }

    class StarWarsViewHolder extends RecyclerView.ViewHolder {
        private TextView mStarWarsTV;

        public StarWarsViewHolder(View itemView) {
            super(itemView);
            mStarWarsTV = itemView.findViewById(R.id.tv_starwars_text); // -------------------- HELP
        }

        public void bind(SpeciesUtils.StarWarsSpecies SWdetail){
            mStarWarsTV.setText(SWdetail.name);
            mStarWarsTV.setText(SWdetail.classification);
            mStarWarsTV.setText(SWdetail.mass);
        }
    }
}

