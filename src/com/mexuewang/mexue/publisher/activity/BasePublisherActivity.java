package com.mexuewang.mexue.publisher.activity;

import android.os.Bundle;

import com.mexuewang.mexue.activity.BaseActivity;
import com.mexuewang.mexue.publisher.PublisherConstants;
import com.mexuewang.mexue.publisher.config.PublisherManagerConfig;
import com.mexuewang.mexue.publisher.listener.PublisherManagerListener;
import com.mexuewang.mexue.publisher.manager.PublisherManager;

/**
 * @author luohao created on 08/03/2016 
 * functioin:controller base class
 * 
 */
public abstract class BasePublisherActivity extends BaseActivity {
	protected PublisherManager mPublisherManager;
	protected PublisherController mPublisherController = new PublisherController();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int publisherType = getIntent().getIntExtra(
				PublisherConstants.PUBLISHER_TYPE_KEY, 0x8001);
		mPublisherManager = PublisherManagerConfig
				.getClassInstance(publisherType);
		if (mPublisherManager == null) {
			mPublisherManager = PublisherManagerConfig
					.getClassInstance(PublisherConstants.PUBLISHER_GROWTH);
		}
		mPublisherManager.addPublisherControllerListener(mPublisherController);
		mPublisherManager.init(publisherType, this.getApplicationContext());

	}

	private class PublisherController implements PublisherManagerListener {

		@Override
		public void init() {
		}

	}
}
