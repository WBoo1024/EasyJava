import {defineUserConfig} from "vuepress";
import theme from "./theme.js";

export default defineUserConfig({
    base: "/",
    lang: "zh-CN",
    title: "EasyJava",
    description: "今天你学习了吗?",
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