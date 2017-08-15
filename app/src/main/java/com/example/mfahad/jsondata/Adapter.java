package com.example.mfahad.jsondata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by M.FAHAD on 8/14/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder > {

    Context context;
    ArrayList<Data> data;

    public Adapter(ArrayList<Data> data , Context context){
        this.context = context;
        this.data =  data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView postId;
        public TextView id;
        public TextView name;
        public TextView email;
        public TextView body;
        public ViewHolder(View itemView){
            super(itemView);
            postId = (TextView)  itemView.findViewById(R.id.postId);
            id = (TextView)  itemView.findViewById(R.id.id);
            name = (TextView)  itemView.findViewById(R.id.name);
            email = (TextView)  itemView.findViewById(R.id.email);
            body = (TextView)  itemView.findViewById(R.id.body);
        }
    }
    // call when instance of ViewHolder class is created
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item,parent
                ,false);
        return new ViewHolder(v);
    }
    //after calling the onCreatViewHolderr
    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.postId.setText(data.get(position).getPostId());
        holder.id.setText(data.get(position).getId());
        holder.name.setText(data.get(position).getName());
        holder.email.setText(data.get(position).getEmail());
        holder.body.setText(data.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
