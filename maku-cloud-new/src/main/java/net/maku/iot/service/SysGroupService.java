package net.maku.iot.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.iot.vo.SysGroupVO;
import net.maku.iot.query.SysGroupQuery;
import net.maku.iot.entity.SysGroupEntity;
import java.util.List;

/**
 * group
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysGroupService extends BaseService<SysGroupEntity> {

    PageResult<SysGroupVO> page(SysGroupQuery query);

    SysGroupVO get(Long id);


    void save(SysGroupVO vo);

    void update(SysGroupVO vo);

    void delete(List<Long> idList);


}