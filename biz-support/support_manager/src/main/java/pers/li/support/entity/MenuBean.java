package pers.li.support.entity;

public class MenuBean {
    private Short id;

    private String menuCode;

    private String menuName;

    private String menuParent;

    private String menuUrl;

    private String menuImages;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuParent() {
        return menuParent;
    }

    public void setMenuParent(String menuParent) {
        this.menuParent = menuParent;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuImages() {
        return menuImages;
    }

    public void setMenuImages(String menuImages) {
        this.menuImages = menuImages;
    }
}