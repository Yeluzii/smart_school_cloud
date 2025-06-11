package net.maku.iot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.iot.dto.BatchSaveDTO;
import net.maku.iot.service.TDeviceGroupService;
import net.maku.iot.query.TDeviceGroupQuery;
import net.maku.iot.vo.*;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * tdg
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/iot/group/device")
@Tag(name="tdg")
@AllArgsConstructor
public class TDeviceGroupController {
    private final TDeviceGroupService tDeviceGroupService;
    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('iot:group:device:page')")
    public Result<PageResult<TDeviceGroupVO>> page(@ParameterObject @Valid TDeviceGroupQuery query){
        PageResult<TDeviceGroupVO> page = tDeviceGroupService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('iot:group:device:get')")
    public Result<List<TDeviceGroupVO>> get(@PathVariable("id") Long groupId){
        List<TDeviceGroupVO> data = tDeviceGroupService.get(groupId);

        return Result.ok(data);
    }
    @GetMapping("get/devicetype")
    @Operation(summary = "信息")
    public Result<Integer> getDeviceType(@RequestParam("deviceId") Long deviceId){
        Integer data = tDeviceGroupService.getDeviceType(deviceId);

        return Result.ok(data);
    }
    @GetMapping("get/{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('iot:group:device:get')")
    public Result<List<DeviceVO>> selectDeviceIdsByGroupId(@PathVariable("id") Long groupId){
        List<DeviceVO> data = tDeviceGroupService.selectDeviceIdsByGroupId(groupId);

        return Result.ok(data);
    }
    @GetMapping("get/group")
    @Operation(summary = "分组")
    public Result<List<UserGroupVO>> selectGroupIdsByUserId(@RequestParam("userId") Long userId){
        List<UserGroupVO> data = tDeviceGroupService.selectGroupIdsByUserId(userId);

        return Result.ok(data);
    }
    @GetMapping("get/device")
    @Operation(summary = "设备")
    public Result<List<UserDeviceVO>> selectDevicesByGroupId(@RequestParam("groupId") Long groupId){
        List<UserDeviceVO> data = tDeviceGroupService.selectDevicesByGroupId(groupId);

        return Result.ok(data);
    }
    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('iot:group:device:save')")
    public Result<String> save(@RequestBody TDeviceGroupVO vo){
        tDeviceGroupService.save(vo);

        return Result.ok();
    }

    @PostMapping("batchSave")
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('iot:group:device:batchsave')")
    public Result<String> batchSave(@RequestBody BatchSaveDTO dto){
        System.out.println("批量保存" + dto.getIds());
        tDeviceGroupService.batchSave(dto.getIds(), dto.getGroupId());
        return Result.ok();
    }
    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('iot:group:device:update')")
    public Result<String> update(@RequestBody @Valid TDeviceGroupVO vo){
        tDeviceGroupService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('iot:group:device:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tDeviceGroupService.delete(idList);

        return Result.ok();
    }


}
