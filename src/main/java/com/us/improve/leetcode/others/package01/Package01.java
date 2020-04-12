package com.us.improve.leetcode.others.package01;

/**
 * @ClassName Package01
 * @Desciption 0-1 背包：我们有一个背包，背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 * @Author loren
 * @Date 2020/4/12 4:20 PM
 * @Version 1.0
 **/
public class Package01 {

    private int maxW = Integer.MIN_VALUE;

    /**
     * @param items            物品数组
     * @param i                表示考察到第几个物品了
     * @param packageCurWeight 表示当前已经装进去的物品的重量总和
     * @param packageMaxWeight 背包可承受重量
     */
    public void addItem(int[] items, int i, int packageCurWeight, int packageMaxWeight) {
        // 如果背包已经装满了，或者已经考察完所有物品
        if (packageCurWeight == packageMaxWeight || i == items.length) {
            if (packageCurWeight > maxW) {
                maxW = packageCurWeight;
            }
            return;
        }

        // 我们可以把物品依次排列，整个问题就分解为了 n 个阶段，每个阶段对应一个物品怎么选择。先对第一个物品进行处理，选择装进去或者不装进去，然后再递归地处理剩下的物品。

        // 不装入当前物品
        addItem(items, i + 1, packageCurWeight, packageMaxWeight);

        // 装入当前物品
        if (packageCurWeight + items[i] <= packageMaxWeight) {
            addItem(items, i + 1, packageCurWeight + items[i], packageMaxWeight);
        }
    }

    public static void main(String[] args) {
        int[] items = new int[]{1, 1, 5, 7, 9};
        Package01 package01 = new Package01();
        package01.addItem(items, 0, 0, 10);
        System.out.println(package01.maxW);
    }

}
