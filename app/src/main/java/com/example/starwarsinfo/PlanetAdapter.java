package com.example.starwarsinfo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlanetAdapter  extends RecyclerView.Adapter<PlanetAdapter.StarWarsViewHolder>{
    private List<PlanetUtils.StarWarsPlanet> mSWList;

    public void updatePlanetResults(List<PlanetUtils.StarWarsPlanet> items){
        mSWList = items; //arraylist and list not working out
        notifyDataSetChanged();
    }

    public PlanetAdapter(){
    }

    public void addSWList(PlanetUtils.StarWarsPlanet swPlanet) {
        mSWList.add(swPlanet);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return mSWList.size();
    }

    @NonNull
    @Override
    public PlanetAdapter.StarWarsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.starwars_list_item, viewGroup, false);
        return new PlanetAdapter.StarWarsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.StarWarsViewHolder starWarsViewHolder, int i) {
        PlanetUtils.StarWarsPlanet todo = mSWList.get(mSWList.size() - i - 1);
        starWarsViewHolder.bind(todo);
    }

    class StarWarsViewHolder extends RecyclerView.ViewHolder {
        private TextView mStarWarsTV;

        public StarWarsViewHolder(View itemView) {
            super(itemView);
            mStarWarsTV = itemView.findViewById(R.id.tv_starwars_text); // -------------------- HELP
        }

        public void bind(PlanetUtils.StarWarsPlanet SWdetail){
            mStarWarsTV.setText(SWdetail.name);
            mStarWarsTV.setText(SWdetail.gravitiy);
            mStarWarsTV.setText(SWdetail.mass);
            mStarWarsTV.setText(SWdetail.population);
        }

    }
}
