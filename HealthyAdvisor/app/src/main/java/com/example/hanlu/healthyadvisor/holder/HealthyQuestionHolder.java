package com.example.hanlu.healthyadvisor.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.QueetionListInfo;
import com.example.hanlu.healthyadvisor.utils.UiUtils;

/**
 * Created by hanlu on 2016/3/6.
 */
public class HealthyQuestionHolder extends BaseHolder<QueetionListInfo.ResultEntity> {
    ImageView imageView;
    TextView title;
    TextView reply;
    TextView favourate;
    TextView comment;

    @Override
    public View initView() {
        View convertView = View.inflate(UiUtils.getContext(), R.layout.fragment_lose_weight, null);
        imageView = (ImageView) convertView.findViewById(R.id.knowledge_item_image);
        title = (TextView) convertView.findViewById(R.id.knowledge_item_text);
        comment = (TextView) convertView.findViewById(R.id.knowledge_item_comment);
        favourate = (TextView) convertView.findViewById(R.id.knowledge_item_favourate);
        reply = (TextView) convertView.findViewById(R.id.knowledge_item_reply);
        return convertView;
    }

    @Override
    public void refreshView(QueetionListInfo.ResultEntity data) {
        title.setText(data.getTitle());
        String string = data.toString();
        utils.display(imageView, data.getImg());
        reply.setText(data.getRcount() + "回复");
        comment.setText(data.getCount() + "人看过");
        favourate.setText(data.getFcount() + "收藏");
    }

}
