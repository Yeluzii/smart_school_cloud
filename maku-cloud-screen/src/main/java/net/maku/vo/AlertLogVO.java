package net.maku.vo;

import lombok.Data;

@Data
public class AlertLogVO {
    private Long id;
    private String name;
    private String uid;
    private String alertName;
    private Integer alertLevel;
    private String createTime;
    private String alertInfo;
}
