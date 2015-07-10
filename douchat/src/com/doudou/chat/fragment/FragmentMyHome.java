package com.doudou.chat.fragment;

import com.doudou.chat.R;
import com.lidroid.xutils.ViewUtils;

import android.view.View;

public class FragmentMyHome extends BaseFragment {

	@Override
	public View initView() {
		view = View.inflate(context, R.layout.fragment_myhome, null);
		ViewUtils.inject(this,view);
		return view;
	}
	@Override
	public void initData() {
		
	}
    
}
