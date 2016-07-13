package com.example.hanlu.healthyadvisor.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.activity.HealthyKnowleage;
import com.example.hanlu.healthyadvisor.base.ListBaseAdapter;
import com.example.hanlu.healthyadvisor.bean.HealthInfo;
import com.example.hanlu.healthyadvisor.bean.KnowledgeDetailInfo;
import com.example.hanlu.healthyadvisor.bean.KnowledgeInfo;
import com.example.hanlu.healthyadvisor.bean.KnowledgeDetailInfo;
import com.example.hanlu.healthyadvisor.utils.UiUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Admin on 2016/6/24  11:34
 *
 * @desc
 */
public class LoseWeightAdapter extends ListBaseAdapter<HealthInfo> {


    private  Context context;

    public LoseWeightAdapter(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected View getRealView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = View.inflate(context, R.layout.fragment_lose_weight, null);
            vh = new ViewHolder(convertView);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        HealthInfo healthInfo = mDatas.get(position);
        Log.i("title", "getRealView: "+healthInfo.getTitle());
        vh.title.setText(healthInfo.title);
        vh.reply.setText(healthInfo.getCount() + "访问");
        vh.favourate.setText(healthInfo.getFcount() + "收藏");
        utils.display(vh.image, healthInfo.getImg());

        return convertView;



    }


    static class ViewHolder {

        @InjectView(R.id.knowledge_item_text)
        TextView title;
        @InjectView(R.id.knowledge_item_reply)
        TextView reply;
        @InjectView(R.id.knowledge_item_favourate)
        TextView favourate;
        @InjectView(R.id.knowledge_item_image)
        ImageView image;


        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

}
