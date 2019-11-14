package net.fourfinance.util;

import javafx.util.Pair;
import net.fourfinance.entity.StudentDto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test {
    String path = "src/test/resources/example.csv";

    @org.junit.Test
    public void testReadAndSort() throws IOException {
        List<StudentDto> studentDto = Reader.readFile(path);
        assert !studentDto.isEmpty();
        Pair bubble = Sorting.getBubbleSort(studentDto);
        assert bubble != null;
        Pair merge = Sorting.getMergeSort(studentDto);
        assert merge != null;
        Pair heap = Sorting.getHeapSort(studentDto);
    }

    @org.junit.Test
    public void testSortAndWrite() throws IOException {
        List<StudentDto> studentDto = Reader.readFile(path);
        assert !studentDto.isEmpty();
        Pair bubble = Sorting.getBubbleSort(studentDto);
        assert bubble != null;
        Writer.WriteFile((List<StudentDto>) bubble.getKey(), "bubble.csv");
    }
}
