import {navbar} from "vuepress-theme-hope";

export default navbar([
    {
        text: "Java",
        icon: "java",
        children: [
            {text: "基础", icon: "index", link: "/java/basis/01-基础概念.md"},
            {text: "集合", icon: "jihe", link: "/java/collection/01-集合概述.md"},
            {text: "I/O流", icon: "io", link: "/java/io/01-io基础.md"},
            {text: "多线程", icon: "jincheng", link: "/java/multithreading/01-初识多线程.md"},
            {text: "JVM", icon: "jvm", link: "/java/jvm/01-认识jvm.md"},
        ]},
    {
        text: "数据库",
        icon: "shujuku",
        children: [
            {text: "MySQL", icon: "mysql", link: "/database/mysql/01-常见面试题.md"},
            {text: "Redis", icon: "redis", link: "/database/redis/01-面试题总结上篇.md"},
            {text: "MyBatis", icon: "/mybatis.png", link: "/database/mybatis/01-面试题总结.md"},
        ]
    },
    {text: "Spring", icon: "spring", link: "/spring/boot/01-面试题总结.md"},
    {
        text: "中间件",
        icon: "message",
        children: [
            {text: "RocketMQ", icon: "rocketmq", link: "/mq/03-rocketmq基础知识.md"},
            {text: "RabbitMQ", icon: "rabbitmq", link: "/mq/05-rabbitmq基础知识.md"},
        ]
    },
    {text: "分布式", icon: "cloud", link: "/java/basis/01-基础概念.md"},
    {
        text: "开发工具",
        icon: "tool",
        children: [
            {text: "Git", icon: "git", link: "/tool/git/01-git入门.md"},
            {text: "Docker", icon: "docker", link: "/tool/docker/01-docker入门.md"},
            {text: "IDEA", icon: "Idea", link: "/java/basis/01-基础概念.md"},
        ],
    },
]);