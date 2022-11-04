import {defineUserConfig} from "vuepress";
import theme from "./theme";

export default defineUserConfig({
    lang: "zh-CN",
    description: "今天你学习了吗？",

    base: "/",
    head: [
        ['script', {}, `
          var _hmt = _hmt || [];
          (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?78dc0e0b4e3aedf643d6621778307a6f";
            var s = document.getElementsByTagName("script")[0]; 
            s.parentNode.insertBefore(hm, s);
          })();
      `]
    ],
    //网页标签及首页左上角logo
    title: "EasyJava",
    theme,
    // head: [
    //     ["link",
    //         {
    //             rel: "icon",
    //             href: "/logo.png",
    //         },
    //     ],
    // ],
});