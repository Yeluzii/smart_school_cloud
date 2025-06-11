package net.maku.alert.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: krislorem
 * @Package: net.maku.alert.dto
 * @Project: smart_school_cloud
 * @name: BatchSaveDTO
 * @Date: 2025/6/11 16:00
 * @FileName: BatchSaveDTO
 * @description:
 */
@Data
public class BatchSaveDTO {
    private List<Long> ids;
    private Long alertId;
}
