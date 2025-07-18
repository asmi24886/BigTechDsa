package com.solutions.neetcode.heap.LC295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(rightMinHeap.isEmpty()) {
            rightMinHeap.add(num);
            return;
        }

        if(num > rightMinHeap.peek())
            rightMinHeap.add(num);
        else
            leftMaxHeap.add(num);

        balanceHeaps();
    }

    private void balanceHeaps() {
        int leftSize = leftMaxHeap.size();
        int rightSize = rightMinHeap.size();
        int totalSize = leftSize + rightSize;
        if( totalSize % 2 == 0) {
            if(leftSize > rightSize) {
                rightMinHeap.add(leftMaxHeap.remove());
            }
            else if(rightSize > leftSize) {
                leftMaxHeap.add(rightMinHeap.remove());
            }
        }
        else {
            if(leftSize - rightSize > 1) {
                rightMinHeap.add(leftMaxHeap.remove());
            }
            else if(rightSize - leftSize > 1) {
                leftMaxHeap.add(rightMinHeap.remove());
            }
        }
    }

    public double findMedian() {
        int leftSize = leftMaxHeap.size();
        int rightSize = rightMinHeap.size();
        int totalSize = leftSize + rightSize;

        if(rightSize == 0 && leftSize == 0) return 0.0;
        if(leftSize == 0) return (double) rightMinHeap.peek();
        if(rightSize == 0) return (double) leftMaxHeap.peek();

        if(totalSize%2 == 0) {
            return (double)(leftMaxHeap.peek() + rightMinHeap.peek())/2;
        }
        else {
            return (double) leftSize > rightSize ? leftMaxHeap.peek() : rightMinHeap.peek();
        }
    }
}