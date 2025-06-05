package net.maku.iot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.iot.service.SysGroupService;
import net.maku.iot.query.SysGroupQuery;
import net.maku.iot.vo.SysGroupVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * group
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/iot/group")
@Tag(name="group")
@AllArgsConstructor
public class SysGroupController {
    private final SysGroupService sysGroupService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('iot:group:page')")
    public Result<PageResult<SysGroupVO>> page(@ParameterObject @Valid SysGroupQuery query){
        PageResult<SysGroupVO> page = sysGroupService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('iot:group:page')")
    public Result<SysGroupVO> get(@PathVariable("id") Long id){
        SysGroupVO data = sysGroupService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('iot:group:save')")
    public Result<String> save(@RequestBody SysGroupVO vo){
        sysGroupService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('iot:group:update')")
    public Result<String> update(@RequestBody @Valid SysGroupVO vo){
        sysGroupService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('iot:group:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysGroupService.delete(idList);

        return Result.ok();
    }


}
