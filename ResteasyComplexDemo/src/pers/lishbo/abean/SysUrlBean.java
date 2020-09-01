package pers.lishbo.abean;

public class SysUrlBean {
    private Integer id;

    private String code;

    private String url;

    private String urlDesc;

    private Byte isuse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlDesc() {
        return urlDesc;
    }

    public void setUrlDesc(String urlDesc) {
        this.urlDesc = urlDesc;
    }

    public Byte getIsuse() {
        return isuse;
    }

    public void setIsuse(Byte isuse) {
        this.isuse = isuse;
    }

	@Override
	public String toString() {
		return "SysUrlBean [id=" + id + ", code=" + code + ", url=" + url
				+ ", urlDesc=" + urlDesc + ", isuse=" + isuse + "]";
	}
    
}