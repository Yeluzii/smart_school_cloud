package net.maku.business.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import net.maku.framework.mybatis.entity.BaseEntity;

/**
 * 资讯表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_news")
public class TNewsEntity extends BaseEntity {

	/**
	* 租户id
	*/
	@TableField(value = "tenant_id")
	private Long tenantId;

	/**
	* 内容
	*/
	@TableField(value = "content")
	private String content;

	/**
	* 封面
	*/
	@TableField(value = "cover")
	private String cover;

	/**
	* 0不轮播 1轮播
	*/
	@TableField(value = "banner")
	private Integer banner;

	/**
	* 0未发布 1已发布
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 0不置顶 1置顶
	*/
	@TableField(value = "isTop")
	private Integer istop;

	/**
	* 作者
	*/
	@TableField(value = "author")
	private String author;

	/**
	* 0公告 1校园信息
	*/
	@TableField(value = "type")
	private Integer type;

	/**
	* 标题
	*/
	@TableField(value = "title")
	private String title;







}