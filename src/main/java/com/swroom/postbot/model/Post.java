package com.swroom.postbot.model;

public class Post {

    /**
     * 标题
     */
    private String title;

    /**
     * 别名，用来做文件名和url名
     */
    private String alias;

    /**
     * 正文内容
     */
    private String content;

    /**
     * 标签
     */
    private String tags;

    /**
     * 分类
     */
    private String categories;

    /**
     * 验证码
     */
    private String auth;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", alias='" + alias + '\'' +
                ", content='" + content + '\'' +
                ", tags='" + tags + '\'' +
                ", categories='" + categories + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}
