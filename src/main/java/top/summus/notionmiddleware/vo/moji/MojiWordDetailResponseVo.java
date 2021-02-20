package top.summus.notionmiddleware.vo.moji;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import top.summus.notionmiddleware.util.JsonUtil;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Getter
@Setter
public class MojiWordDetailResponseVo {
    List<MojiWordDetail> wordDetailList;

    @SneakyThrows
    public static MojiWordDetailResponseVo fromResponseJson(String json) {
        JsonNode jsonNode = JsonUtil.objectMapper.readTree(json);
        JsonNode resultNode = jsonNode.at("/result/result");
        List<MojiWordDetail> mojiWordDetailList =
                StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(
                                resultNode.iterator(), Spliterator.ORDERED),
                        false)
                        .map(JsonNode::toString)
                        .map(s -> JsonUtil.toObj(s, MojiWordDetail.class))
                        .collect(Collectors.toList());
        return new MojiWordDetailResponseVo(mojiWordDetailList);
    }
}
