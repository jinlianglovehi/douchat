package com.doudou.chat.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * fragmen viewPager
 * @author jinliang
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {

	private List<Fragment> list = new ArrayList<Fragment>();
	
	public MyFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	public MyFragmentAdapter(FragmentManager fm, List<Fragment> list) {
		super(fm);
		this.list = list;
	}

	@Override
	public Fragment getItem(int position) {
		return list.get(position);
	}

	@Override
	public int getCount() {
		return list.size();
	}

}
