package top.summus.notionmiddleware.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("hinshi_class_relation")
public class HinShiClassRelation {
    @TableId(value = "hinshi_class_relation_id", type = IdType.AUTO)
    private Long hinshiClassRelationId;

    @TableField("hinshi_id")
    private Long hinShiId;

    @TableField("hinshi_class_id")
    private Long hinShiClassId;
}
