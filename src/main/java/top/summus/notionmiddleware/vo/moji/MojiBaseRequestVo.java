package top.summus.notionmiddleware.vo.moji;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MojiBaseRequestVo<T> {

    @JsonProperty("_SessionToken")
    private String sessionToken;

    @JsonProperty("_ApplicationId")
    private String applicationId;

    @JsonProperty("_InstallationId")
    private String installationId;

    @JsonProperty("_ClientVersion")
    private String clientVersion;

    @JsonIgnore
    public abstract String url();

    @JsonIgnore
    public abstract Class<T> responseType();
}
