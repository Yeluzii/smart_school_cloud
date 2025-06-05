package net.maku.tenant.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.tenant.entity.SysPackageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 套餐管理
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysPackageDao extends BaseDao<SysPackageEntity> {

}