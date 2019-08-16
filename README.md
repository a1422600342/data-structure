# data-structure
##  数据结构Java版  

###  稀疏数组  
> (cn.nit.datastructure.queue.QueueDemo)  
> 作用：实现数据压缩  
> 基础转换形式：[m][n] => [存储非0数值个数][3]  
> row,col,data 第一行记录整个二维数组的信息（共多少行，列，非零元素），其余行记录二维数组的非零元素所在行，列，元素值 

###  队列  
>特点：先进先出(FIFO)
   
>1.数组实现（cn.nit.datastructure.sparsearray.SparseArrayDemo）  
>> 1.1初始版本  
>> 1.2单循环（环形）队列实现优化  
>>>  目的/作用：希望数组队列空间能够重复利用   

>2.链表实现  

###  链表  
>1.创建、删除、修改、查找  
>2.排序
