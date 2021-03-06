# 贪心算法 Greedy Algorithm

## 问题特征
针对一组数据，我们定义了限制值和期望值，希望从中选出几个数据，在满足限制值的条件下，期望值最大

## 解决问题的步骤
1. 当我们看到这类问题的时候，首先要联想到贪心算法 
2. 我们尝试去看一下这个问题能否用贪心算法解决（每次选择当前情况下在对限制值同等贡献量的条件下，对期望值贡献最大的数据）
3. 我们举几个例子看一下贪心算法产生的结果是否是最优的

> 用贪心算法解决问题的思路，并不总能给出最优解 

## 贪心算法不能解决哪些问题？
前面的选择，会影响后面的选择

## 应用举例
- 霍夫曼编码 Huffman Coding
- Prim和Kruskal最小生成树算法
- Dijkstra单源最短路径算法