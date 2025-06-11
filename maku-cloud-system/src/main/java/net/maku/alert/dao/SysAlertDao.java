package net.maku.alert.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.alert.entity.SysAlertEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 告警配置表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysAlertDao extends BaseDao<SysAlertEntity> {

}