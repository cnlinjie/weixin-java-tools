package me.chanjar.weixin.common.bean.upload;

import java.io.File;

/**
 * Created by linjie on 15-6-1.
 */
public class AddMpMassVideo {


    private File file;

    private String title;

    private String introduction;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String descriptionToJson() {

        return "{\"title\":\""+ title+"\", \"introduction\":\""+ introduction +"\"}";
    }



}
