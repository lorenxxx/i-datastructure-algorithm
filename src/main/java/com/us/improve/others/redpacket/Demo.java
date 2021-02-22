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

		//String str = "https://open.work.weixin.qq.com/wwopen/mpnews?mixuin=0MkbCAAABwAXYNG2AAAUAA&mfid=WW0314-ozWHZQAABwCz7RRuXFfrMQgaqIx51&idx=0&sn=9e1c22d9d84d4be3f3e66d5a46342619&auth=1&code=nZJcYe1VL33OVMTeS0iRQ4fyd4buR6N9e9Mi6GvLZhM&state=";
		String str = "https://open.work.weixin.qq.com/wwopen/mpnews?mixuin=0MkbCAAABwAXYNG2AAAUAA&mfid=WW0314-ozWHZQAABwCz7RRuXFfrMQgaqIx51&idx=0&sn=9e1c22d9d84d4be3f3e66d5a46342619&auth=1&code=nZJcYe1VL33OVMTeS0iRQ4fyd4buR6N9e9Mi6GvLZhM&state=&st=F3EEBE0DC34B9E258187011B0D5CF6399F0328FF67D5312F1199AC55F6197D6B9D3BCFEAD6A39E5009943970FCF700D6E1E1D8819E9A5633D1AAA50AE813193728D559E5954F6C6948DECA01497D1CB02CEBBEB28CB6BBA38D15D6E6CF5B3812D86CC68DFDF7654BC849CFB3C5623F6AAACDFC624DFDA072B368577F44A224155154A4411D4B4545601923C1A19AD573C803FC86C43B7FDB4EBF41EED8488F08&vid=1688853849614256&cst=73B54AB563A7ACA777AABCE1601022CF15B978C233102EB27900BB68BE9C3C25055FF93081C78ADC42FD1E13C0D6348D&deviceid=bc73ccdf-af85-4d25-ba3d-7a9fae4de724&version=3.0.40.2346&platform=mac";

		System.out.println(str.length());
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
