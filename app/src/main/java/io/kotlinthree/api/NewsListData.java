package io.kotlinthree.api;

import java.util.List;

/**
 * Created by jameson on 12/19/15.
 */
public class NewsListData {

    /**
     * date : 20151219
     * stories : [{"images":["http://pic3.zhimg.com/efa8562f213a32c6dad098370b401c4a.jpg"],"type":0,"id":7615728,"ga_prefix":"121916","title":"张艺谋一直没能拿下奥斯卡，可能真的差一点运气"},{"images":["http://pic1.zhimg.com/ad45a34b98ea06f7724a817de734d8fc.jpg"],"type":0,"id":7596729,"ga_prefix":"121915","title":"明明有实力，可一到关键时刻就掉链子"},{"images":["http://pic4.zhimg.com/ebb0b9d9b016b74d01f08f84d5d35f57.jpg"],"type":0,"id":7623902,"ga_prefix":"121914","title":"听到悲伤的音乐也跟着悲伤，主要还是心中有放不下的记忆"},{"images":["http://pic1.zhimg.com/e5d49165869ddda2b3f09b6376c6958c.jpg"],"type":0,"id":7613816,"ga_prefix":"121913","title":"比起「隐私部位」，更应该从小就知道的是「身体权」"},{"images":["http://pic1.zhimg.com/de7791562f948a1968ae0516f44c50b8.jpg"],"type":0,"id":7618965,"ga_prefix":"121912","title":"做个特效，真的不是 5 毛钱可以搞定的"},{"images":["http://pic1.zhimg.com/46725fe8a82145aacd7ce78893929538.jpg"],"type":0,"id":7613173,"ga_prefix":"121911","title":"香香的、滑滑的，聚会时候一定会忍不住吃光这份饭"},{"images":["http://pic3.zhimg.com/0d4f4a439a0913f89738197d102b18d2.jpg"],"type":0,"id":7608317,"ga_prefix":"121910","title":"走到哪都能听见的爱乐乐团，是一个地位特殊的庞大组织"},{"images":["http://pic4.zhimg.com/9a79d6be3a24861e586c6eee89144d43.jpg"],"type":0,"id":7619784,"ga_prefix":"121909","title":"官员、银行家、高管\u2026\u2026总觉得这些「精英」肯定信不过"},{"title":"《魂斗罗》中的角色，趴下的时候总是要「萝莉式屈腿俯卧」","ga_prefix":"121908","images":["http://pic1.zhimg.com/343db59b88d6754c3d6988f40f7d456c.jpg"],"multipic":true,"type":0,"id":7611185},{"images":["http://pic2.zhimg.com/c51610b16bc8974da7a110f56a37bad9.jpg"],"type":0,"id":7615718,"ga_prefix":"121907","title":"相比较其它地区，北京考生上清北有多大优势？"},{"images":["http://pic1.zhimg.com/d39ae3c757b0524f351c0874ad9f7fc0.jpg"],"type":0,"id":7531212,"ga_prefix":"121907","title":"买哪台电脑好，我真的是靠算出来的"},{"images":["http://pic2.zhimg.com/3b32ab44de832e50b6c4f119e0c07509.jpg"],"type":0,"id":7567902,"ga_prefix":"121907","title":"想在楼顶种一大片花花草草，慢慢来总会实现的"},{"images":["http://pic1.zhimg.com/08c1e536dede1ba73d414b8eed628030.jpg"],"type":0,"id":7621777,"ga_prefix":"121906","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;

    private List<News> stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<News> stories) {
        this.stories = stories;
    }

    public String getDate() {
        return date;
    }

    public List<News> getStories() {
        return stories;
    }

}
