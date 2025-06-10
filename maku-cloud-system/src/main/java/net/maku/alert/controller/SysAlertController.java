package net.maku.alert.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.alert.service.SysAlertService;
import net.maku.alert.query.SysAlertQuery;
import net.maku.alert.vo.SysAlertVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 告警配置表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/sys/alert")
@Tag(name="告警配置表")
@AllArgsConstructor
public class SysAlertController {
    private final SysAlertService sysAlertService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:alert:page')")
    public Result<PageResult<SysAlertVO>> page(@ParameterObject @Valid SysAlertQuery query){
        PageResult<SysAlertVO> page = sysAlertService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:alert:get')")
    public Result<SysAlertVO> get(@PathVariable("id") Long id){
        SysAlertVO data = sysAlertService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('sys:alert:save')")
    public Result<String> save(@RequestBody SysAlertVO vo){
        sysAlertService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('sys:alert:update')")
    public Result<String> update(@RequestBody @Valid SysAlertVO vo){
        sysAlertService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('sys:alert:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysAlertService.delete(idList);

        return Result.ok();
    }


}