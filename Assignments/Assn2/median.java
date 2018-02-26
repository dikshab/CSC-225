import java.util.Scanner;
import java.util.*;
import java.io.*;
public class median{
	static minHeap min;
	static maxHeap max;
	
	public median(){
		min = new minHeap();
		max = new maxHeap();
	}
	
	public static int calculateMedian(int x){
		//your code goes here
		if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
	
	}
	
	public static void main(String[] args){
		median m = new median();
		
		System.out.println("Enter a list of non negative integers. To end enter a negative integers.");
		Scanner s = new Scanner(System.in);
		int current = s.nextInt();

		while(current >=0){
			System.out.println("current median:" + m.calculateMedian(current));
			current = s.nextInt();
			if(current<0)break;
			m.calculateMedian(current);
			current = s.nextInt();
			
		}	
	}
}

class minHeap{
	private int[] heap;
	private int size;
	private int len;
	
	public minHeap(int size)
	{
		
		len = size+1;
		this.heap = new int [len]; 
		size = 0;
		heap[size] = 0;
	}
	public minHeap(){
		heap=new int[10000];
		size=0;
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public int size(){
		return size;
	}
	
	public void insert(int x){
		//Your code goes here
		
		if(size == len-1)
		{
			doubleArray();
			heap[++size] = x;
			bubbleup(size);
		}
		else
		{
			heap[++size] = x;
			bubbleup(size);
		}
		}


	
	public void bubbleup(int k){
		//Your code goes here
		
		while(k > 1 && heap[k/2] < heap[k]){
			
			exchange(k/2, k);
			k = k/2;
		}
		
	}
	public void exchange(int i,int j){
		//Your code goes here
		
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	public void bubbledown(int k){
		//Your code goes here
		
		while (2 * k <= size)
		{
			int j = 2 * k;
			if(j > size && (heap[j] > heap[j+1]))
			{
				j++;
			}
			if(heap[k] < heap[j])
			{
				break;
			}
			exchange(k, j);
			k = j;
		}
				
	}
	private void doubleArray() 
	{
		int [] temp = new int [size * 2]; 
		for (int i = 1 ; i<size ; i++){
			temp[i] = heap[i];
		}
		len = temp.length;
		heap = temp;
    }
	   
	
	public int peek(){
		//Your code goes here
		
		if(this.isEmpty()){
			throw new IllegalStateException();
		}
		
		return heap[1];
	}
	
	public int removeMin(){
		//Your code goes here
		
		if(size == 0)
		{
			return 0; //exit - heap is empty
		}
		
		else
		{
			int min = heap[1]; //get the root of the heap which is the min
			exchange(1, size--);
			bubbledown(1);
			return min;
		}
	}
}

class maxHeap{
	private int[] heap;
	private int size;
	private int len;
	
	public maxHeap(){
		len = size+1;
		heap=new int[10000];
		size=0;
		heap[size] = 0;
	}
	
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public int size(){
		return size;
	}
	
	public void insert(int x){
		//Your code goes here
		
		if(size == len-1)
		{
			doubleArray();
			heap[++size] = x;
			bubbleup(size);
		}
		else
		{
			heap[++size] = x;
			bubbleup(size);
		}
		}


	
	public void bubbleup(int k){
		//Your code goes here
		
		while(k > 1 && heap[k/2] > heap[k]){
			
			exchange(k/2, k);
			k = k/2;
		}
		
	}
	public void exchange(int i,int j){
		//Your code goes here
		
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	public void bubbledown(int k){
		//Your code goes here
		
		while (2 * k <= size)
		{
			int j = 2 * k;
			if(j < size && (heap[j] > heap[j+1]))
			{
				j++;
			}
			if(heap[k] < heap[j])
			{
				break;
			}
			exchange(k, j);
			k = j;
		}
				
	}
	private void doubleArray() 
	{
		int [] temp = new int [size * 2]; 
		for (int i = 1 ; i<size ; i++){
			temp[i] = heap[i];
		}
		len = temp.length;
		heap = temp;
    }
	   
	
	public int peek(){
		//Your code goes here
		
		if(this.isEmpty()){
			throw new IllegalStateException();
		}
		
		return heap[1];
	}
	
	public int removeMax(){
		//Your code goes here
		
		if(size == 0)
		{
			return 0; //exit - heap is empty
		}
		
		else
		{
			int max = heap[1]; //get the root of the heap which is the min
			exchange(1, size--);
			bubbledown(1);
			return max;
		}
	}
}
	

