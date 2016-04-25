package com.xtpl.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	final String TAG = "MainActivity";
	ListView mListView;

	List<String> mlist = new ArrayList<String>();
	Toast mToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mToast = Toast.makeText(this, "", 0);
		mListView = (ListView) findViewById(R.id.mListView);
		add(10);
		mListView.setAdapter(mAdapter);
		mListView.addHeaderView(LayoutInflater.from(this).inflate(R.layout.listview_header, null), null, false);
		mListView.addFooterView(LayoutInflater.from(this).inflate(R.layout.listview_footer, null), null, false);
		// mListView
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mToast.setText(mlist.get(position - 1));
				mToast.show();
			}
		});

		mListView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				Log.e(TAG, " onScrollStateChanged(AbsListView view, int " + scrollState + ")");
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				Log.e(TAG, "onScroll(AbsListView view, int " + firstVisibleItem + ", int " + visibleItemCount + ", int " + totalItemCount + ")");
			}
		});
	}

	void add(int data) {
		for (int i = 0; i < data; i++) {
			mlist.add(mlist.size() + " " + i);
		}
	}

	BaseAdapter mAdapter = new BaseAdapter() {

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item, null);
			}

			((TextView) convertView).setText((String) getItem(position));
			return convertView;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mlist.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mlist.size();
		}
	};
}
