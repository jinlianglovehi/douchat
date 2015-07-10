package com.doudou.chat.adapter.base;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author jinliang
 * @param <T>
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
	
    protected List<T> list;
    protected Context context;
    
    public void addData(List<T> moreList){
    	list.addAll(moreList);
    	this.notifyDataSetChanged();
    }
	public MyBaseAdapter(Context context,List<T> list) {
		super();
		this.list = list;
		this.context =context;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public  abstract View getView(int position, View convertView, ViewGroup parent) ;
	

}
