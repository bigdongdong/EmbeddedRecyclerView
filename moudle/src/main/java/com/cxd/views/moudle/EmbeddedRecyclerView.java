package com.cxd.views.moudle;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * @author CXD
 * @project baseDemo2
 * @date :2019/5/23 0023 13:41
 * @description:
 *
 * 用于内嵌在ScrollView中的recyclerView
 * 通过组合view的方式，将relativeLayout与recyclerView结合使用
 */
public class EmbeddedRecyclerView extends RelativeLayout {
    private View view ;
    public RecyclerView recyclerView;

    public EmbeddedRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        view = LayoutInflater.from(context).inflate(R.layout.custom_embedded_recyclerview,this);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false ;
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
    }

    /**
     * 给view中的recyclerview设置adapter
     * @param adapter
     */
    public void setAdapter(RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }

    /**
     * 给view中的recyclerview配置间距decoration
     * @param decor
     */
    public void addItemDecoration(RecyclerView.ItemDecoration decor){
        recyclerView.addItemDecoration(decor);
    }
}
