package com.example.hanlu.healthyadvisor.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.hanlu.healthyadvisor.bean.QueetionListInfo;
import com.example.hanlu.healthyadvisor.holder.BaseHolder;
import com.example.hanlu.healthyadvisor.holder.MoreHolder;
import com.example.hanlu.healthyadvisor.utils.Constant;
import com.example.hanlu.healthyadvisor.utils.UiUtils;

import java.util.List;

/**
 * Created by hanlu on 2016/3/6.
 */
public abstract class DefaultAdapter<T> extends BaseAdapter implements AdapterView.OnItemClickListener {
    public static final int NORMAL_TYPE = 1;
    public static final int MORE_TYPE = 0;
    private static final String TAG = "tag";
    private ListView listView;
    List<T> data;
    private MoreHolder moreHolder;

    public DefaultAdapter(List<T> data, ListView listView) {
        this.listView = listView;
        listView.setOnItemClickListener(this);
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.size()+1 ;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getCount() - 1) {
            return MORE_TYPE;
        } else {
            return NORMAL_TYPE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder holder;
        if (convertView == null) {
            if (getItemViewType(position) == MORE_TYPE) {
                holder = getMoreHolder();
            } else {
                holder = getHolder();
            }
        } else {
            holder = (BaseHolder) convertView.getTag();
        }
        if (getItemViewType(position) == MORE_TYPE) {
            //判断数据还有木有
            if (hasMore()) {
                perfomMoreData();
            } else {
                holder.setData(MoreHolder.HAS_MORE_EMPTY);
            }
        } else {
            T t = data.get(position);
            holder.setData(t);
        }



        return holder.getContentView();
    }

    private void perfomMoreData() {
        new Thread() {
            int state = MoreHolder.HAS_MORE;

            @Override
            public void run() {

                final List<T> moreDatas = LoadMore();

                if (moreDatas==null){
                    state=MoreHolder.HAS_MORE_ERROR;
                }
                else if (moreDatas.size() == 0) {
                    state = MoreHolder.HAS_NO_MORE;
                } else if (moreDatas.size() < Constant.ROW_COUNTS) {
                    state = MoreHolder.HAS_NO_MORE;
                } else {
                    state = MoreHolder.HAS_MORE;
                    UiUtils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            moreHolder.setData(state);
                            data.addAll(moreDatas);
                            notifyDataSetChanged();

                        }
                    });
                }
            }
        }.start();

    }

    protected List<T>       LoadMore() {
        return null;
    }


    private BaseHolder getMoreHolder() {
        moreHolder = new MoreHolder();
        return moreHolder;
    }

    protected boolean hasMore() {
        return true;
    }

    protected abstract BaseHolder getHolder();

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        position = position - listView.getHeaderViewsCount();
        OnListItemClick(position);
    }

    protected abstract void OnListItemClick(int position);
}
