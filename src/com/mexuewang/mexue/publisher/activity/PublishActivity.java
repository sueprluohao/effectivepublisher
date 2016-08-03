package com.mexuewang.mexue.publisher.activity;

import android.os.Bundle;

import com.mexuewang.mexue.R;
import com.mexuewang.mexue.publisher.elementView.EditTextElementView;
import com.mexuewang.mexue.publisher.elementView.PublishScopeElementView;
import com.mexuewang.mexue.publisher.PublisherConstants;
import com.mexuewang.mexue.publisher.element.PublisherElement;

/**
 * @author luohao created on 08/03/2016 
 * functioin the main frame of publisher
 * 
 */
public class PublishActivity extends BasePublisherActivity {
	private EditTextElementView editTextElementView;
	private PublishScopeElementView mPublishScopeElementView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.publisher_base_layout);
		initView();
	}

	private void initView() {
		editTextElementView = (EditTextElementView) findViewById(R.id.editText_elementView);
		PublisherElement publisherEditTextElement = mPublisherManager
				.getELement(PublisherConstants.ELEMENT_EDITTEXT);
		editTextElementView.bindElement(publisherEditTextElement);
		mPublishScopeElementView = (PublishScopeElementView) findViewById(R.id.publishscope_elementView);
		PublisherElement publisherScopeElement = mPublisherManager
				.getELement(PublisherConstants.ELEMENT_PUBLISH_SCOPE);
		mPublishScopeElementView.bindElement(publisherScopeElement);
	}
}
