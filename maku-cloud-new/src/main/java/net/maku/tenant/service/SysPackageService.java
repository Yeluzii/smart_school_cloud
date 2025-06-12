package net.maku.tenant.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.tenant.vo.SysPackageVO;
import net.maku.tenant.query.SysPackageQuery;
import net.maku.tenant.entity.SysPackageEntity;
import java.util.List;

/**
 * 套餐管理
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysPackageService extends BaseService<SysPackageEntity> {
    List<SysPackageVO> getPackageList(String name);

    PageResult<SysPackageVO> page(SysPackageQuery query);

    SysPackageVO get(Long id);


    void save(SysPackageVO vo);

    void update(SysPackageVO vo);

    void delete(List<Long> idList);


}