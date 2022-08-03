import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WANG
 * @date 2022/5/31 19:46
 */
public class ReadExcel {
    public static void main(String[] args) throws IOException {
        List<Student> list = new ArrayList<Student>();
        XSSFWorkbook wb = new XSSFWorkbook("src/名单/student.xlsx");
        Sheet sheet = wb.getSheetAt(0);
        readStudent(sheet,list);
        for (Student student : list) {
            System.out.println(student);
        }

    }
    public static void readStudent(Sheet sheet,List<Student> list){
        
        int first = sheet.getFirstRowNum();
        int last = sheet.getLastRowNum();
        for (int i = first+1; i <= last; i++) {
            Row row = sheet.getRow(i);
            Student student = new Student();
            int firstCell = row.getFirstCellNum();
            Cell name = row.getCell(firstCell);
            student.setName(name.getStringCellValue());
            Cell sex = row.getCell(firstCell+1);
            student.setSex(sex.getStringCellValue());
            Cell age = row.getCell(firstCell+2);
            student.setAge(age.getStringCellValue());
            Cell stu = row.getCell(firstCell+3);
            student.setStudy(stu.getStringCellValue());
            Cell num = row.getCell(firstCell+4);
            student.setNum(num.getStringCellValue());
            list.add(student);
        }
    }

    public static int getNum(int i){
        return -1;
    }

}
