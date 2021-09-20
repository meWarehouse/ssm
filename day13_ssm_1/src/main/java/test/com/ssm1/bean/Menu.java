package test.com.ssm1.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author zero
 * @create 2020-06-11 13:27
 */
public class Menu {

    private Integer id;
    @JsonProperty("title")
    private String name;
    private String url;
    private Integer pid;

    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                '}';
    }
}
