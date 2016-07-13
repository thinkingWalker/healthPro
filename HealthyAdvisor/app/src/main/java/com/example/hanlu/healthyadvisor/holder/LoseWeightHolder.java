//package com.example.hanlu.healthyadvisor.holder;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.hanlu.healthyadvisor.R;
//import com.example.hanlu.healthyadvisor.bean.KnowledgeListInfo;
//import com.example.hanlu.healthyadvisor.utils.UiUtils;
//
///**
// * Created by hanlu on 2016/3/8.
// */
//public class LoseWeightHolder extends BaseHolder<KnowledgeListInfo.ResultEntity> {
//
//    private TextView title;
//    private TextView reply;
//    private TextView favourate;
//    private ImageView image;
//
//    @Override
//    public View initView() {
//        View view = View.inflate(UiUtils.getContext(), R.layout.fragment_lose_weight, null);
//        title = (TextView) view.findViewById(R.id.knowledge_item_text);
//        reply = (TextView) view.findViewById(R.id.knowledge_item_reply);
//        favourate = (TextView) view.findViewById(R.id.knowledge_item_favourate);
//        image = (ImageView) view.findViewById(R.id.knowledge_item_image);
//        return view;
//    }
//
//    @Override
//    public void refreshView(KnowledgeListInfo.ResultEntity data) {
//
//
//        title.setText(data.getTitle());
//        reply.setText(data.getCount() + "访问");
//        favourate.setText(data.getFcount() + "收藏");
//
//
//
//        utils.display(image, data.getImg());
//    }
//
//
//}
