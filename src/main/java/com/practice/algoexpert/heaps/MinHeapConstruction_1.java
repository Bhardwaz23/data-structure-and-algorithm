package com.practice.algoexpert.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/MinHeapConstruction.png" />
 *
 */
public class MinHeapConstruction_1 {

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
		for (int i = 0; i < minHeap.heap.size(); i++) {
			System.out.print(minHeap.heap.get(i) + "\t");
		}

	}

	static class MinHeap {

		List<Integer> heap = new ArrayList<Integer>();

		public MinHeap(List<Integer> array) {

			heap = buildHeap(array);

		}

		// O(n) time | O(1) space

		public List<Integer> buildHeap(List<Integer> array) {
			// this will give the last parent node present in the list
			int firstParentIdx = (array.size() - 2) / 2;

			for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {

				siftDown(currentIdx, array.size() - 1, array);

			}

			return array;

		}

		// O(log(n)) time | O(1) space

		public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {

			int childOneIdx = currentIdx * 2 + 1;

			while (childOneIdx <= endIdx) {

				int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;

				int idxToSwap;

				if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {

					idxToSwap = childTwoIdx;

				} else {

					idxToSwap = childOneIdx;

				}

				if (heap.get(idxToSwap) < heap.get(currentIdx)) {

					swap(currentIdx, idxToSwap, heap);

					currentIdx = idxToSwap;

					childOneIdx = currentIdx * 2 + 1;

				} else {

					return;

				}
			}

		}

		// O(log(n)) time | O(1) space

		public void siftUp(int currentIdx, List<Integer> heap) {

			int parentIdx = (currentIdx - 1) / 2;
			while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx))

			{

				swap(currentIdx, parentIdx, heap);

				currentIdx = parentIdx;

				parentIdx = (currentIdx - 1) / 2;

			}

		}

		public int peek() {

			return heap.get(0);

		}

		public int remove() {

			swap(0, heap.size() - 1, heap);

			int valueToRemove = heap.get(heap.size() - 1);

			heap.remove(heap.size() - 1);

			siftDown(0, heap.size() - 1, heap);

			return valueToRemove;

		}

		public void insert(int value) {

			heap.add(value);

			siftUp(heap.size() - 1, heap);

		}

		public void swap(int i, int j, List<Integer> heap) {

			Integer temp = heap.get(j);

			heap.set(j, heap.get(i));

			heap.set(i, temp);

		}

	}

}