package net.maku.alert.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.alert.vo.AlertLogVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.alert.service.SysAlertLogService;
import net.maku.alert.query.SysAlertLogQuery;
import net.maku.alert.vo.SysAlertLogVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/alert/log")
@Tag(name="告警记录表")
@AllArgsConstructor
public class SysAlertLogController {
    private final SysAlertLogService sysAlertLogService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('alert:log:page')")
    public Result<PageResult<SysAlertLogVO>> page(@ParameterObject @Valid SysAlertLogQuery query){
        PageResult<SysAlertLogVO> page = sysAlertLogService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('alert:log:page')")
    public Result<SysAlertLogVO> get(@PathVariable("id") Long id){
        SysAlertLogVO data = sysAlertLogService.get(id);

        return Result.ok(data);
    }


    @GetMapping("list")
    @Operation(summary = "分页")
    public Result<List<AlertLogVO>> getAlertLogList(){
        List<AlertLogVO> alertLogList = sysAlertLogService.getAlertLogList();

        return Result.ok(alertLogList);
    }


}
