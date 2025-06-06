package net.maku.tenant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.tenant.dao.SysRoleDao;
import net.maku.tenant.service.RoleService;
import net.maku.tenant.service.SysPackageService;
import net.maku.tenant.query.SysPackageQuery;
import net.maku.tenant.vo.RoleVO;
import net.maku.tenant.vo.SysPackageVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 套餐管理
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/business/package")
@Tag(name="套餐管理")
@AllArgsConstructor
public class SysPackageController {
    private final SysPackageService sysPackageService;
    private final RoleService  roleService;

    @GetMapping("roleList")
    public Result<List<RoleVO>> roleList(@RequestParam(required = false) String name){
        return Result.ok(roleService.getRoleList(name));
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('business:package:page')")
    public Result<PageResult<SysPackageVO>> page(@ParameterObject @Valid SysPackageQuery query){
        PageResult<SysPackageVO> page = sysPackageService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('business:package:info')")
    public Result<SysPackageVO> get(@PathVariable("id") Long id){
        SysPackageVO data = sysPackageService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('business:package:save')")
    public Result<String> save(@RequestBody SysPackageVO vo){
        sysPackageService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('business:package:update')")
    public Result<String> update(@RequestBody @Valid SysPackageVO vo){
        sysPackageService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('business:package:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysPackageService.delete(idList);

        return Result.ok();
    }


}