package net.maku.module.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsVO {
    private Long id;
    private String title;
    private String cover;
    private String content;
    private LocalDateTime createTime;
}
