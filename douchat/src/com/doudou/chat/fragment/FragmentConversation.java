package com.doudou.chat.fragment;

import com.doudou.chat.R;
import com.lidroid.xutils.ViewUtils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 会话列表
 * @author jinliang
 *
 */
public class FragmentConversation  extends BaseFragment{

	@Override
	public View initView() {
		view = View.inflate(context,R.layout.fragment_conversation, null);
		ViewUtils.inject(this, view);
		return view;
	}

	@Override
	public void initData() {
		
	}
	
	/*@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view  =inflater.inflate(R.layout.fragment_conversation, null);
		ViewUtils.inject(this, view);
		return view;
	}*/
	
	
	
}
