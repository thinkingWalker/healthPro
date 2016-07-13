package com.example.hanlu.healthyadvisor.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanlu.healthyadvisor.R;
import com.example.hanlu.healthyadvisor.bean.MedicineHouseInfo;
import com.example.hanlu.healthyadvisor.utils.UiUtils;

/**
 * Created by hanlu on 2016/3/8.
 */
public class MedicinHouseHolder extends BaseHolder<MedicineHouseInfo.ResultEntity> {

    private ImageView image;
    private TextView name;
    private TextView medicine;
    private TextView address;
    private TextView phone;

    @Override
    public View initView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.holder_medicine_house, null);
        image = (ImageView) view.findViewById(R.id.holder_house_item_image);
        name = (TextView) view.findViewById(R.id.holder_house_item_name);
        medicine = (TextView) view.findViewById(R.id.holder_house_item_medicine);
        address = (TextView) view.findViewById(R.id.holder_house_item_address);
        phone = (TextView) view.findViewById(R.id.holder_house_item_phone);


        return view;
    }

    @Override
    public void refreshView(final MedicineHouseInfo.ResultEntity data) {
        name.setText(data.getName());
        medicine.setText(data.getBusiness());
        if (data.getTel() == null) {
            phone.setText("暂时为空");
        } else {
            phone.setText(data.getTel());
        }
        address.setText(data.getAddress());
        utils.display(image, data.getImg());


    }
}
