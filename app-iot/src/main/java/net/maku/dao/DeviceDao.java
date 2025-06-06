package net.maku.dao;

import net.maku.entity.Device;
import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeviceDao extends BaseDao<Device> {
    List<Device> getList(Map<String,Object> params);
}
