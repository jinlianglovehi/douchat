package com.doudou.chat.application;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient.ConnectCallback;
import io.rong.imlib.RongIMClient.ErrorCode;
import android.app.Application;

public class MyApplication extends Application {
	
	/**
	 * 
	 * {"code":200,"userId":"12345","token":"8fIa7aUVzjp0iQGfw/D/5hFKdiLs8asKAzyltonKbgbxFcZ4tqeOrWk/0x1SwIboEd2+vHZW38Icryn5FuvZKQ=="}
	 * name:小冰;
	 * 头像信息
	 * portraitUri:http://img0.bdstatic.com/img/image/shouye/chongwu0703.jpg
	 */
	private String token ="8fIa7aUVzjp0iQGfw/D/5hFKdiLs8asKAzyltonKbgbxFcZ4tqeOrWk/0x1SwIboEd2+vHZW38Icryn5FuvZKQ==";
	@Override
	public void onCreate() {
		super.onCreate();
		RongIM.init(this);
		
		RongIM.connect(token, new ConnectCallback() {
			@Override
			public void onSuccess(String arg0) {
			}
			@Override
			public void onError(ErrorCode arg0) {
				
			}
			@Override
			public void onTokenIncorrect() {
				
			}
		});
	}
}
