package com.example.hanlu.healthyadvisor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;

import java.util.List;

/**
 * Created by Admin on 2016/7/13  9:56
 *
 * @desc
 */
public class CommunicateRecylerAdapter extends RecyclerView.Adapter<CommunicateRecylerAdapter.ViewHolder> {


    private  List<String> list;

    public CommunicateRecylerAdapter(List<String> list) {
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(), R.layout.item_view,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
