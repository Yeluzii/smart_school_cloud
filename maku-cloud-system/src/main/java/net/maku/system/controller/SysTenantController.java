package net.maku.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.Result;
import net.maku.system.service.SysTenantService;
import net.maku.system.vo.TenantVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/tenant")
@Tag(name = "租户管理")
@AllArgsConstructor
public class SysTenantController {
    private final SysTenantService sysTenantService;

    @GetMapping("list")
    @Operation(summary = "租户列表")
    public Result<List<TenantVO>> list(@RequestParam(required = false) String name){
        return Result.ok(sysTenantService.getTenantList(name));
    }
}
