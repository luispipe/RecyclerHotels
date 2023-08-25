package com.example.recyclerexample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElements> data;
    private LayoutInflater inflater;
    private Context context;

    public ListAdapter(List<ListElements>itemList,Context context){
        this.inflater= LayoutInflater.from(context);
        this.context= context;
        this.data= itemList;
    }

    @Override
    public int getItemCount(){ return data.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int type){
        View view= inflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(data.get(position));
    }

    public void setItems(List<ListElements> items){ data=items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView name,city,status;
        ViewHolder(View itemView){
            super(itemView);
            icon= itemView.findViewById(R.id.ivIcon);
            name= itemView.findViewById(R.id.tvName);
            city= itemView.findViewById(R.id.tvCity);
            status= itemView.findViewById(R.id.tvAvai);
        }

        void  bindData(final ListElements item){
            icon.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            city.setText(item.getCity());
            status.setText(item.getStatus());
        }
    }

}
