package io.kotlinthree.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jameson on 12/19/15.
 */
public class News implements Serializable {
    /**
     * images : ["http://pic3.zhimg.com/efa8562f213a32c6dad098370b401c4a.jpg"]
     * type : 0
     * id : 7615728
     * ga_prefix : 121916
     * title : 张艺谋一直没能拿下奥斯卡，可能真的差一点运气
     * <p/>
     * "image_source": "《金陵十三钗》",
     * "title": "张艺谋一直没能拿下奥斯卡，可能真的差一点运气",
     * "image": "http://pic2.zhimg.com/2116d3ce66353e13e5d89f7de21a50e5.jpg",
     * "share_url": "http://daily.zhihu.com/story/7615728",
     * "js": [],
     * "ga_prefix": "121916",
     * "type": 0,
     * "id": 7615728,
     * "css": [
     * "http://news.at.zhihu.com/css/news_qa.auto.css?v=77778"
     * ]
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private String body;
    private List<String> images;
    private String image;
    private String image_source;
    private String share_url;
    private List<String> js;
    private List<String> css;

    public String getImage() {
        return image;
    }

    public String getImage_source() {
        return image_source;
    }

    public String getShare_url() {
        return share_url;
    }

    public List<String> getJs() {
        return js;
    }

    public List<String> getCss() {
        return css;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getImages() {
        return images;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
