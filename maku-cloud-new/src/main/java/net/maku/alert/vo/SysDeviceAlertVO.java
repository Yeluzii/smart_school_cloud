package net.maku.alert.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.util.Date;

/**
 * d
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "d")
public class SysDeviceAlertVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long alertId;

    private Long deviceId;

    private Integer deleted;

}
