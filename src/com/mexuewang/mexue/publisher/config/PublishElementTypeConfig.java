package com.mexuewang.mexue.publisher.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luohao created on 08/03/2016 
 * functioin  The configuration of publisher type 
 * 
 */
public class PublishElementTypeConfig {
	private List<Integer> elementTypes = new ArrayList<Integer>();

	public PublishElementTypeConfig(int... elementTypes) {
		putElementTypes(elementTypes);
	}

	public void putElementTypes(int... types) {
		int length = types.length;
		for (int i = 0; i < length; i++) {
			elementTypes.add(types[i]);
		}
	}

	public List<Integer> getElementTypes() {
		return new ArrayList<Integer>(elementTypes);
	}
}
