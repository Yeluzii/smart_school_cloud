package net.maku.alert.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.util.Date;

/**
 * d
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class SysDeviceAlertExcelVO implements TransPojo {
    @ExcelIgnore
    private Long id;

    private Long alertId;

    private Long deviceId;

}
