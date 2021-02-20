package top.summus.notionmiddleware.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("hinshi_class")
public class HinShiClass {
    @TableId(value = "hinshi_class_id", type = IdType.AUTO)
    private Long hinShiClassId;

    @TableField("class_name")
    private String className;
}
