package com.example.mobileshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    List<Model> list;

    public MyAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.design,viewGroup,false);
        TextView txt1,txt2,txt3,txt4,txt5;

        txt1 = view.findViewById(R.id.txtfname);
        txt2 = view.findViewById(R.id.txtlname);
        txt3 = view.findViewById(R.id.txtemail);
        txt4 = view.findViewById(R.id.txtmobile);
        txt5 = view.findViewById(R.id.txtpass);

        txt1.setText(list.get(i).fname);
        txt2.setText(list.get(i).lname);
        txt3.setText(list.get(i).email);
        txt4.setText(list.get(i).mobile);
        txt5.setText(list.get(i).pass);


        return view;
    }

   /* @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.design,parent,false);

        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position) {

        holder.txt1.setText(list.get(position).fname);
        holder.txt2.setText(list.get(position).lname);
        holder.txt3.setText(list.get(position).email);
        holder.txt4.setText(list.get(position).mobile);
        holder.txt5.setText(list.get(position).pass);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myview extends RecyclerView.ViewHolder {

        TextView txt1,txt2,txt3,txt4,txt5;

        public Myview(@NonNull View itemView) {
            super(itemView);

            txt1 = itemView.findViewById(R.id.txtfname);
            txt2 = itemView.findViewById(R.id.txtlname);
            txt3 = itemView.findViewById(R.id.txtemail);
            txt4 = itemView.findViewById(R.id.txtmobile);
            txt5 = itemView.findViewById(R.id.txtpass);
        }
    }*/
}
