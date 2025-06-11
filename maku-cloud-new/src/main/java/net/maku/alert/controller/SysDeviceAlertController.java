package net.maku.alert.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.alert.service.SysDeviceAlertService;
import net.maku.alert.query.SysDeviceAlertQuery;
import net.maku.alert.vo.SysDeviceAlertVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * d
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/sys/alert/device")
@Tag(name="d")
@AllArgsConstructor
public class SysDeviceAlertController {
    private final SysDeviceAlertService sysDeviceAlertService;

    @GetMapping("page")
    @Operation(summary = "分页")
    public Result<PageResult<SysDeviceAlertVO>> page(@ParameterObject @Valid SysDeviceAlertQuery query){
        PageResult<SysDeviceAlertVO> page = sysDeviceAlertService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<SysDeviceAlertVO> get(@PathVariable("id") Long id){
        SysDeviceAlertVO data = sysDeviceAlertService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    public Result<String> save(@RequestBody SysDeviceAlertVO vo){
        sysDeviceAlertService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    public Result<String> update(@RequestBody @Valid SysDeviceAlertVO vo){
        sysDeviceAlertService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    public Result<String> delete(@RequestBody List<Long> idList){
        sysDeviceAlertService.delete(idList);

        return Result.ok();
    }


}
