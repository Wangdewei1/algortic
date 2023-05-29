package com.itwang.queue;

import java.util.Arrays;

/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 * @author lenovo
 *
 */
public class ArrayQueue {
  private int maxSize; //数组的最大容量
  private int front; //队列头
  private int rear; //队列尾
  private int[] arr; //该数组用于存放数据
  
  //创建队列构造器
  public ArrayQueue(int arrMaxArray){
    maxSize = arrMaxArray;
    arr = new int[maxSize];
    front = -1; //指向队列头部
    rear = -1; 
  }
  
  //判断队列是否已经满了
  public boolean isFull(){
    return rear == maxSize - 1;
  }
  
  //判断队列是否为空
  public boolean isNull(){
    return front == rear;
  }
  
  //添加数据到队列
  public void addDataToQueue(int num){
    //判满
    if(isFull()){
      System.out.println("该队列已经满了");
      return;
    }
    
    arr[rear++] = num;
  
  }
  
  //获取队列的数据  ，出队列
  public int getQueue(){
    if (isNull()) {
      throw new RuntimeException("队列为空");
    }
    return arr[front++];
  }
  
  //显示队列的所有数据
  public void showAllQueue(){
    
    if(isNull()){
      System.out.println("数据为空");
    }
    for (int i = 0; i < arr.length; i++) {      
      System.out.printf("arr[%d]=%d\n",i,arr[i]);
    }
    System.out.println(Arrays.asList(arr));
  }
  
  //显示队列的头数据，注意不是取出数据
  public int headQueue(){
    if(isNull()){
      System.out.println("队列为空，不显示数据");
      throw new RuntimeException("");
    }
    return arr[front + 1];
  }
}