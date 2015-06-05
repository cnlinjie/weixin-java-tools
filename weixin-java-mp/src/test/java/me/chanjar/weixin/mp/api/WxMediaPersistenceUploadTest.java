package me.chanjar.weixin.mp.api;

import com.google.inject.Inject;
import me.chanjar.weixin.common.bean.result.WxMediaPersistenceUploadResult;
import me.chanjar.weixin.common.bean.upload.AddMpMassVideo;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.WxMpMassPersistenceNews;
import me.chanjar.weixin.mp.bean.WxMpMassPersistenceNewsUpdate;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by linjie on 15-6-1.
 */
@Test(groups = "perUplodaApi")
@Guice(modules = ApiTestModule.class)
public class WxMediaPersistenceUploadTest {

    @Inject
    protected WxMpServiceImpl wxService;


    public void test() throws WxErrorException {

        System.out.println(wxService);
        WxMediaPersistenceUploadResult image = wxService.mediaPersistenceUpload("thumb", new File("/home/linjie/Workspaces/IdeaProjects/weixin-java-tools/weixin-java-mp/target/classes/mm.jpeg"));
        System.out.println(image.getMediaId());
        System.out.println(image.getUrl());
    }


    public void testMp3() throws WxErrorException {
        System.out.println(wxService);
        WxMediaPersistenceUploadResult image = wxService.mediaPersistenceUpload("voice", new File("/home/linjie/Music/Google-IO-2015-Keynote_201561135843_20156117127.mp3"));
        System.out.println(image.getMediaId());
        System.out.println(image.getUrl());
    }


    public void testUploadNews() throws WxErrorException {
        WxMpMassPersistenceNews news = new WxMpMassPersistenceNews();
        WxMpMassPersistenceNews.WxMpMassPersistenceNewsArticle article = new WxMpMassPersistenceNews.WxMpMassPersistenceNewsArticle();
        article.setAuthor("test");
        article.setContent("heheheh");
        article.setContentSourceUrl("http://www.baidu.com/");
        article.setDigest("hahahah");
        article.setShowCoverPic(true);
        article.setThumbMediaId("PW3nBzskhe1bbJUK_5j_EqCxX2nMuYyWYHm9FryqFyA");
        article.setTitle("titleeee");
        news.addArticle(article);
        WxMediaPersistenceUploadResult image = wxService.massNewsPersistenceUpload(news);
        System.out.println(image.getMediaId());
        System.out.println(image.getUrl());
    }


    public void testUploadNewsUpdate() throws WxErrorException {
        WxMpMassPersistenceNewsUpdate news = new WxMpMassPersistenceNewsUpdate();
        news.setIndex(0);
        news.setMediaId("AA4tkWeauiGe-h9TyFx1Lm9k4bzyNtSvS__aBDZsv5E");
        WxMpMassPersistenceNewsUpdate.WxMpMassPersistenceNewsArticle article = new WxMpMassPersistenceNewsUpdate.WxMpMassPersistenceNewsArticle();
        article.setAuthor("test");
        article.setContent("heheheh");
        article.setContentSourceUrl("http://www.baidu.com/");
        article.setDigest("hahahah");
        article.setShowCoverPic(true);
        article.setThumbMediaId("PW3nBzskhe1bbJUK_5j_EqCxX2nMuYyWYHm9FryqFyA");
        article.setTitle("titleeee");
        news.setArticle(article);
        String content = wxService.massNewsPersistenceUpdate(news);
        System.out.println(content);

    }


    @Test
    public void testDelete() throws WxErrorException {
        System.out.println(wxService);
        String mediaDelete = wxService.mediaDelete("1AA4t12kWeauiGe-h9TyFx1Lm9k4bzyNtSvS__aBDZsv5E");
        System.out.println(mediaDelete);
    }


//
//
//    public void testUploadVideo() throws WxErrorException {
//
//        AddMpMassVideo video = new AddMpMassVideo();
//        video.setFile(new File("/home/linjie/Videos/1.mp4"));
//        video.setTitle("ceshi");
//        video.setIntroduction("testestest");
//
//        System.out.println(wxService);
//        WxMediaPersistenceUploadResult image = wxService.massPersistenceVideoUpload(video);
//        System.out.println(image.getMediaId());
//        System.out.println(image.getUrl());
//    }


}
