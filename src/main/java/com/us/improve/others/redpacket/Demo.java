package com.us.improve.others.redpacket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author loren
 * @Description https://mp.weixin.qq.com/s/qS-WOfFGcm1WLPjgkO2gaQ
 * @Date 2021-01-12 15:02
 * @Version 1.0
 **/
public class Demo
{

	public static void main(String[] args)
	{
		int money = 100;
		int people = 10;

		//List<Integer> packets = generatePacketsByLineCutting(people, money);
		List<Integer> packets = generatePacketsByDoubleMean(people, money);
		System.out.println(packets);
	}

	/**
	 * 二倍均值法
	 *
	 * @param people
	 * @param money
	 * @return
	 */
	public static List<Integer> generatePacketsByDoubleMean(int people, int money) {
		List<Integer> packets = new ArrayList<>();
		Random random = new Random();
		while (people > 1) {
			int p = random.nextInt(2 * money / people);
			packets.add(p);
			money -= p;
			people--;
		}
		packets.add(money);
		return packets;
	}

	/**
	 * 线段切割法
	 *
	 * @param people
	 * @param money
	 * @return
	 */
	public static List<Integer> generatePacketsByLineCutting(int people, int money) {
		List<Integer> packets = new ArrayList<>();
		Random random = new Random();
		Set<Integer> points = new TreeSet<>();
		while (points.size() < people - 1) {
			points.add(random.nextInt(money - 1));
		}
		points.add(money);
		int pre = 0;
		for (int p : points) {
			packets.add(p - pre);
			pre = p;
		}
		return packets;
	}

}
