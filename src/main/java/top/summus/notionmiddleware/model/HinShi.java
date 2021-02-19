package top.summus.notionmiddleware.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("hinshi")
public class HinShi {
    @TableId(value = "hinshi_id", type = IdType.AUTO)
    private Long hinShiId;

    @TableField("spell")
    private String spell;

    @TableField("romaji")
    private String romaji;

    @TableField("pronun")
    private String pronun;

    @TableField("accent")
    private Integer accent;

    @TableField("meaning")
    private String meaning;

    @TableField("source_addition")
    private String sourceAddition;

    @TableField("status")
    private String status;

    @TableField("created")
    private LocalDateTime created;

    @TableField("updated")
    private LocalDateTime updated;

    @TableField("content")
    private String content;

    @TableField("moji_word_id")
    private Long mojiWordId;
}
