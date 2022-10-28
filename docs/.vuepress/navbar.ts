import {navbar} from "vuepress-theme-hope";

export default navbar([
    {text: "Java", icon: "java", link: "/home.md"},
    {
        text: "数据库",
        icon: "shujuku",
        children: [
            {text: "MySQL", icon: "mysql", link: "/home.md"},
            {text: "Redis", icon: "redis", link: "/home.md"},
        ]
    },
    {text: "Spring", icon: "spring", link: "/home.md"},
    {
        text: "中间件",
        icon: "message",
        children: [
            {text: "RocketMQ", icon: "rocketmq", link: "/home.md"},
            {text: "RabbitMQ", icon: "rabbitmq", link: "/home.md"},
        ]
    },
    {text: "分布式", icon: "cloud", link: "/home.md"},
    {
        text: "开发工具",
        icon: "tool",
        children: [
            {text: "Git", icon: "git", link: "/home.md"},
            {text: "Docker", icon: "docker", link: "/home.md"},
            {text: "IDEA", icon: "Idea", link: "/home.md"},
        ],
    },
]);