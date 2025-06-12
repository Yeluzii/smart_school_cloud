package net.maku.iot.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: krislorem
 * @Package: net.maku.iot.dto
 * @Project: smart_school_cloud
 * @name: BatchSaveDTO
 * @Date: 2025/6/5 22:47
 * @FileName: BatchSaveDTO
 * @description:
 */
@Data // Lombok注解
public class BatchSaveDTO {
    private List<Long> ids;
    private Long groupId;
}
