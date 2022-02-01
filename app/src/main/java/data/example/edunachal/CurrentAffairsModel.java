package data.example.edunachal;
public class CurrentAffairsModel {
    String content;
    String tag;
    long timestamp;
    String title;

    public CurrentAffairsModel() {
    }

    public CurrentAffairsModel(String title2, String content2, String tag2, long timestamp2) {
        this.title = title2;
        this.content = content2;
        this.tag = tag2;
        this.timestamp = timestamp2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag2) {
        this.tag = tag2;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp2) {
        this.timestamp = timestamp2;
    }
}