package net.fourfinance.util;

import net.fourfinance.entity.StudentDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility file reader class
 */
public class Reader {
    public static List<StudentDto> readFile(String path) throws IOException {
        List<StudentDto> resultList = new ArrayList<>();
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            resultList.add(new StudentDto(data[0], data[1]));

        }
        csvReader.close();
        return resultList;
    }
}
