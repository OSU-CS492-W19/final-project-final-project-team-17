package com.example.starwarsinfo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter  extends RecyclerView.Adapter<PeopleAdapter.StarWarsViewHolder>{
    private List<PeopleUtils.StarWarsPerson> mSWList;

    public void updatePeopleResults(List<PeopleUtils.StarWarsPerson> items){
        mSWList = items; //arraylist and list not working out
        notifyDataSetChanged();
    }

    public PeopleAdapter(){
    }

    public void addSWList(PeopleUtils.StarWarsPerson swPerson) {
        mSWList.add(swPerson);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if(mSWList == null){
            return 0;
        }
        else{
            return mSWList.size();
        }
    }

    @NonNull
    @Override
    public PeopleAdapter.StarWarsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.starwars_list_item, viewGroup, false);
        return new PeopleAdapter.StarWarsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.StarWarsViewHolder starWarsViewHolder, int i) {
        PeopleUtils.StarWarsPerson todo = mSWList.get(mSWList.size() - i - 1);
        starWarsViewHolder.bind(todo);
    }

    class StarWarsViewHolder extends RecyclerView.ViewHolder {
        private TextView mStarWarsTV;

        public StarWarsViewHolder(View itemView) {
            super(itemView);
            mStarWarsTV = itemView.findViewById(R.id.tv_starwars_text); // -------------------- HELP
        }

        public void bind(PeopleUtils.StarWarsPerson SWdetail) {
            mStarWarsTV.setText(SWdetail.name);
            mStarWarsTV.setText(SWdetail.height);
            mStarWarsTV.setText(SWdetail.mass);
        }

        /* CANNOT HAVE MULTIPLE BINDS
        public void bind(PlanetUtils.StarWarsPlanet SWdetail){
            mStarWarsTV.setText(SWdetail.name);
            mStarWarsTV.setText(SWdetail.gravitiy);
            mStarWarsTV.setText(SWdetail.mass);
            mStarWarsTV.setText(SWdetail.population);
        }

        public void bind(SpeciesUtils.StarWarsSpecies SWdetail){
            mStarWarsTV.setText(SWdetail.name);
            mStarWarsTV.setText(SWdetail.classification);
            mStarWarsTV.setText(SWdetail.mass);
        }
        */
    }
}
