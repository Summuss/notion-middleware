package top.summus.notionmiddleware.service.moji;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.summus.notionmiddleware.property.ApiProperties;
import top.summus.notionmiddleware.util.HttpUtil;
import top.summus.notionmiddleware.util.JsonUtil;
import top.summus.notionmiddleware.vo.moji.MojiBaseRequestVo;

@Service
public class MojiHttpCallService {
    @Autowired private ApiProperties apiProperties;

    @SneakyThrows
    public <R, T extends MojiBaseRequestVo<R>> R callMoji(
            T requestVo, Deserializer<R> deserializer) {

        requestVo.setApplicationId(apiProperties.getMojiApplicationId());
        requestVo.setClientVersion(apiProperties.getClientVersion());
        requestVo.setSessionToken(apiProperties.getMojiSessionToken());
        requestVo.setInstallationId(apiProperties.getMojiInstallationId());

        HttpUtil.ResponseEntity responseEntity =
                HttpUtil.postJson(
                        apiProperties.getMojiApiUrlPrefix() + requestVo.url(),
                        null,
                        JsonUtil.toJson(requestVo));
        if (responseEntity.getCode() != 200) {
            throw new RuntimeException(String.format("error code %d", responseEntity.getCode()));
        }
        if (deserializer != null) {
            return deserializer.deserialize(responseEntity.getContent());
        } else {
            return JsonUtil.toObj(responseEntity.getContent(), requestVo.responseType());
        }
    }

    public <R, T extends MojiBaseRequestVo<R>> R callMoji(T requestVo) {
        return callMoji(requestVo, null);
    }

    public interface Deserializer<T> {
        T deserialize(String content);
    }
}
