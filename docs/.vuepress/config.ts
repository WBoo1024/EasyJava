import {defineUserConfig} from "vuepress";
import theme from "./theme.js";

export default defineUserConfig({
    base: "/",
    lang: "zh-CN",
    title: "EasyJava",
    description: "今天你学习了吗?",
    theme,
});