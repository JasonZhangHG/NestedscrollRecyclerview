package cool.android.nestedscrollrecyclerview;

public class MainDataBean {

    private String title;

    public MainDataBean(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MainDataBean{" +
                "title='" + title + '\'' +
                '}';
    }
}
