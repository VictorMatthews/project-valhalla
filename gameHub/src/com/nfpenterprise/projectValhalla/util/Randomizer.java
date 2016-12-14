package com.nfpenterprise.projectValhalla.util;

import java.util.List;

public class Randomizer {

	public static String randomItem(List<String> list) {
		Double randomIndex = Math.random() * list.size();
		return list.get(randomIndex.intValue());
	}

}
