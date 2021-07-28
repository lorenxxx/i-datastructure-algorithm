package com.us.improve.leetcode.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author loren
 * @Description 双向链表节点
 * @Date 2021-07-20 23:15
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DNode {

	private int data;

	private DNode prev;

	private DNode next;

	public DNode(int data) {
		this(data, null, null);
	}

}
