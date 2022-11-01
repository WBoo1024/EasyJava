import {defineUserConfig} from "vuepress";
import theme from "./theme";

export default defineUserConfig({
    base: "/EasyJava/",
    lang: "zh-CN",
    //网页标签及首页左上角logo
    title: "EasyJava",
    theme,
    //是否开启默认预加载js
    shouldPrefetch: false,
    head: [
        ["link",
            {
                rel: "icon",
                href: "/logo.png",
            },
        ],
    ],
});