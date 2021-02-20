package top.summus.notionmiddleware.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("hinshi_source_relation")
public class HinShiSourceRelation {
    @TableId(value = "hinshi_source_relation_id", type = IdType.AUTO)
    private Long hinShiSourceRelationId;

    @TableField("hinshi_id")
    private Long hinShiId;

    @TableField("hinshi_source_id")
    private Long hinshiSourceId;
}
