package com.example.vollydemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.recylerViewHolder>{


    private final Context context;
    private User[] data;

    public recyclerAdapter(Context context, User[] data){

        this.context= context;
        this.data=data;

    }
    @NonNull
    @Override
    public recylerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_layout,parent, false);
        return new recylerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull recylerViewHolder holder, int position) {

        final User user=data[position];
        holder.textView.setText(user.getLogin());
        Glide.with(holder.imageView.getContext()).load(user.getAvatarUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, user.getLogin()+ "Was Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class recylerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public recylerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.imageview1);
            textView=(TextView)itemView.findViewById(R.id.textuser);
        }
    }
}
