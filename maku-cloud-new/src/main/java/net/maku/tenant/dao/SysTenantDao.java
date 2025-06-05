package net.maku.tenant.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.tenant.entity.SysTenantEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysTenantDao extends BaseDao<SysTenantEntity> {

}