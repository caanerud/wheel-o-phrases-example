package com.joshobrian.main;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by josh on 4/6/17.
 */
public class Wheel {
	private List<Integer> wheelAmounts = Arrays.asList(0,100,100,100,100,300,300,300,500,800,1000);
	private Random random = new Random();

	public Integer spin(){
		return wheelAmounts.get(random.nextInt(wheelAmounts.size()));
	}
}
