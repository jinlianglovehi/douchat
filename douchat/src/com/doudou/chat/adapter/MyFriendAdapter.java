package com.doudou.chat.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.doudou.chat.R;
import com.doudou.chat.adapter.base.MyBaseAdapter;
import com.doudou.chat.adapter.base.ViewHolder;
import com.doudou.chat.model.DouUserInfo;


@SuppressWarnings("hiding")
public class MyFriendAdapter extends MyBaseAdapter<DouUserInfo>{

	public MyFriendAdapter(Context context, List<DouUserInfo> list) {
		super(context, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
			  R.layout.item_add_friend, parent, false);
		}
		DouUserInfo info  = list.get(position);
		TextView username = ViewHolder.get(convertView, R.id.tv_username);
		username.setText(info.getUsername());
		Button  btn_chat = ViewHolder.get(convertView,R.id.btn_chat);
		
		
		btn_chat.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				
				
				
				
				
			}
		});
		return convertView;
	}

	
	/*@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
			  R.layout.item_add_friend, parent, false);
		}
		DouUserInfo info  = list.get(position);
		TextView username = ViewHolder.get(convertView, R.id.user_name);
		Button button = ViewHolder.get(convertView,R.id.addFriend);
		return convertView;
	}*/

}
