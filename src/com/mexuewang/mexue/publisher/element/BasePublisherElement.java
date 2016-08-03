package com.mexuewang.mexue.publisher.element;

import java.io.StringReader;
import java.util.Map;

import android.content.Context;
import android.os.Bundle;

import com.android.http.RequestManager;
import com.android.http.RequestManager.RequestListener;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mexuewang.mexue.model.sendData.GrowthData;
import com.mexuewang.mexue.publisher.listener.ElementEventListener;
import com.mexuewang.mexue.util.JsonValidator;

/**
 * @author luohao created by 08/01/2016
 * function:the base class of all elements.this was able to extract some common logical fragement
 * 
 */
public abstract class BasePublisherElement implements PublisherElement {
	private GrowthData mGrowthData;
	protected RequestManager mRquestManager;
	protected ElementEventListener mElementEventListener;
	protected PublisherRequestListener mPublisherRequestListener = new PublisherRequestListener();
	protected Context mContext;

	public void init(Context context) {
		this.mContext = context;
		if (null == mRquestManager) {
			mRquestManager = RequestManager.getInstance();
		}
	}

	public GrowthData getmGrowthData() {
		return mGrowthData;
	}

	public void setmGrowthData(GrowthData mGrowthData) {
		this.mGrowthData = mGrowthData;
	}

	/**
     * 
     */
	public void excuteAction() {

	}

	/**
     * 
     */
	public void creat() {

	}

	/**
     * 
     */
	public void update() {
	}

	protected void updata(Bundle bundle) {

	}

	/**
	 * @param bundle
	 */
	/**
	 * aaaaaa
	 */
	public void remove() {

	}

	/*
	 * function :add a listener of an operable even for element
	 */
	@Override
	public final void addElementEventListener(Context context,
			ElementEventListener elementEventListener) {
		this.mContext = context;
		this.mElementEventListener = elementEventListener;
	}

	private class PublisherRequestListener implements RequestListener {
		private Gson gson = new Gson();
		private JsonReader jsonReader;

		@Override
		public void onRequest() {

		}

		@Override
		public void onSuccess(String response, Map<String, String> headers,
				String url, int actionId) {
			JsonValidator jsonVal = new JsonValidator();
			boolean isJson = jsonVal.validate(response);
			if (!isJson) {
				return;
			}
			// to do “≈¡ÙŒ Ã‚£ø£ø£ø
			// if (ReqUiifQu.isGradeUping(response, mContext)) {
			// ShowDialog.dismissDialog();
			// return;
			// }
			jsonReader = new JsonReader(new StringReader(response));
			responseSuccess(gson, jsonReader);
		}

		@Override
		public void onError(String errorMsg, String url, int actionId) {

		}

	}

	protected void responseSuccess(Gson gson, JsonReader jsonReader) {

	}

	protected void responseError() {

	}
}
