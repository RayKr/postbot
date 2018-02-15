package com.swroom.postbot.controller;

import com.swroom.postbot.model.Post;
import com.swroom.postbot.utils.Constant;
import com.swroom.postbot.utils.Md5Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class PostApi {

    @PostMapping("/post")
    String post(Post post) {

        System.out.println(post);

        if (post.getAuth() != null && Md5Util.string2MD5(post.getAuth()).equals(Constant.AUTHCODE)) {
            // 写入文件
            writeToFile(post);

            // 执行bash
            try {
                Runtime.getRuntime().exec(Constant.CMDS);
                return "Good job!";
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            return "Sorry.";
        }

        return "Maybe something with wrong.";

    }

    private void writeToFile(Post post) {
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = sdf.format(time);
        try {
            FileWriter fw = new FileWriter(Constant.POSTPATH + post.getAlias() + ".md");
            fw.write("---\r\n");
            fw.write("title: " + post.getTitle() + "\r\n");
            fw.write("date: " + d + "\r\n");
            if (post.getCategories() != null && !"".equals(post.getCategories())) {
                fw.write("categories: \r\n");
                String cats[] = post.getCategories().replaceAll(" ","").split(",");
                for (String cat : cats) {
                    fw.write("- " + cat + "\r\n");
                }
            }
            if (post.getTags() != null && !"".equals(post.getTags())) {
                fw.write("tags: \r\n");
                String tags[] = post.getTags().replaceAll(" ","").split(",");
                for (String tag : tags) {
                    fw.write("- " + tag + "\r\n");
                }
            }
            fw.write("---\r\n");

            fw.write(post.getContent());


            fw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
