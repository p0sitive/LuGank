package com.lee.lugank.http;

/**
 * Created by lihe6 on 2016/6/7.
 */
public class GankBean {

    /**
     * _id : 57504a72421aa9565763b411
     * createdAt : 2016-06-02T23:02:10.764Z
     * desc : 利用三阶贝塞尔曲线模仿QQ空间直播页面右下角的礼物冒泡特效
     * publishedAt : 2016-06-07T11:43:18.947Z
     * source : web
     * type : Android
     * url : https://github.com/Yasic/QQBubbleView
     * used : true
     * who : Yasic Yu
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
