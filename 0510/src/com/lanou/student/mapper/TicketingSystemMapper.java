package com.lanou.student.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.lanou.student.bean.TicketingSystem;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author WANG
 */
public class TicketingSystemMapper {
    /** 对象数组 */
    private TicketingSystem[] tickets;
    /** 长度 */
    private int index;


    public TicketingSystemMapper() {

        tickets = new TicketingSystem[1];
    }

    public TicketingSystem[] getTickets() {

        return Arrays.copyOf(tickets, index);
    }

    public boolean add(TicketingSystem ticket) {
        grow();
        tickets[index++] = ticket;
        return true;
    }
    /**
     * @Description: 表头
     * @date: 2022/6/2 17:28
     */
//    public void excelTitle(){
//        String path = "src/com/lanou/studentTicketingSystem.xls";
//        HSSFWorkbook workbook = new HSSFWorkbook(path);
//        Sheet sheet = workbook.createSheet();
//        Row row = sheet.createRow(0);
//        String[] title = {"id","电影名称","导演","主演","类型","地区","语言","上映时间"};
//        for (int i = 0; i < title.length; i++) {
//            row.createCell(i).setCellValue(title[i]);
//        }
//    }

    /**
     * @Description: 将数据写入表格中
     * @date: 2022/6/2 17:26
     */
    public void writeExcel(){

    }
    /**
     * @Description: 扩容 
     * @date: 2022/6/2 14:39 
     */
    private void grow() {
        int oldCapacity = tickets.length;
        if (index == 0) {
            tickets = new TicketingSystem[1];
        } else if (index == oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity == 1) {
                newCapacity = 2;
            }
            tickets = Arrays.copyOf(tickets, newCapacity);
        }
    }

    public int size() {
        return index;
    }
    /**
     * @Description: 删除
     * @date: 2022/6/2 14:44
     * @param id 序号
     * @return boolean
     */
    public boolean delete(int id) {
        int i = getInd(id);
        if (i == -1) {
            return false;
        }
        for (int j = i + 1; j < index; j++) {
            tickets[j - 1] = tickets[j];
        }
        index--;
        return true;
    }
    /**
     * @Description: 获取索引
     * @date: 2022/6/2 14:49
     * @param id 序号
     * @return int
     */
    private int getInd(int id) {
        for (int i = 0; i < index; i++) {
            if (id == tickets[i].getId()) {
                return i;
            }
        }
        return -1;
    }
    /** 修改电影名 */
    public boolean reMovie(int id, String newMovie) {
        int a = getInd(id);
        if (a == -1) {
            return false;
        }
        tickets[a].setMovie(newMovie);
        return true;
    }
    /** 修改导演 */
    public boolean reDirector(int id, String newDirector) {
        int a = getInd(id);
        if (a == -1) {
            return false;
        }
        tickets[a].setDirector(newDirector);
        return true;
    }
    /** 修改主演 */
    public boolean reStarring(int id, String newStarring) {
        int a = getInd(id);
        if (a == -1) {
            return false;
        }
        tickets[a].setStarring(newStarring);
        return true;
    }
    /** 修改类型 */
    public boolean newType(int id, String newType) {
        int a = getInd(id);
        if (a == -1) {
            return false;
        }
        tickets[a].setType(newType);
        return true;
    }
    /** 修改地区 */
    public boolean reArea(int id, String newArea) {
        int a = getInd(id);
        if (a == -1) {
            return false;
        }
        tickets[a].setArea(newArea);
        return true;
    }
    /** 修改语言 */
    public boolean reLanguage(int id,String newLanguage){
        int a = getInd(id);
        if (a == -1) {
            return false;
        }
        tickets[a].setLanguage(newLanguage);
        return true;
    }
    /** 修改上映时间 */
    public boolean reRelease(int id,String newRelease){
        int a = getInd(id);
        if (a == -1) {
            return false;
        }
        tickets[a].setReleaseTime(newRelease);
        return true;
    }
}


