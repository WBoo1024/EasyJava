
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WANG
 * @date 2022/5/31 9:17
 */
public class ExcelTest{
    public static void main(String[] args) throws IOException {
        String fileName = "student.xlsx";
        Workbook wb = getWorkbook(fileName);
        Sheet sheet = wb.createSheet("XAJ220406");
        String[] strings = {"姓名","性别","年龄","学历","学号"};
        creatTitle(strings,sheet);
        writeData(sheet);
        File file = new File("src/名单/student.xlsx");
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.flush();
        out.close();
    }

    /**
     * 填写表格数据
     * @param sheet XAJ220406
     */
    private static void writeData(Sheet sheet) {
        List<Student> students = studentList();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            int n = 2;
            Row rowStudentOne = sheet.createRow(3+i);
            Cell cellStudentName = rowStudentOne.createCell(n++);
            cellStudentName.setCellValue(student.getName());
            Cell cellStudentSex = rowStudentOne.createCell(n++);
            cellStudentSex.setCellValue(student.getSex());
            Cell cellStudentAge = rowStudentOne.createCell(n++);
            cellStudentAge.setCellValue(student.getAge());
            Cell cellStudentStu = rowStudentOne.createCell(n++);
            cellStudentStu.setCellValue(student.getStudy());
            Cell cellStudentNum = rowStudentOne.createCell(n++);
            cellStudentNum.setCellValue(student.getNum());
        }
    }
    /**
     *创建学生名单
     *
     */
    private static List<Student> studentList() {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("与大学","男","22","本科","22020422"));
        studentList.add(new Student("周家豪","男","21","大学","22020423"));
        studentList.add(new Student("张硕","男","20","高中","22020424"));
        studentList.add(new Student("帷幕","男","19","专科","22020425"));
        studentList.add(new Student("吴义昭","男","23","成人本科","22020426"));
        return studentList;
    }

    /**
     * 创建表头信息
     * @param strings 表头信息
     */
    private static void creatTitle(String[] strings,Sheet sheet) {
        Row title = sheet.createRow(2);
        Cell cellTitle = null;
        for (int i = 0; i < strings.length; i++) {
            cellTitle = title.createCell(i+2);
            cellTitle.setCellValue(strings[i]);
        }
    }

    /**
     * 创建一个表格对象
     * @param fileName 表格名
     * @return 返回表格对象
     * @throws IOException 抛出IO异常
     */
    private static Workbook getWorkbook(String fileName) throws IOException {
        Workbook wb = null;
        if (fileName.endsWith(".xls")){
            wb = new HSSFWorkbook();
        }else if (fileName.endsWith(".xlsx")) {
            wb = new XSSFWorkbook();
        }
        return wb;
    }
}
