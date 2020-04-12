package com.us.improve.leetcode.backtracking.package01;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Package01_2
 * @Desciption 0-1 背包：我们有一个背包，背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，且价值不等，并且不可分割。我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总价值最大？
 * @Author loren
 * @Date 2020/4/12 5:32 PM
 * @Version 1.0
 **/
public class Package01_2 {

    private int maxW = Integer.MIN_VALUE;

    private int maxV = Integer.MIN_VALUE;

    private List<Integer> list = new ArrayList<>();

    private List<Integer> result;

    /**
     * @param items            物品重量数组
     * @param values           物品价值数组
     * @param i                表示考察到第几个物品了
     * @param packageCurWeight 表示当前已经装进去的物品的重量总和
     * @param packageMaxWeight 背包可承受重量
     */
    public void addItem(int[] items, int[] values, int i, int packageCurWeight, int packageCurValue, int packageMaxWeight) {
        // 如果背包已经装满了，或者已经考察完所有物品
        if (packageCurWeight == packageMaxWeight || i == items.length) {
            if (packageCurWeight > maxW) {
                maxW = packageCurWeight;
            }
            if (packageCurValue > maxV) {
                maxV = packageCurValue;
                result = new ArrayList<>(list);
            }
            return;
        }

        // 我们可以把物品依次排列，整个问题就分解为了 n 个阶段，每个阶段对应一个物品怎么选择。先对第一个物品进行处理，选择装进去或者不装进去，然后再递归地处理剩下的物品。

        // 不装入当前物品
        addItem(items, values,i + 1, packageCurWeight, packageCurValue, packageMaxWeight);

        // 装入当前物品
        if (packageCurWeight + items[i] <= packageMaxWeight) {
            list.add(i);
            addItem(items, values,i + 1, packageCurWeight + items[i], packageCurValue + values[i], packageMaxWeight);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] items = new int[] {6, 2, 3, 4, 5};
        int[] values = new int[] {100, 2, 1, 4, 1};

        Package01_2 myPackage = new Package01_2();
        myPackage.addItem(items, values, 0, 0, 0,10);
        System.out.println(myPackage.maxW);
        System.out.println(myPackage.maxV);
        System.out.println(myPackage.result);
    }

}
