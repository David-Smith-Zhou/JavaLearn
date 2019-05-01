package net.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SettingBean {

    @SerializedName("setting_list")
    private List<ListItemBean> setting_list;
    @SerializedName("sort_list")
    private List<ListItemBean> sort_list;
    @SerializedName("radius_list")
    private List<ListItemBean> radius_list;


    public void setRadius_list(List<ListItemBean> radius_list) {
        this.radius_list = radius_list;
    }

    public void setSetting_list(List<ListItemBean> setting_list) {
        this.setting_list = setting_list;
    }

    public void setSort_list(List<ListItemBean> sort_list) {
        this.sort_list = sort_list;
    }

    public List<ListItemBean> getRadius_list() {
        return radius_list;
    }

    public List<ListItemBean> getSetting_list() {
        return setting_list;
    }

    public List<ListItemBean> getSort_list() {
        return sort_list;
    }

    public static class ListItemBean {
        @SerializedName("class_id")
        private int class_id;
        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private int id;
        @SerializedName("sort")
        private int sort;
        @SerializedName("selected")
        private int selected;

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getClass_id() {
            return class_id;
        }

        public int getId() {
            return id;
        }

        public int getSelected() {
            return selected;
        }

        public int getSort() {
            return sort;
        }

        public String getName() {
            return name;
        }
    }

}
