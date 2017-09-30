package com.abhi.threads;

public class SumUsingThreads extends Thread {
	private int lo, hi;
	private int[] arr;
	private int ans = 0;
	
public SumUsingThreads(int lo, int hi, int[] arr) {
		super();
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
	}
@Override
public void run()
{
	for(int i=lo;i<hi;i++)
	{
		ans=ans+arr[i];
	}
}
public static int sum(int arr[])
{
	SumUsingThreads[] ts=new SumUsingThreads[4];
	
	int len=arr.length;
	int total=0;
	for(int i=0;i<4;i++)
	{
		ts[i]=new SumUsingThreads((i*len)/4,((i+1)*len)/4,arr);
		ts[i].start();
	}
	for(int i=0;i<4;i++)
	{
		try {
			ts[i].join();
			total+=ts[i].ans;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	return total;
	
}
public static void main(String[] args) {
	int[] arr = {2,5,4,23,45,65,76,32,81,4,5,6,98,43,63,21,91};
    int total = sum(arr);
    System.out.println("TotalSum: " +total);

}
}
