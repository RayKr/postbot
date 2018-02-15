package com.swroom.postbot.utils;

public class Constant {

    /**
     * MD5 32位
     */
    public static final String AUTHCODE = "19aafb0b3e81a499c7d236df6b4f293a";

    /**
     * 本地博客根目录绝对路径
     */
    public static final String ROOTPATH = "/home/tsunglei/workspace/blog";

    /**
     * 博客文件路径
     */
    public static final String POSTPATH = ROOTPATH + "/source/_posts/";

    /**
     * GIT bash
     */
    public static final String GIT = "cd "+ POSTPATH +" && git pull origin master\n" +
            "git add * &&" +
            "git commit -m \"push\" &&" +
            "git push origin master";

    public static final String[] CMDS = {"/bin/sh","-c", GIT};
}
