package com.example.yk.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yk.R;
import com.example.yk.bean.HomeBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 李倩 on 2017/11/23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    List<HomeBean.RetBean.ListBean.ChildListBean> list;
    OnItemClickListener listener;
    //设置Item点击监听
    public  void  setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
    public MyAdapter(Context context, List<HomeBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recy_item, null);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onItemClick((Integer) view.getTag());
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(list.get(position).getPic()))
                .build();
        holder.sm.setController(controller);
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sm)
        SimpleDraweeView sm;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public  interface  OnItemClickListener{
        public  void onItemClick(int position);
    }

}
