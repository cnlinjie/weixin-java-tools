package me.chanjar.weixin.common.util.http;

import me.chanjar.weixin.common.bean.result.WxError;
import me.chanjar.weixin.common.bean.result.WxMediaPersistenceUploadResult;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.bean.upload.AddMpMassVideo;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.File;
import java.io.IOException;

/**
 *  上传永久视频素
 *
 * @author Daniel Qian
 */
public class PersistenceVideoUploadRequestExecutor implements RequestExecutor<WxMediaPersistenceUploadResult, AddMpMassVideo> {

    @Override
    public WxMediaPersistenceUploadResult execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri, AddMpMassVideo video) throws WxErrorException, ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (httpProxy != null) {
            RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
            httpPost.setConfig(config);
        }

        String params = video.descriptionToJson();

        if (video.getFile() != null) {
            HttpEntity entity = MultipartEntityBuilder
                    .create()
                    .addBinaryBody("media", video.getFile())
                    .addTextBody("description", params)
                    .build();

            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", ContentType.MULTIPART_FORM_DATA.toString());
        }
        CloseableHttpResponse response = httpclient.execute(httpPost);
        String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
        WxError error = WxError.fromJson(responseContent);
        if (error.getErrorCode() != 0) {
            throw new WxErrorException(error);
        }
        return WxMediaPersistenceUploadResult.fromJson(responseContent);
    }

}
