package net.maku.system.service;

import net.maku.framework.mybatis.service.BaseService;
import net.maku.system.entity.SysTenantEntity;
import net.maku.system.vo.TenantVO;

import java.util.List;

public interface SysTenantService extends BaseService<SysTenantEntity> {
    List<TenantVO> getTenantList(String name);
}
