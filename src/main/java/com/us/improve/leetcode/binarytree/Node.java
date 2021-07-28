package com.us.improve.leetcode.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TreeNode
 * @Desciption 二叉树节点
 * @Author loren
 * @Date 2020/4/8 3:59 PM
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Node {

    public int data;

    public Node left;

    public Node right;

    public Node(int data) {
        this(data, null, null);
    }

}
