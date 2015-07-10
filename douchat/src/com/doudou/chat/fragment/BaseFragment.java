package com.doudou.chat.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {
    protected View view;
    protected Context context;
    public BaseFragment() {
        super();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }
   @Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
	    view =initView();
		return view;
	}
    @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		//拿数据去填充UI
		initData();
		super.onActivityCreated(savedInstanceState);
	}
    //填充view数据
    public abstract View initView();
	//数据填充UI的方法
	public abstract void initData();
}
