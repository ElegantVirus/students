package net.fourfinance.util;

import javafx.util.Pair;
import net.fourfinance.entity.StudentDto;

import java.util.*;

/**
 * Sorting utility class, has three algorithms implemented - heap, bubble and mergeSort
 */
public class Sorting {

    private static StudentDto swap = null;

    public static Pair<List<StudentDto>, Long> getBubbleSort(List<StudentDto> dataList) {
        ArrayList<StudentDto> resultList = (ArrayList) dataList;
        long startTime = System.nanoTime();
        for (int j = 0; j < dataList.size(); j++) {

            for (int i = j + 1; i < resultList.size(); i++) {

                if ((resultList.get(i).getGrade()).compareToIgnoreCase(resultList.get(j).getGrade()) < 0) {
                    StudentDto t = resultList.get(j);
                    resultList.set(j, resultList.get(i));
                    resultList.set(i, t);
                }
            }
        }

        long endTime = System.nanoTime();
        Long duration = (endTime - startTime);

        return new Pair<>(resultList, duration);
    }

@Deprecated
    public static Pair<List<StudentDto>, Long> getHeapSort(List<StudentDto> dataList) {
        long startTime = System.nanoTime();
        List result = heapSort(dataList);
        long endTime = System.nanoTime();
        Long duration = (endTime - startTime);

        return new Pair(result, duration);
    }

    private static List<StudentDto> heapSort(List<StudentDto> dataList) {
        ArrayList resultList = (ArrayList) dataList;
        heapify(resultList);

        int end = resultList.size() - 1;
        while (end > 0) {
            resultList = swap(resultList, 0, end);
            end--;
            siftDown(resultList, 0, end);

        }
        return resultList;
    }

    private static ArrayList<StudentDto> heapify(ArrayList<StudentDto> list) {
        int start = (list.size()) / 2;
        while (start >= 0) {
            siftDown(list, start, list.size());
            start--;
        }
        return list;
    }

    private static ArrayList<StudentDto> siftDown(ArrayList<StudentDto> list, int start, int end) {
        StudentDto tmp;
        int child;
        for (tmp = list.get(start); leftChild(start) < end; start = child) {
            child = leftChild(start);
            if (child != end - 1 && list.get(child).getGrade().compareTo(list.get(child + 1).getGrade()) < 0)
                child++;
            if (tmp.getGrade().compareTo(list.get(child).getGrade()) < 0) {
                list.add(start, list.get(child));
            } else
                break;
        }
        list.add(start, tmp);
        return list;

    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static ArrayList<StudentDto> swap(ArrayList<StudentDto> list, int index1, int index2) {
        swap = list.get(index1);
        list.add(index1, list.get(index2));
        list.add(index2, swap);
        return list;
    }

    public static Pair<ArrayList<StudentDto>, Long> getMergeSort(List<StudentDto> list) {
        long startTime = System.nanoTime();
        List result = mergeSort(list);
        long endTime = System.nanoTime();
        Long duration = (endTime - startTime);
        return new Pair(result, duration);
    }

    private static ArrayList<StudentDto> mergeSort(List<StudentDto> list) {
        ArrayList<StudentDto> resultList = (ArrayList<StudentDto>) list;
        ArrayList<StudentDto> left = new ArrayList<>();
        ArrayList<StudentDto> right = new ArrayList<>();
        int center;

        if (list.size() == 1) {
            return (ArrayList<StudentDto>) list;
        } else {
            center = list.size() / 2;
            for (int i = 0; i < center; i++) {
                left.add(list.get(i));
            }

            for (int i = center; i < list.size(); i++) {
                right.add(list.get(i));
            }

            left = mergeSort(left);
            right = mergeSort(right);

            merge(left, right, (ArrayList<StudentDto>) list);
        }

        return resultList;
    }

    private static void merge
            (ArrayList<StudentDto> left, ArrayList<StudentDto> right, ArrayList<StudentDto> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).getGrade().compareTo(right.get(rightIndex).getGrade())) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<StudentDto> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
}
