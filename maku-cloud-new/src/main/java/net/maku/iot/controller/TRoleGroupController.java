package net.maku.iot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.iot.dto.BatchSaveDTO;
import net.maku.iot.service.TRoleGroupService;
import net.maku.iot.query.TRoleGroupQuery;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.vo.RoleVO;
import net.maku.iot.vo.TRoleGroupVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * trg
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/iot/group/role")
@Tag(name="trg")
@AllArgsConstructor
public class TRoleGroupController {
    private final TRoleGroupService tRoleGroupService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('iot:group:role:page')")
    public Result<PageResult<TRoleGroupVO>> page(@ParameterObject @Valid TRoleGroupQuery query){
        PageResult<TRoleGroupVO> page = tRoleGroupService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('iot:group:role:get')")
    public Result<List<TRoleGroupVO>> get(@PathVariable("id") Long id){
        List<TRoleGroupVO> data = tRoleGroupService.get(id);

        return Result.ok(data);
    }
    @GetMapping("get/{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('iot:group:role:get')")
    public Result<List<RoleVO>> selectRoleIdsByGroupId(@PathVariable("id") Long groupId){
        List<RoleVO> data = tRoleGroupService.selectRoleIdsByGroupId(groupId);

        return Result.ok(data);
    }
    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('iot:group:role:save')")
    public Result<String> save(@RequestBody TRoleGroupVO vo){
        tRoleGroupService.save(vo);

        return Result.ok();
    }
    @PostMapping("batchSave")
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('iot:group:role:save')")
    public Result<String> batchSave(@RequestBody BatchSaveDTO dto){
        System.out.println("批量保存" + dto.getIds());
        tRoleGroupService.batchSave(dto.getIds(), dto.getGroupId());
        return Result.ok();
    }
    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('iot:group:role:update')")
    public Result<String> update(@RequestBody @Valid TRoleGroupVO vo){
        tRoleGroupService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('iot:group:role:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tRoleGroupService.delete(idList);

        return Result.ok();
    }


}
