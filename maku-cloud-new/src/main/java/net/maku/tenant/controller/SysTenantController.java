package net.maku.tenant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.tenant.dto.SysTenantDTO;
import net.maku.tenant.dto.UpdatePasswordDTO;
import net.maku.tenant.service.SysTenantService;
import net.maku.tenant.query.SysTenantQuery;
import net.maku.tenant.service.SysUserService;
import net.maku.tenant.vo.SysTenantVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/business/tenant")
@Tag(name="租户相关")
@AllArgsConstructor
public class SysTenantController {
    private final SysTenantService sysTenantService;
    private final SysUserService sysUserService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('business:tenant:page')")
    public Result<PageResult<SysTenantVO>> page(@ParameterObject @Valid SysTenantQuery query){
        PageResult<SysTenantVO> page = sysTenantService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('business:tenant:info')")
    public Result<SysTenantVO> get(@PathVariable("id") Long id){
        SysTenantVO data = sysTenantService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('business:tenant:save')")
    public Result<String> save(@RequestBody SysTenantDTO dto){
        sysTenantService.save(dto);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('business:tenant:update')")
    public Result<String> update(@RequestBody @Valid SysTenantDTO dto){
        sysTenantService.update(dto);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('business:tenant:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysTenantService.delete(idList);

        return Result.ok();
    }

    @PostMapping("password")
    @Operation(summary = "修改密码")
    public Result<String> updatePassword(@RequestBody UpdatePasswordDTO dto){
        sysTenantService.updatePassword(dto);
        sysUserService.updateUserPassword(dto);
        return Result.ok();
    }

}