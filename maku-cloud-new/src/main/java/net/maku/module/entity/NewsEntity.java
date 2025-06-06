package net.maku.module.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@TableName("t_news")
public class NewsEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long tenantId;
    private String content;
    private String cover;
    @TableField("`banner`")
    private Integer banner;
    private Integer status;
    @TableField("isTop")
    private Integer isTop;
    private String author;
    private Integer type;
    private String title;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;
    private Long creator;
    private Long updater;
    private Integer version;
}
