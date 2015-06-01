package me.chanjar.weixin.common.bean.result;

import me.chanjar.weixin.common.util.json.WxGsonBuilder;

import java.io.Serializable;

public class WxMediaPersistenceUploadResult implements Serializable {

  private String url;
  private String mediaId;


  public static WxMediaPersistenceUploadResult fromJson(String json) {
    return WxGsonBuilder.create().fromJson(json, WxMediaPersistenceUploadResult.class);
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getMediaId() {
    return mediaId;
  }

  public void setMediaId(String mediaId) {
    this.mediaId = mediaId;
  }

  @Override
  public String toString() {
    return "WxMediaPersistenceUploadResult [url=" + url + ", media_id=" + mediaId + "]";
  }

}
