import {hopeTheme} from "vuepress-theme-hope";
import {Navbar} from "./navbar";
import {Sidebar} from "./sidebar";

export default hopeTheme({
    hostname: "https://1024.wboo.xyz",

    author: "壹零二四",

    iconAssets: "//at.alicdn.com/t/c/font_3736120_hgxrosm6jl.css",

    iconPrefix: "iconfont icon-",

    logo: "/logo.svg",

    repo: "https://github.com/WBoo1024/EasyJava",

    docsDir: "docs",

    pageInfo: ["Author","Category", "Tag", "Word"],

    sidebarSorter: ["order","filename","title"],

    // navbar
    navbar: Navbar,

    // sidebar
    sidebar: Sidebar,

    footer:
        '<a href="https://beian.miit.gov.cn/" target="_blank">鄂ICP备2022014006号-1</a>',

    displayFooter: true,

    // page meta
    metaLocales: {
        editLink: "在 GitHub 上编辑此页",
    },
//主题颜色
    themeColor: {
        blue: "#1e80ff",
        green: "#3eaf7c",
        red: "#f26d6d",
    },

});