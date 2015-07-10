package com.doudou.chat.activity;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.doudou.chat.R;
import com.doudou.chat.activity.base.TitleActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class LoginActivity extends TitleActivity{
	
	//账号
	@ViewInject(R.id.et_username)
	private EditText et_username;
	
	//密码
	@ViewInject(R.id.et_password)
	private EditText et_password;
	
	//登陆按钮
    @ViewInject(R.id.btn_login)
	private Button loginBtn;
	
  
    
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ViewUtils.inject(this);
		initTitleBar();
		initFragment();
	}
	private void initFragment() {
		
	
		
	}
	private void initTitleBar() {
		setTitle(R.string.login);	
		showLeftView(0, false);
		showRightView(0, false);
	}
	@Override
	public void onClick(View v) {
		
	}

}
