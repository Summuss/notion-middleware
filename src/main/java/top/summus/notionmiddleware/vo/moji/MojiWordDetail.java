package top.summus.notionmiddleware.vo.moji;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import top.summus.notionmiddleware.util.JsonUtil;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Data
@Getter
@Setter
public class MojiWordDetail {

    /**
     * word : {"excerpt":"[名詞・形容動詞] 〈碁〉在终局时不属于任何一方的地方；单官。（囲碁で、双方の境にあってどちらの地に","spell":"駄目",
     * "accent":"②","pron":"だめ","romaji":"dame","createdAt":"2019-05-07T03:47:35.739Z",
     * "updatedAt":"2020-08-27T10:28:37.070Z","updatedBy":"isX02DXFUN","objectId":"198917171"}
     * details : [{"title":"名詞","index":0,"createdAt":"2019-05-07T03:47:36.713Z",
     * "updatedAt":"2019-10-24T12:53:34.361Z","wordId":"198917171","updatedBy":"isX02DXFUN",
     * "objectId":"15568"},{"title":"形容動詞","index":1,"createdAt":"2019-05-07T03:47:36.716Z",
     * "updatedAt":"2019-10-24T12:53:34.399Z","wordId":"198917171","updatedBy":"isX02DXFUN",
     * "objectId":"15570"}]
     * subdetails : [{"title":"〈碁〉在终局时不属于任何一方的地方；单官。（囲碁で、双方の境にあってどちらの地にもならない所。）","index":0,
     * "createdAt":"2019-05-07T03:47:38.481Z","updatedAt":"2019-10-24T12:58:19.569Z",
     * "wordId":"198917171","detailsId":"15568","updatedBy":"isX02DXFUN","objectId":"22544"},{
     * "title":"白费，无用（むだ）；无望。（望みなし。）","index":0,"createdAt":"2019-05-07T03:47:38.525Z",
     * "updatedAt":"2019-10-24T12:58:19.630Z","wordId":"198917171","detailsId":"15570",
     * "updatedBy":"isX02DXFUN","objectId":"22545"},{"createdBy":"isX02DXFUN",
     * "wordId":"198917171","detailsId":"15568","updatedBy":"isX02DXFUN",
     * "title":"对演员的提醒。（演劇で、演技などの悪い点について演出者が出す注意。）","index":1,"createdAt":"2019-10-11T08:30:56
     * .127Z","updatedAt":"2019-10-24T13:03:30.587Z","objectId":"5stD8XicWf"},{"title
     * ":"不行，不可以。（いけない。）","index":1,"createdAt":"2019-05-07T03:47:38.215Z",
     * "updatedAt":"2019-10-24T12:58:18.970Z","wordId":"198917171","detailsId":"15570",
     * "updatedBy":"isX02DXFUN","objectId":"22546"},{"title":"不好，坏。（わるい状態・不適。）","index":2,
     * "createdAt":"2019-05-07T03:47:38.681Z","updatedAt":"2019-10-24T12:58:19.821Z",
     * "wordId":"198917171","detailsId":"15570","updatedBy":"isX02DXFUN","objectId":"22547"},{
     * "title":"不行，不可能。（できない。）","index":3,"createdAt":"2019-05-07T03:47:38.679Z",
     * "updatedAt":"2019-10-24T12:58:19.804Z","wordId":"198917171","detailsId":"15570",
     * "updatedBy":"isX02DXFUN","objectId":"22548"}]
     * examples : [{"createdBy":"isX02DXFUN","wordId":"198917171","subdetailsId":"22544",
     * "updatedBy":"isX02DXFUN","title":"駄目を押す。","trans":"（围棋）收单官；再次确认，叮问。","index":0,
     * "createdAt":"2019-10-11T08:31:18.014Z","updatedAt":"2019-10-24T13:10:12.418Z",
     * "objectId":"9loIi6Z5uf"},{"title":"あの男は駄目だ。","index":0,"trans":"那个人不行（不好，不顶用）。",
     * "createdAt":"2019-05-07T03:47:39.800Z","updatedAt":"2019-10-24T13:06:20.436Z",
     * "wordId":"198917171","subdetailsId":"22547","updatedBy":"isX02DXFUN","objectId":"14387"},{
     * "title":"いくら言ったって駄目だ。","index":0,"trans":"怎样说也白费。","createdAt":"2019-05-07T03:47:39.933Z",
     * "updatedAt":"2019-10-24T13:06:22.031Z","wordId":"198917171","subdetailsId":"22545",
     * "updatedBy":"isX02DXFUN","objectId":"14381"},{"title":"きょうじゅうに仕上げるなんてことはとても駄目です。",
     * "index":0,"trans":"今天内完成根本不可能。","createdAt":"2019-05-07T03:47:39.933Z",
     * "updatedAt":"2019-10-24T13:06:22.044Z","wordId":"198917171","subdetailsId":"22548",
     * "updatedBy":"isX02DXFUN","objectId":"14389"},{"title":"あの人に会っては駄目だ。","index":0,
     * "trans":"不要见他。","createdAt":"2019-05-07T03:47:40.003Z","updatedAt":"2019-10-24T13:06:22
     * .121Z","wordId":"198917171","subdetailsId":"22546","updatedBy":"isX02DXFUN",
     * "objectId":"14384"},{"title":"彼は教師としては駄目だ。","index":1,"trans":"他当教师不行（不够格）。",
     * "createdAt":"2019-05-07T03:47:40.168Z","updatedAt":"2019-10-24T13:06:27.290Z",
     * "wordId":"198917171","subdetailsId":"22547","updatedBy":"isX02DXFUN","objectId":"14388"},{
     * "title":"駄目とあきらめる。","index":1,"trans":"认为没有指望而断念（放弃）。","createdAt":"2019-05-07T03:47:40
     * .268Z","updatedAt":"2019-10-24T13:06:27.490Z","wordId":"198917171","subdetailsId":"22545",
     * "updatedBy":"isX02DXFUN","objectId":"14382"},{"title":"泣いては駄目です。","index":1,
     * "trans":"不要哭。","createdAt":"2019-05-07T03:47:40.308Z","updatedAt":"2019-10-24T13:06:27
     * .538Z","wordId":"198917171","subdetailsId":"22546","updatedBy":"isX02DXFUN",
     * "objectId":"14385"},{"title":"よく考えなくちゃ駄目だよ。","index":2,"trans":"不好好考虑可不行；必须充分考虑。",
     * "createdAt":"2019-05-07T03:47:40.097Z","updatedAt":"2019-10-24T13:06:27.205Z",
     * "wordId":"198917171","subdetailsId":"22546","updatedBy":"isX02DXFUN","objectId":"14386"},{
     * "title":"駄目なことは何回やっても駄目だ。","index":2,"trans":"徒劳的事再干也白费。","createdAt":"2019-05-07T03:47:40
     * .258Z","updatedAt":"2019-10-24T13:06:27.416Z","wordId":"198917171","subdetailsId":"22545",
     * "updatedBy":"isX02DXFUN","objectId":"14383"}]
     */

    @JsonProperty("word")
    private Word word;
    @JsonProperty("details")
    private List<Detail> details;
    @JsonProperty("subdetails")
    private List<Subdetail> subdetails;
    @JsonProperty("examples")
    private List<Example> examples;

    @NoArgsConstructor
    @Data
    public static class Word {
        /**
         * excerpt : [名詞・形容動詞] 〈碁〉在终局时不属于任何一方的地方；单官。（囲碁で、双方の境にあってどちらの地に
         * spell : 駄目
         * accent : ②
         * pron : だめ
         * romaji : dame
         * createdAt : 2019-05-07T03:47:35.739Z
         * updatedAt : 2020-08-27T10:28:37.070Z
         * updatedBy : isX02DXFUN
         * objectId : 198917171
         */

        @JsonProperty("excerpt")
        private String excerpt;
        @JsonProperty("spell")
        private String spell;
        @JsonProperty("accent")
        private String accent;
        @JsonProperty("pron")
        private String pron;
        @JsonProperty("romaji")
        private String romaji;
        @JsonProperty("createdAt")
        private String createdAt;
        @JsonProperty("updatedAt")
        private String updatedAt;
        @JsonProperty("updatedBy")
        private String updatedBy;
        @JsonProperty("objectId")
        private String objectId;
    }

    @NoArgsConstructor
    @Data
    public static class Detail {
        /**
         * title : 名詞
         * index : 0
         * createdAt : 2019-05-07T03:47:36.713Z
         * updatedAt : 2019-10-24T12:53:34.361Z
         * wordId : 198917171
         * updatedBy : isX02DXFUN
         * objectId : 15568
         */

        @JsonProperty("title")
        private String title;
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("createdAt")
        private String createdAt;
        @JsonProperty("updatedAt")
        private String updatedAt;
        @JsonProperty("wordId")
        private String wordId;
        @JsonProperty("updatedBy")
        private String updatedBy;
        @JsonProperty("objectId")
        private String objectId;
    }

    @NoArgsConstructor
    @Data
    public static class Subdetail {
        /**
         * title : 〈碁〉在终局时不属于任何一方的地方；单官。（囲碁で、双方の境にあってどちらの地にもならない所。）
         * index : 0
         * createdAt : 2019-05-07T03:47:38.481Z
         * updatedAt : 2019-10-24T12:58:19.569Z
         * wordId : 198917171
         * detailsId : 15568
         * updatedBy : isX02DXFUN
         * objectId : 22544
         * createdBy : isX02DXFUN
         */

        @JsonProperty("title")
        private String title;
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("createdAt")
        private String createdAt;
        @JsonProperty("updatedAt")
        private String updatedAt;
        @JsonProperty("wordId")
        private String wordId;
        @JsonProperty("detailsId")
        private String detailsId;
        @JsonProperty("updatedBy")
        private String updatedBy;
        @JsonProperty("objectId")
        private String objectId;
        @JsonProperty("createdBy")
        private String createdBy;
    }

    @NoArgsConstructor
    @Data
    public static class Example {
        /**
         * createdBy : isX02DXFUN
         * wordId : 198917171
         * subdetailsId : 22544
         * updatedBy : isX02DXFUN
         * title : 駄目を押す。
         * trans : （围棋）收单官；再次确认，叮问。
         * index : 0
         * createdAt : 2019-10-11T08:31:18.014Z
         * updatedAt : 2019-10-24T13:10:12.418Z
         * objectId : 9loIi6Z5uf
         */

        @JsonProperty("createdBy")
        private String createdBy;
        @JsonProperty("wordId")
        private String wordId;
        @JsonProperty("subdetailsId")
        private String subdetailsId;
        @JsonProperty("updatedBy")
        private String updatedBy;
        @JsonProperty("title")
        private String title;
        @JsonProperty("trans")
        private String trans;
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("createdAt")
        private String createdAt;
        @JsonProperty("updatedAt")
        private String updatedAt;
        @JsonProperty("objectId")
        private String objectId;
    }

}
