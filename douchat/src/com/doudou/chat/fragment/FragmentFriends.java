package com.doudou.chat.fragment;

import android.view.View;

import com.doudou.chat.R;
import com.lidroid.xutils.ViewUtils;

/**
 * 好友列表
 * @author jinliang
 *
 */
public class FragmentFriends extends BaseFragment {
	private View view;
	@Override
	public View initView() {
		view =View.inflate(context,R.layout.fragment_friends, null);
		ViewUtils.inject(this,view);
    	return view;
	}

	@Override
	public void initData() {
		
	}
}
