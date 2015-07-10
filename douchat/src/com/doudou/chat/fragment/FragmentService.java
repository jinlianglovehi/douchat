package com.doudou.chat.fragment;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.ListView;

import com.doudou.chat.R;
import com.doudou.chat.adapter.MyFriendAdapter;
import com.doudou.chat.model.DouUserInfo;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class FragmentService extends BaseFragment {
	
	/**
	 * 好友列表信息
	 */
	private String  preStr ="12345" ;
	
	@ViewInject(R.id.listview)
	private ListView listView;
	private MyFriendAdapter adapter;
	private List<DouUserInfo> list = new ArrayList<DouUserInfo>();
	@Override
	public View initView() {
		view =View.inflate(context, R.layout.fragment_service, null);
		ViewUtils.inject(this,view);
		return view;
	}
	@Override
	public void initData() {
		
	    adapter = new MyFriendAdapter(context, list);
	    listView.setAdapter(adapter);
		initFrendsData();
	}
	private void initFrendsData() {
	   DouUserInfo info ;
	   for(int i=0;i<15 ;i++){
		   info =new DouUserInfo();
		   info.setId(preStr + i);
		   info.setUsername("name_"+i);
		   list.add(info);
	   }
	   adapter.addData(list);
	}
}
