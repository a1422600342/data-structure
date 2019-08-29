# data-structure
##  数据结构Java版  
###  练习、学习demo案例、笔记

###  稀疏数组  
> 1.矩阵压缩(cn.nit.datastructure.queue.QueueDemo)  
> 2.作用：实现数据压缩  
> 3.基础转换形式：[m][n] => [存储非0数值个数][3]  
> 4.[row,col,data] 第一行记录整个二维数组的信息（共多少行，列，非零元素），其余行记录二维数组的非零元素所在行，列，元素值  

###  队列  
>特点：先进先出(FIFO)  

>1.数组实现（cn.nit.datastructure.sparsearray.SparseArrayDemo）    
>> 1.1初始版本  
>> 1.2单循环（环形）队列实现优化  
>>
>> >  目的/作用：希望数组队列空间能够重复利用   

>2.链表实现  

###  链表  
>1.创建、删除、修改、查找  
>2.排序  
>3.约瑟夫圆环  

###  栈  
>1.波兰表达式、逆波兰表达式  
>2.中缀表达式转后缀表达式  

###  递归  
>1.迷宫回溯（求最短路径）  
>2.八皇后    
>> 应用：  
>>> 1.算法类：快排、归并、二分查找、分治  
>>> 2.数学问题：汉诺塔、八皇后问题、阶乘、迷宫问题、球和篮子问题  

>3.tips: 递归调用时，递归参数需要不断趋向于退出递归的条件，避免无限递归。例如：错误案例：if(n<1) f(n+1)；正确案例：if(n<1) f(n-1)  

### 排序  
#### 一、度量执行时间：

##### 事后统计法（运行程序的时间差）、事前估算法（时间复杂度）

#### 二、分类：  
>1.内部排序（使用内存）  
>> 1.1 插入排序  
>> > 1.1.1 直接插入排序  
>> >
>> > ```java
>> > /*基本思想： 
>> >  * 把n个待排序的元素看作一个有序表和一个无序表，开始时有序表只有1个元素
>> >  *（可以是待排序序列的第一个元素），无序表有n-1个元素，排序过程中，
>> >  * 每从无序表中取出1个元素，就将其依次与有序表中的元素进行比较，
>> >  * 并将这个元素插入到适当的位置，从而不断增长有序表，
>> >  * 直到无序表中没有元素，则排序完毕。
>> >  * 例如：待排序序列为：4536251
>> >  * 第一趟：[4][536251]
>> >  * 第二趟：[45][36251]
>> >  * 第三趟：[45][56251]
>> >  * [44][56251]
>> >  * [345][6251]
>> >  * 第四趟：[3456][251]
>> >  * 第五趟：[3456][651]
>> >  * [3455][651]
>> >  * [3445][651]
>> >  * [3345][651]
>> >  * [23456][51]
>> >  * 第六趟：[23456][61]
>> >  * [234556][1]
>> >  * 第七趟：[234556][6]
>> >  * [234555][6]
>> >  * [234555][6]
>> >  * [234455][6]
>> >  * [233455][6]
>> >  * [223455][6]
>> >  * [1234556]
>> >  */
>> > ```
>> >
>> > 1.1.2 希尔排序 
>> >
>> > ```java
>> > /*基本思想：
>> >  * 分组（增量=组数=length/2）+直接插入排序，当增量为1时，进行最后一次直接插入排序。
>> >  * 实现：交换法（效率较低，易理解），移动法（效率较高，难理解）
>> >  */
>> > ```
>> >
>> > 

>> 1.2 选择排序  
>>
>> > 1.2.1 简单选择排序  
>> >
>> > ```java
>> > /*基本思想： 
>> >  * 1.从arr[0]-arr[n-1]中选取最小值，与arr[0]交换
>> >  * 2.从arr[1]-ayy[n-1]中选取最小值，与arr[1]交换
>> >  * .....共通过n-1次，得到一个从小到大的有序序列。
>> >  */
>> > ```
>> >
>> > 1.2.2 堆排序 

>> 1.3 交换排序  
>> > 1.3.1 冒泡排序  
>> >
>> > ```java
>> > /*基本思想：
>> >  * 通过对 待排序的序列从前向后依次比较相邻元素的值，若两者为逆序，则交换。
>> >  *（保证使值较大的元素逐渐从前向后移）
>> >  */
>> > ```
>> >
>> > 1.3.2 快速排序
>> >
>> > ```java
>> > /*基本思想：分组+递归+交换
>> >  * 选择一个元素作为基准轴，通过一趟排序将待排序序列分为两组，左边比轴小，右边比轴大，
>> >  * 左边继续选择一个元素作为基准轴，通过一趟排序将左边序列分为两组，右边同理，
>> >  * 递归直到待排序序列元素为1个时/（直到待排序序列元素为2个时进行比较交换），
>> >  * 排序完毕。
>> >  * tip:合理选择基准轴可以提高效率
>> >  */
>> > ```
>> >
>> > 

>> 1.4 归并排序  

>> 1.5 基数排序(桶排序的一种拓展)  

> 2.外部排序（使用内存和外存结合）  

#### 三、比较  

| 排序算法 | 平均时间复杂度 | 最差时间复杂度 | 稳定性 | 额外空间 | 备注                         |
| -------- | -------------- | -------------- | ------ | -------- | ---------------------------- |
| 冒泡     | O(n^2)         | O(n^2)         | 稳定   | O(1)     | n较小时较好                  |
| 交换     | O(n^2)         | O(n^2)         | 不稳定 | O(1)     | n较小时较好                  |
| 选择     | O(n^2)         | O(n^2)         | 不稳定 | O(1)     | n较小时较好                  |
| 插入     | O(n^2)         | O(n^2)         | 稳定   | O(1)     | 大部分已排序时较好           |
| 基数     | O(logR(B))     | O(logR(B))     | 稳定   | O(n)     | B为真数(0-9),R是基数(个十百) |
| 希尔     | O(nlogn)       | O(n^s)  1<s<2  | 不稳定 | O(1)     | s是所选分组                  |
| 快速     | O(nlogn)       | O(n^2)         | 不稳定 | O(nlogn) | n较大时较好                  |
| 归并     | O(nlogn)       | O(nlogn)       | 稳定   | O(1)     | n较大时较好                  |
| 堆       | O(nlogn)       | O(nlogn)       | 不稳定 | O(1)     | n较大时较好                  |

  常见时间复杂度由小到大为：

O(1) < O(log2(n)) < O(n) < O(nlog2(n)) < O(n^2) < O(n^3) < O(n^k) < O(2^n)  


### 查找  

### 哈希表  

### 树  

### 图  

### 分治算法  

### 动态规划  

### 贪心算法  

### Prim算法  

### Kruskal算法  

### Dijkstra算法  

### Floyd算法  

### 案例：骑士周游问题    
