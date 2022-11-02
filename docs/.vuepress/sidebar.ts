import {sidebar} from "vuepress-theme-hope";

export default sidebar({
    //java部分
    "/java/": "structure",
    "/java": [
        {
            text: "Java基础",
            link: "/java/basis/01-基础概念.md",
            icon: "java",
        },
    ],
    //个人分享部分
    "/share/": "structure",
});