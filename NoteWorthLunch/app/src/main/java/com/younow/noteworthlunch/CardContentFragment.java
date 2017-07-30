package com.younow.noteworthlunch;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 07/24/16.
 */
public class CardContentFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_main, container, false);
        //CardPresenter cardPresenter = new CardPresenter(getActivity().getCacheDir());
        //cardPresenter.init();
        ListItemObject listItemObjectA = new ListItemObject("A","Address");
        ListItemObject listItemObjectB = new ListItemObject("B","Address");
        ListItemObject listItemObjectC = new ListItemObject("C","Address");
        ListItemObject listItemObjectD = new ListItemObject("D","Address");
        ListItemObject listItemObjectE = new ListItemObject("E","Address");
        ListItemObject listItemObjectF = new ListItemObject("F","Address");

        ArrayList<ListItemObject> listItemObjects = new ArrayList<>();

        listItemObjects.add(listItemObjectA);
        listItemObjects.add(listItemObjectB);
        listItemObjects.add(listItemObjectC);
        listItemObjects.add(listItemObjectD);
        listItemObjects.add(listItemObjectE);

        ContentAdapter adapter = new ContentAdapter(listItemObjects, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item, parent, false));

            //CardPresenter cardPresenter = new CardPresenter(itemView.getContext().getCacheDir());
            //cardPresenter.init();



            name = (TextView) itemView.findViewById(R.id.textview);


        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static int LENGTH = 10;


        private ArrayList<ListItemObject> listItemObjects;

        public ContentAdapter(ArrayList<ListItemObject> listItemObjects, Context context) {

            //cardPresenter.cardRequests();
            this.listItemObjects = listItemObjects;
            LENGTH = listItemObjects.size();

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.name.setText(listItemObjects.get(position).getTitle());
            //holder.description.setText(listItemObjects.get(1).getAddress());
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
