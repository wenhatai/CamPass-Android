package net.bingyan.campass.module.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ant on 14-8-9.
 */
public class NewsListBean {

    @Expose
    private String status;
    @Expose
    private List<Articlelist> articlelist = new ArrayList<Articlelist>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Articlelist> getArticlelist() {
        return articlelist;
    }

    public void setArticlelist(List<Articlelist> articlelist) {
        this.articlelist = articlelist;
    }

    public class Articlelist {

        @SerializedName("Id")
        @Expose
        private String id;
        @SerializedName("Title")
        @Expose
        private String title;
        @SerializedName("PublishDate")
        @Expose
        private String publishDate;
        @SerializedName("Titlepic")
        @Expose
        private String titlepic;
        @Expose
        private String brief;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getTitlepic() {
            return titlepic;
        }

        public void setTitlepic(String titlepic) {
            this.titlepic = titlepic;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

    }
}