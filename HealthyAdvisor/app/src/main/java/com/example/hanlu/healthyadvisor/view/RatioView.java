package com.example.hanlu.healthyadvisor.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hanlu.healthyadvisor.R;


/**
 * Created by hanlu on 2016/1/12.
 */
public class RatioView extends RelativeLayout {
    float ratio=2.43f;

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    int relative;//相对于宽度还是高度
    public static final int Relative_Width = 0;
    public static final int Relative_Height = 1;

    public void setRelative(int relative) {
        this.relative = relative;
    }

    public RatioView(Context context) {
        this(context, null);
    }

    public RatioView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        //第一种获得属性的方法，但是拿到的都是String如果有图片就麻烦了
////        String ratio = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "ratio");
////        this.ratio= Float.parseFloat(ratio);
//        //第二种用typearray
//        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RatioView);
//        float ratio = array.getFloat(0, 0);
//        int relative = array.getInt(R.styleable.RatioView_relative, Relative_Width);
//        this.relative = relative;
//        this.ratio = ratio;
        

    }

    /**
     * 父类有义务帮子类去测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //把宽度设置为高度的两倍，所以在测量的时候我们需要修改一下测量的策略

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(widthMeasureSpec);
        int width = widthSize - getPaddingLeft() - getPaddingRight();
        int height = heightSize - getPaddingTop() - getPaddingBottom();
        if (widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY && relative == Relative_Width) {
            height = (int) (width / ratio * 1f + 0.5f);//高为宽的一半
        } else if (heightMode == MeasureSpec.EXACTLY && widthMode != MeasureSpec.EXACTLY && relative == Relative_Height) {
            width = (int) (height * ratio * 1f);//宽为高的两倍
        }
        //重新给赋值
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(width+getPaddingLeft()+getPaddingRight(), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height+getPaddingBottom()+getPaddingTop(), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
