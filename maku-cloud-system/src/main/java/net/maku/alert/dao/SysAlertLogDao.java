package net.maku.alert.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.alert.entity.SysAlertLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysAlertLogDao extends BaseDao<SysAlertLogEntity> {

}