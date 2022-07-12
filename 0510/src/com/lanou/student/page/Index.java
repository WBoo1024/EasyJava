package com.lanou.student.page;

import java.util.Scanner;

import com.lanou.student.bean.TicketingSystem;
import com.lanou.student.controller.TicketingSystemController;
import com.lanou.student.controller.UserController;

public class Index {
    private Scanner sca = new Scanner(System.in);
    private TicketingSystemController ticketingSystemController;
    private UserController userController;
    private Login log;
    private Project regester;
    private int id = 1;

    public Index(TicketingSystemController ticketingSystemController) {
        this.ticketingSystemController = ticketingSystemController;
        userController = new UserController();
        log = new Login();
        regester = new Project();
    }


    public void index() {
        boolean flag = true;
        while (flag) {
            System.out.println("-----------蓝鸥影院票务后台管理系统----------");
            print();
            System.out.println("\t1.添加\t2.更新");
            System.out.println("\t3.删除\t4.注销");
            System.out.println("\t请选择");
            switch (sca.nextInt()) {
                case 1:
                    // 添加
                    TicketingSystem ticket = getTicket();
                    if (ticketingSystemController.add(ticket)) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                    break;
                case 2:
                    // 更新
                    System.out.println("请选择要更新的选项");
                    System.out.println("\t1.电影名称\t2.导演\t3.主要演员\t4.类型");
                    System.out.println("\t5.地区\t6.语言\t7.上映时间");
                    int i = sca.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("请输入要修改的电影id");
                            int id = sca.nextInt();
                            System.out.println("请输入修改后的电影名称");
                            String newMovie = sca.next();
                            if (ticketingSystemController.reMovie(id, newMovie)) {
                                System.out.println("修改成功");
                            } else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 2:
                            System.out.println("请输入要修改的电影id");
                            id = sca.nextInt();
                            System.out.println("请输入修改后的导演");
                            String newDirector = sca.next();
                            if (ticketingSystemController.reDirector(id, newDirector)) {
                                System.out.println("修改成功");
                            } else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 3:
                            System.out.println("请输入要修改的电影id");
                            id = sca.nextInt();
                            System.out.println("请输入修改后的主演人员");
                            String starring = sca.next();
                            if (ticketingSystemController.reStarring(id, starring)) {
                                System.out.println("修改成功");
                            } else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 4:
                            System.out.println("请输入要修改的电影id");
                            id = sca.nextInt();
                            System.out.println("请输入修改后的电影类型");
                            String newType = sca.next();
                            if (ticketingSystemController.reType(id, newType)) {
                                System.out.println("修改成功");
                            } else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 5:
                            System.out.println("请输入要修改的电影id");
                            id = sca.nextInt();
                            System.out.println("请输入修改后的电影地区");
                            String newArea = sca.next();
                            if (ticketingSystemController.reArea(id, newArea)) {
                                System.out.println("修改成功");
                            } else {
                                System.out.println("修改失败");
                            }
                            break;
                        case 6:
                            System.out.println("请输入要修改的电影id");
                            id = sca.nextInt();
                            System.out.println("请输入修改后的电影语言");
                            String language = sca.next();
                            if (ticketingSystemController.reArea(id, language)) {
                                System.out.println("修改成功");
                            } else {
                                System.out.println("修改失败");
                            }
                            break;
						case 7:
							System.out.println("请输入要修改的电影id");
							id = sca.nextInt();
							System.out.println("请输入修改后的电影上映时间");
							String newTime = sca.next();
							if (ticketingSystemController.reArea(id,newTime)) {
								System.out.println("修改成功");
							} else {
								System.out.println("修改失败");
							}
							break;
                        default:
                            System.out.println("输入有误");
                            break;
                    }
                    break;
                case 3:
                    // 删除
                    System.out.println("请输入需要删除的电影id");
                    if (ticketingSystemController.delete(sca.nextInt())) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    break;
                case 4:
                    // 注销
                    System.out.println("请输入要注销的用户名");
                    String name = sca.next();
                    if (userController.logout(name)) {
                        System.out.println("注销成功");
                        regester.start();
                    } else {
                        System.out.println("注销失败");
                        regester.start();
                    }
                    break;

                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }

    private void print() {
        TicketingSystem[] ticketss = ticketingSystemController.getTickets();
        System.out.println("");
		for (TicketingSystem ticket : ticketss) {
			System.out.println(ticket.getId() + "\t\t" + ticket.getMovie() + "\t\t" + ticket.getDirector() + "\t\t"
                                + ticket.getStarring() + "\t\t" + ticket.getType() + "\t\t"
                                + ticket.getLanguage()+ "\t\t" + ticket.getReleaseTime());
		}
    }

    private TicketingSystem getTicket() {
        System.out.println("请输入电影名称");
        String movie = sca.next();
        System.out.println("请输入导演");
        String director = sca.next();
        System.out.println("请输入主演人员");
        String starring = sca.next();
        System.out.println("请输入电影类型");
        String type = sca.next();
        System.out.println("请输入电影拍摄地区");
        String area = sca.next();
        System.out.println("请输入电影原生语言");
        String language = sca.next();
        System.out.println("请输入电影上映时间");
        String releaseTime = sca.next();
        return new TicketingSystem(id++, movie, director, starring, type, area, language, releaseTime);
    }
}
