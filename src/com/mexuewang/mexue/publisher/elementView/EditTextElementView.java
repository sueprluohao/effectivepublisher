package com.mexuewang.mexue.publisher.elementView;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.mexuewang.mexue.R;
import com.mexuewang.mexue.publisher.element.EditTextElement;
/**
 * @author luohao created on 08/03/2016
 * functioin:the view of editbox for users input
 *
 */
public class EditTextElementView extends
		BasePublisherElementView<EditTextElement> {
	private EditText editText;
	private PublisherWatcher mPublisherWatcher;

	public EditTextElementView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public EditTextElementView(Context context) {
		super(context);
		initView();
	}

	private void initView() {
		LayoutInflater.from(getContext()).inflate(R.layout.publisher_editbox,
				this);
		editText = (EditText) findViewById(R.id.publisher_editbox);
		mPublisherWatcher = new PublisherWatcher();
		editText.addTextChangedListener(mPublisherWatcher);

	}

	private class PublisherWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable arg0) {

		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {

		}

		@Override
		public void onTextChanged(CharSequence charSequence, int arg1,
				int arg2, int arg3) {
			if (charSequence != null) {
				mPublishElement.setContent(charSequence.toString());
			}
		}
	}

	@Override
	protected void init() {

	}

}
