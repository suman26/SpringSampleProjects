package com.abhi.threads;

public class MinValueUsingThreads extends Thread {
	private int lo, hi;
	private int[] arr;
	private int ans = 0;

	public MinValueUsingThreads(int lo, int hi, int[] arr) {
		super();
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
	}

	@Override
	public void run() {
		ans=arr[lo];
		for (int i = lo; i < hi; i++) {
			if (ans >= arr[i])
				ans = arr[i];
		}
	}

	public static int min(int[] arr) throws InterruptedException {
		int len = arr.length;
		int min=1000000;
		MinValueUsingThreads[] ts = new MinValueUsingThreads[4];
		for (int i = 0; i < 4; i++) {
			ts[i] = new MinValueUsingThreads((i * len) / 4, ((i + 1) * len) / 4, arr);
			ts[i].start();
		}
		for (int i = 0; i < 4; i++) {
			ts[i].join();
			if (min > ts[i].ans)
				min = ts[i].ans;
		}
		return min;
	}
	public static void main(String[] args) throws InterruptedException {
		int[] arr = {2,5,4,23,45,65,76,32,81,4,5,6,98,43,63,21,91};
	    int min = min(arr);
	    System.out.println("Min: " + min);

	}

}
