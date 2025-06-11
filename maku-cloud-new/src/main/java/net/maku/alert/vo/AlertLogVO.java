package net.maku.alert.vo;

import lombok.Data;

/**
 * @Author: krislorem
 * @Package: net.maku.alert.vo
 * @Project: smart_school_cloud
 * @name: AlertLogVO
 * @Date: 2025/6/11 18:43
 * @FileName: AlertLogVO
 * @description:
 */
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
