package club.klovec.pojo;

import java.io.Serializable;
import java.util.Date;

public class YhIteamsDesc implements Serializable{
    private Long iteamsId;

    private Date created;

    private Date updated;

    private String iteamsDesc;

    public Long getIteamsId() {
        return iteamsId;
    }

    public void setIteamsId(Long iteamsId) {
        this.iteamsId = iteamsId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getIteamsDesc() {
        return iteamsDesc;
    }

    public void setIteamsDesc(String iteamsDesc) {
        this.iteamsDesc = iteamsDesc == null ? null : iteamsDesc.trim();
    }
}