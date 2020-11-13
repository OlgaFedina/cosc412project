package com.example.datatest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {


    private Context context;
    Activity activity;
    private ArrayList _id, entry_title, entry_date, entry_desc;

    int position;

    CustomerAdapter(Activity activity, Context context,
                    ArrayList _id,
                    ArrayList entry_title,
                    ArrayList entry_date,
                    ArrayList entry_desc) {
        this.activity = activity;
        this.context = context;
        this._id = _id;
        this.entry_title = entry_title;
        this.entry_date = entry_date;
        this.entry_desc = entry_desc;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        this.position = position;
        holder._id_txt.setText(String.valueOf(_id.get(position)));
        holder.entry_title_txt.setText(String.valueOf(entry_title.get(position)));
        holder.entry_date_txt.setText(String.valueOf(entry_date.get(position)));
        holder.entry_desc_txt.setText(String.valueOf(entry_desc.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(_id.get(position)));
                intent.putExtra("title", String.valueOf(entry_title.get(position)));
                intent.putExtra("date", String.valueOf(entry_date.get(position)));
                intent.putExtra("desc", String.valueOf(entry_desc.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    public int getItemCount() {

        return _id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView _id_txt, entry_title_txt, entry_date_txt, entry_desc_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            _id_txt = itemView.findViewById(R.id.entry_id_txt);
            entry_title_txt = itemView.findViewById(R.id.entry_title_txt);
            entry_date_txt = itemView.findViewById(R.id.entry_date_txt);
            entry_desc_txt = itemView.findViewById(R.id.entry_desc_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
