package top.summus.notionmiddleware.vo.moji;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Data
@Getter
@Setter
public class MojiWordDetailRequestVo extends MojiBaseRequestVo<MojiWordDetailResponseVo> {

    /**
     * wordIds : ["198939417"] skipAccessories : false
     */
    @JsonProperty("wordIds")
    private List<String> wordIds;

    @JsonProperty("skipAccessories")
    private Boolean skipAccessories = false;

    @Override
    public String url() {
        return "/fetchManyWords";
    }

    @Override
    public Class<MojiWordDetailResponseVo> responseType() {
        return MojiWordDetailResponseVo.class;
    }
}
