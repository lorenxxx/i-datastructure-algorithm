package com.us.improve.datastructure.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Node
 * @Desciption 节点
 * @Author loren
 * @Date 2020/3/22 1:43 PM
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Node {

    private int data;

    private Node left;

    private Node right;

    public Node(int data) {
        this(data, null, null);
    }

}
