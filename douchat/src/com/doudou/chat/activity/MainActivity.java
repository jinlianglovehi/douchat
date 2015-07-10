package com.doudou.chat.activity;

import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imkit.widget.provider.CameraInputProvider;
import io.rong.imkit.widget.provider.ImageInputProvider;
import io.rong.imkit.widget.provider.InputProvider;
import io.rong.imkit.widget.provider.LocationInputProvider;
import io.rong.imkit.widget.provider.VoIPInputProvider;
import io.rong.imlib.model.Conversation;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doudou.chat.R;
import com.doudou.chat.activity.base.TitleActivity;
import com.doudou.chat.adapter.MyFragmentAdapter;
import com.doudou.chat.fragment.FragmentConversation;
import com.doudou.chat.fragment.FragmentFriends;
import com.doudou.chat.fragment.FragmentMyHome;
import com.doudou.chat.fragment.FragmentService;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @author jinliang
 */
public class MainActivity extends TitleActivity {
	
	//下部板块的内容
    @ViewInject(R.id.title_category_model)
	private LinearLayout title_category_model;
    private List<Fragment> listFragment;
    //会话fragment
    private FragmentConversation fragmentConversation;
    //好友列表
    private FragmentFriends fragmentFriends;
    //服务fragment
    private FragmentService fragmentService;
    private FragmentMyHome  fragmentMyHome;
    private MyFragmentAdapter  adapter;
    
    //融云自带的fragment界面
    private  ConversationListFragment conversationListFragment;
    
    //融云自带的会话fragment
    private  ConversationFragment conversationFragment;
    
    
    //viewPager
    /*@ViewInject(R.id.vp_content)
    private  ViewPager vp_content;*/
    
    
    @ViewInject(R.id.liaotian)
    private TextView liaotian;
    @ViewInject(R.id.haoyou)
    private TextView haoyou;
    @ViewInject(R.id.fuwu)
    private TextView fuwu; 
    
    @ViewInject(R.id.myhome)
    private  TextView myhome;
    private int  size =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		initTitleBar();
		initFragment();
		//initInputPrivider(); // 拓展聊天功能区域
		initOther();
		initListener();
	}
	@Override
	protected void onResume() {
		super.onResume();
		
		
		
	}
	private void initListener() {
		liaotian.setOnClickListener(this);
		haoyou.setOnClickListener(this);
		fuwu.setOnClickListener(this);
		myhome.setOnClickListener(this);
	}
	private void initOther() {
	   // adapter =new MyFragmentAdapter(getSupportFragmentManager(),listFragment);
	  /*  vp_content.setAdapter(adapter);
	    vp_content.setOnPageChangeListener(new MyViewPagerChanger());*/
	    selectText(0);
	   // vp_content.setCurrentItem(0);
	    replaceFragment(0);
	}
	
	/**
	 *自定义会话拓展功能区
	 */
	private void initInputPrivider(){
		InputProvider.ExtendProvider[] provider = {
				  new ImageInputProvider(RongContext.getInstance()),//图片
				  new CameraInputProvider(RongContext.getInstance()),//相机
				  new LocationInputProvider(RongContext.getInstance()),//地理位置
				  new VoIPInputProvider(RongContext.getInstance())// 语音通话
				};
       RongIM.getInstance().resetInputExtensionProvider(Conversation.ConversationType.PRIVATE, provider);
	}
	private void initFragment() {
		
		if(listFragment==null){
			listFragment =new ArrayList<Fragment>();
		}
		
		/**
		 * 会话列表
		 */
		
		conversationListFragment = new ConversationListFragment();
	    Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
	            .appendPath("conversationlist")
	            .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示
	            .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")
	            .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")
	            .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")
	            .build();
	    conversationListFragment.setUri(uri);

	    /**
	     * 会话界面
	     */
	    conversationFragment = new ConversationFragment();

	    Uri uri2 = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
	          .appendPath("conversation").appendPath(io.rong.imlib.model.Conversation.ConversationType.PRIVATE.getName().toLowerCase())
	          .appendQueryParameter("targetId", "12345").appendQueryParameter("title", "hello").build();
	    conversationFragment.setUri(uri2);

		/*fragmentConversation = new FragmentConversation();
		fragmentFriends = new FragmentFriends();*/
		fragmentService = new FragmentService();
		fragmentMyHome  = new FragmentMyHome();
		
		listFragment.add(conversationListFragment);
		listFragment.add(fragmentService);
		//listFragment.add(fragmentConversation);
		//listFragment.add(fragmentFriends);
		listFragment.add(fragmentService);
		listFragment.add(fragmentMyHome);
		
	}
	private void initTitleBar() {
		setTitle(R.string.douliao);	
		showLeftView(0, false);
		showRightView(0, false);
	}

   public void replaceFragment(int index){
	    getSupportFragmentManager().beginTransaction()
        .replace(R.id.fragment_content,listFragment.get(index)).addToBackStack(null).commit();
   }
	
	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case R.id.liaotian:
			//vp_content.setCurrentItem(0);
		    replaceFragment(0);
			selectText(0);
			break;
		case R.id.haoyou:
			//vp_content.setCurrentItem(1);
			 replaceFragment(1);
			selectText(1);
			break;
		case R.id.fuwu:
		//	vp_content.setCurrentItem(2);
			 replaceFragment(2);
			selectText(2);
			break;
		case R.id.myhome:
		//	vp_content.setCurrentItem(3);
			 replaceFragment(3);
			selectText(3);
			break;
		default:
			break;
		}
		
	}
	
	public class MyViewPagerChanger implements OnPageChangeListener{
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}
		/**
		 * 选中状态
		 */
		@Override
		public void onPageSelected(int position) {
			  replaceFragment(position);
			 // vp_content.setCurrentItem(position);
			 selectText(position);
		}
	}
	private void selectText(int position) {
		 size = title_category_model.getChildCount();
		 for(int i=0;i<size;i++){
			 if(i==position){
				 title_category_model.getChildAt(i).setSelected(true);
			 }else {
				 title_category_model.getChildAt(i).setSelected(false);
			 }
			 
		 }
	}
}
