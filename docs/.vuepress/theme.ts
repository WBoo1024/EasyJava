import { hopeTheme } from "vuepress-theme-hope";
import  navbar  from "./navbar";
import  sidebar  from "./sidebar";

export default hopeTheme({
  //域名
  hostname: "https://1024.wboo.xyz",
  //文章作者
  author: "壹零二四",
  //图标资源
  iconAssets: "//at.alicdn.com/t/c/font_3736120_djzeu3vx9lc.css",
  iconPrefix: "iconfont icon-",
  //导航栏logo
  logo: "logo.png",
  //仓库配置
  repo: "https://github.com/WBoo1024/EasyJava",
  //导航栏配置
  navbar: navbar,
  //侧边栏配置
  sidebar: sidebar,
  //全屏设置
  fullscreen: true,
  //文章信息
  pageInfo: ["Author","Category", "Tag", "Word"],
  //页脚
  footer:
      '<a href="https://beian.miit.gov.cn/" target="_blank">鄂ICP备2022014006号-1</a>',
  //显示页脚
  displayFooter: true,
  //主题颜色
  themeColor: {
    blue: "#1e80ff",
    green: "#3eaf7c",
    red: "#f26d6d",
  },
  //插件
  plugins: {
    mdEnhance: {
      align: true,
      tabs: true,
      container: true,
      demo: true,
      flowchart: true,
      imageSize: true,
      lazyLoad: true,
      mark: true,
    },
  },
});