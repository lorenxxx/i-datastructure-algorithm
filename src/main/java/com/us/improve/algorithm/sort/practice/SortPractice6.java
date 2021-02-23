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
		if (arr == null || arr.length <= 1)
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
		if (arr == null || arr.length <= 1)
		{
			return;
		}

		for (int i = 1; i < arr.length; i++)
		{
			int insertValue = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > insertValue)
			{
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = insertValue;
		}
	}

	@Override
	public void shellSort(int[] arr)
	{
		if (arr == null || arr.length <= 1)
		{
			return;
		}

		for (int step = arr.length / 2; step >= 1 ; step /= 2)
		{
			for (int i = step; i < arr.length; i++)
			{
				int insertValue = arr[i];
				int j = i - step;
				while (j >= 0 && arr[j] > insertValue)
				{
					arr[j + step] = arr[j];
					j -= step;
				}

				arr[j + step] = insertValue;
			}
		}
	}

	@Override
	public void selectSort(int[] arr)
	{
		if (arr == null || arr.length <= 1)
		{
			return;
		}

		for (int i = 0; i < arr.length; i++)
		{
			int min = i;
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[j] < arr[min])
				{
					min = j;
				}
			}

			if (i != min)
			{
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
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
