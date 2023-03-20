package com.example.recyleview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> {

    private ArrayList<Tech> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTechName;
        private final TextView tvTechDs;
        private final ImageView imgTechPoster;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvTechName = view.findViewById(R.id.tech_name);
            tvTechDs =  view.findViewById(R.id.tech_description);
            imgTechPoster = view.findViewById(R.id.gambar);

        }

        private ArrayList<Tech> localDataSet;
    }



    // menerima data dan menyimpan
    public TechAdapter(ArrayList<Tech> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        String name = localDataSet.get(position).getName();
        String description = localDataSet.get(position).getDescription();
        int poster = localDataSet.get(position).getPoster();
        int pos = position;

        viewHolder.tvTechName.setText(name);
        viewHolder.tvTechDs.setText(description);
        viewHolder.imgTechPoster.setImageResource(poster);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DeetailActivity.class);
                intent.putExtra("title", name);
                intent.putExtra("description", description);
                intent.putExtra("poster",poster);

                viewHolder.itemView.getContext().startActivity(intent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
