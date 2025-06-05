package net.maku.system.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.system.entity.SysTenantEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysTenantDao extends BaseDao<SysTenantEntity> {
}
