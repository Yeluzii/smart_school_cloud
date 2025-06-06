package net.maku.tenant.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.tenant.vo.SysTenantVO;
import net.maku.tenant.query.SysTenantQuery;
import net.maku.tenant.entity.SysTenantEntity;
import java.util.List;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysTenantService extends BaseService<SysTenantEntity> {

    PageResult<SysTenantVO> page(SysTenantQuery query);

    SysTenantVO get(Long id);


    void save(SysTenantVO vo);

    void update(SysTenantVO vo);

    void delete(List<Long> idList);


}