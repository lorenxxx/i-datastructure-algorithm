package com.us.improve.leetcode.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author loren
 * @Description 链表节点
 * @Date 2020-12-31 11:26
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Node<T>
{

	private T data;

	private Node<T> next;

	public void display()
	{
		StringBuilder sb = new StringBuilder();

		Node<T> cur = this;
		while (cur != null)
		{
			sb.append(cur.getData());
			sb.append("->");

			cur = cur.getNext();
		}

		sb.delete(sb.length() - 2, sb.length());

		System.out.println(sb.toString());
	}

}
