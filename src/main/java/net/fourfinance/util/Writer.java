package net.fourfinance.util;

import net.fourfinance.entity.StudentDto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    public static void WriteFile(List<StudentDto> students, String name) throws IOException {
        FileWriter csvWriter = new FileWriter(name);
        csvWriter.append("Name");
        csvWriter.append(",");
        csvWriter.append("Score");
        csvWriter.append(",");

        for (StudentDto stud : students) {
            csvWriter.append(stud.getName() + "," + stud.getGrade());
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
