package com.demoapp.techworld;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> {

    private String[] techNames;
    private String[] techUrls;
    private Context context;

    public TechAdapter(Context context, String[] techNames, String[] techUrls) {
        this.context = context;
        this.techNames = techNames;
        this.techUrls = techUrls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemName.setText(techNames[position]);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("url", techUrls[position]);
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return techNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }
}