package top.summus.notionmiddleware.vo.moji;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MojiGetBookWordsRequestVo extends MojiBaseRequestVo<MojiGetBookWordsResponseVo> {

    @JsonProperty("fid")
    private String fid;

    @JsonProperty("pageIndex")
    private Integer pageIndex;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("sortType")
    private Integer sortType;

    @Override
    public String url() {
        return "/folder-fetchContentWithRelatives";
    }

    @Override
    public Class<MojiGetBookWordsResponseVo> responseType() {
        return MojiGetBookWordsResponseVo.class;
    }
}
