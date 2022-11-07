import {defineUserConfig} from "vuepress";
import theme from "./theme.js";

export default defineUserConfig({
    base: "/",
    lang: "zh-CN",
    title: "EasyJava",
    description: "借鉴参考各位Javaer的开源知识库，在此基础上对笔记整合同时复习巩固知识点，督促自己每天保持学习，并将个人的总结分享给大家！",
    theme,
    //百度统计脚本
    head: [
        ["script",
            {},
            `var _hmt = _hmt || [];
            (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?4602c358cd55c60e2d5781f736067523";
            var s = document.getElementsByTagName("script")[0]; 
            s.parentNode.insertBefore(hm, s);
            })();`,
        ],
    ],
});