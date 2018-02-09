package com.example.kunal.recycleviewsample;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by kunal on 13/12/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ObjectClass> list;

    public RecyclerViewAdapter(List<ObjectClass> list) {
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("TEST", "onCreateViewHolder: ");
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrow,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ObjectClass item= list.get(position);
        Log.d("TEST", "onBindViewHolder: "+item.toString());
        holder.Desc.setText(item.getDesc());
        holder.name.setText(item.getName());
        holder.llview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "item "+position+" clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,Desc;
        View llview;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            Desc= itemView.findViewById(R.id.tv_desc);
            llview=itemView;
        }
    }
}
