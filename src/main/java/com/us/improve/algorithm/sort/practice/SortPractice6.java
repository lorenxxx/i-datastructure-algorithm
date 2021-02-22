package com.us.improve.algorithm.sort.practice;

import com.us.improve.algorithm.sort.ISort;

/**
 * @Author loren
 * @Description 排序练习
 * @Date 2021-02-22 18:34
 * @Version 1.0
 **/
public class SortPractice6 implements ISort
{

	@Override
	public void bubbleSort(int[] arr)
	{
		if (arr == null || arr.length == 0)
		{
			return;
		}

		for (int i = 0; i < arr.length; i++)
		{
			boolean flag = false;
			for (int j = 0; j < arr.length - i - 1; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;

					flag = true;
				}
			}

			if (!flag)
			{
				break;
			}
		}
	}

	@Override
	public void insertSort(int[] arr)
	{

	}

	@Override
	public void shellSort(int[] arr)
	{

	}

	@Override
	public void selectSort(int[] arr)
	{

	}

	@Override
	public void mergeSort(int[] arr)
	{

	}

	@Override
	public void quickSort(int[] arr)
	{

	}
}
