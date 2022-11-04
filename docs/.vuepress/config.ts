import {defineUserConfig} from "vuepress";
import theme from "./theme";

export default defineUserConfig({
    base: "/EasyJava/",
    lang: "zh-CN",
    //网页标签及首页左上角logo
    title: "EasyJava",
    theme,
    head: [
        ["link",
            {
                rel: "icon",
                href: "/logo.png",
            },
        ],
    ],
});