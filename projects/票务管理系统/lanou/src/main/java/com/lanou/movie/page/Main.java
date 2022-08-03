package com.lanou.movie.page;

import com.lanou.movie.controller.UserController;

/**
 * @program: lanou
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/11 20:51
 */
public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Project project = new Project(userController);
        project.start();
    }
}
