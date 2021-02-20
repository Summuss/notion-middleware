package top.summus.notionmiddleware.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("hinshi_source")
public class HinShiSource {
    @TableId(value = "hinshi_source_id", type = IdType.AUTO)
    private Long hinShiSourceId;

    private String source;
}
