package com.us.improve.leetcode.linkedlist;

/**
 * @Author loren
 * @Description 两数相加
 * @Date 2020-12-31 11:25
 * @Version 1.0
 **/
public class AddTwoNumbers
{

	public static void main(String[] args)
	{
		Node<Integer> n1 = new Node(4, new Node(5, new Node(9, new Node(1, null))));
		Node<Integer> n2 = new Node(4, new Node(6, new Node(3, null)));

		n1.display();
		n2.display();

		Node n = process(n1, n2);
		n.display();
	}

	public static Node<Integer> process(Node<Integer> n1, Node<Integer> n2)
	{
		if (n1 == null)
		{
			return n2;
		}

		if (n2 == null)
		{
			return n1;
		}

		Node<Integer> head = null;
		Node<Integer> tail = null;
		Integer carry = 0;

		Node<Integer> h1 = n1;
		Node<Integer> h2 = n2;
		while (h1 != null || h2 != null)
		{
			Integer num1 = h1 != null ? h1.getData() : 0;
			Integer num2 = h2 != null ? h2.getData() : 0;

			Integer sum = num1 + num2 + carry;
			carry = sum >= 10 ? 1 : 0;

			if (head == null)
			{
				tail = new Node<>(sum % 10, null);
				head = tail;
			} else
			{
				tail.setNext(new Node<>(sum % 10, null));
				tail = tail.getNext();
			}

			if (h1 != null)
			{
				h1 = h1.getNext();
			}

			if (h2 != null)
			{
				h2 = h2.getNext();
			}
		}

		return head;
	}

}
