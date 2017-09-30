package com.abhi.threads;


public class MaxValueUsingThreads extends Thread{
	
	private int lo;
	private int hi;
	private int[]arr;
	private int ans=0;
	public MaxValueUsingThreads(int lo, int hi, int[] arr) {
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
			if(arr[i]>=ans)
				ans=arr[i];
		}
	}
	public static int max(int[] arr) throws InterruptedException {
		int len = arr.length;
		int max = 0;
		MaxValueUsingThreads[] ts = new MaxValueUsingThreads[4];
		for (int i = 0; i < 4; i++) {
			ts[i] = new MaxValueUsingThreads((i * len) / 4, ((i + 1) * len / 4),arr);
			ts[i].start();
		}
		for (int i = 0; i < 4; i++) {
			ts[i].join();
			if (max <= ts[i].ans)
				max = ts[i].ans;
		}
		return max;
	}
public static void main(String[] args) throws InterruptedException {
	int[] arr = {2,5,4,23,45,65,76,32,81,4,5,6,98,43,63,21,91};
    int max = max(arr);
    System.out.println("Max: " + max);

}
}
