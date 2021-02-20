package top.summus.notionmiddleware.vo.moji;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MojiGetBookWordsResponseVo {


    /**
     * result : {"bookInfo1":[{"createdAt":"2019-10-21T16:37:01.860Z",
     * "updatedAt":"2021-01-25T16:09:03.728Z","email":"zongyang_liu@outlook.com","name":"summus",
     * "followedFoldersNum":1,"activityNum":5,"objectId":"E7PAY0QnL2"}],"bookInfo2":[{"createdBy
     * ":"E7PAY0QnL2","isShared":false,"title":"2-1","hasCover":false,
     * "updatedAt":"2021-02-09T10:20:42.383Z","viewedNum":6,"itemsNum":72,"objectId":"mXiwejAEKj"
     * }],"fid":"mXiwejAEKj","pageIndex":1,"sortType":0,"size":72,"totalPage":3,"code":200,
     * "wordMeta":[{"createdBy":"E7PAY0QnL2","updatedBy":"E7PAY0QnL2","appId":"com.mojitec
     * .mojidict","langEnv":"zh-CN_ja","targetId":"198939417","targetType":102,"title":"楽しむ",
     * "parentFolderId":"mXiwejAEKj","targetUserId":"moji","createdAt":"2021-02-05T17:04:16
     * .906Z","updatedAt":"2021-02-05T17:04:16.906Z","objectId":"weZxvAJmHk",
     * "pids":["mXiwejAEKj"],"wordContent":{"excerpt":"[一类·他动] 乐，快乐；享受，欣赏。（心をよろこばせる。）
     * 以\u2026\u2026为消遣，使快活。（なぐさめる。） ","spell":"楽しむ","accent":"③","pron":"たのしむ",
     * "romaji":"tanosimu","createdAt":"2019-05-07T03:48:35.434Z",
     * "updatedAt":"2020-08-27T10:28:57.893Z","objectId":"198939417"}}]}
     */

    @JsonProperty("result")
    private ResultDTO result;


    @NoArgsConstructor
    @Data
    public static class ResultDTO {
        /**
         * bookInfo1 : [{"createdAt":"2019-10-21T16:37:01.860Z","updatedAt":"2021-01-25T16:09:03
         * .728Z","email":"zongyang_liu@outlook.com","name":"summus","followedFoldersNum":1,
         * "activityNum":5,"objectId":"E7PAY0QnL2"}]
         * bookInfo2 : [{"createdBy":"E7PAY0QnL2","isShared":false,"title":"2-1",
         * "hasCover":false,"updatedAt":"2021-02-09T10:20:42.383Z","viewedNum":6,"itemsNum":72,
         * "objectId":"mXiwejAEKj"}]
         * fid : mXiwejAEKj
         * pageIndex : 1
         * sortType : 0
         * size : 72
         * totalPage : 3
         * code : 200
         * wordMeta : [{"createdBy":"E7PAY0QnL2","updatedBy":"E7PAY0QnL2","appId":"com.mojitec
         * .mojidict","langEnv":"zh-CN_ja","targetId":"198939417","targetType":102,"title":"楽しむ",
         * "parentFolderId":"mXiwejAEKj","targetUserId":"moji","createdAt":"2021-02-05T17:04:16
         * .906Z","updatedAt":"2021-02-05T17:04:16.906Z","objectId":"weZxvAJmHk",
         * "pids":["mXiwejAEKj"],"wordContent":{"excerpt":"[一类·他动] 乐，快乐；享受，欣赏。（心をよろこばせる。）
         * 以\u2026\u2026为消遣，使快活。（なぐさめる。） ","spell":"楽しむ","accent":"③","pron":"たのしむ",
         * "romaji":"tanosimu","createdAt":"2019-05-07T03:48:35.434Z",
         * "updatedAt":"2020-08-27T10:28:57.893Z","objectId":"198939417"}}]
         */

        @JsonProperty("1")
        private List<BookInfo1DTO> bookInfo1;
        @JsonProperty("1000")
        private List<BookInfo2DTO> bookInfo2;
        @JsonProperty("fid")
        private String fid;
        @JsonProperty("pageIndex")
        private Integer pageIndex;
        @JsonProperty("sortType")
        private Integer sortType;
        @JsonProperty("size")
        private Integer size;
        @JsonProperty("totalPage")
        private Integer totalPage;
        @JsonProperty("code")
        private Integer code;
        @JsonProperty("result")
        private List<WordMetaDTO> wordMeta;

        @NoArgsConstructor
        @Data
        public static class BookInfo1DTO {
            /**
             * createdAt : 2019-10-21T16:37:01.860Z
             * updatedAt : 2021-01-25T16:09:03.728Z
             * email : zongyang_liu@outlook.com
             * name : summus
             * followedFoldersNum : 1
             * activityNum : 5
             * objectId : E7PAY0QnL2
             */

            @JsonProperty("createdAt")
            private String createdAt;
            @JsonProperty("updatedAt")
            private String updatedAt;
            @JsonProperty("email")
            private String email;
            @JsonProperty("name")
            private String name;
            @JsonProperty("followedFoldersNum")
            private Integer followedFoldersNum;
            @JsonProperty("activityNum")
            private Integer activityNum;
            @JsonProperty("objectId")
            private String objectId;
        }

        @NoArgsConstructor
        @Data
        public static class BookInfo2DTO {
            /**
             * createdBy : E7PAY0QnL2
             * isShared : false
             * title : 2-1
             * hasCover : false
             * updatedAt : 2021-02-09T10:20:42.383Z
             * viewedNum : 6
             * itemsNum : 72
             * objectId : mXiwejAEKj
             */

            @JsonProperty("createdBy")
            private String createdBy;
            @JsonProperty("isShared")
            private Boolean isShared;
            @JsonProperty("title")
            private String title;
            @JsonProperty("hasCover")
            private Boolean hasCover;
            @JsonProperty("updatedAt")
            private String updatedAt;
            @JsonProperty("viewedNum")
            private Integer viewedNum;
            @JsonProperty("itemsNum")
            private Integer itemsNum;
            @JsonProperty("objectId")
            private String objectId;
        }

        @NoArgsConstructor
        @Data
        public static class WordMetaDTO {
            /**
             * createdBy : E7PAY0QnL2
             * updatedBy : E7PAY0QnL2
             * appId : com.mojitec.mojidict
             * langEnv : zh-CN_ja
             * targetId : 198939417
             * targetType : 102
             * title : 楽しむ
             * parentFolderId : mXiwejAEKj
             * targetUserId : moji
             * createdAt : 2021-02-05T17:04:16.906Z
             * updatedAt : 2021-02-05T17:04:16.906Z
             * objectId : weZxvAJmHk
             * pids : ["mXiwejAEKj"]
             * wordContent : {"excerpt":"[一类·他动] 乐，快乐；享受，欣赏。（心をよろこばせる。）
             * 以\u2026\u2026为消遣，使快活。（なぐさめる。） ","spell":"楽しむ","accent":"③","pron":"たのしむ",
             * "romaji":"tanosimu","createdAt":"2019-05-07T03:48:35.434Z",
             * "updatedAt":"2020-08-27T10:28:57.893Z","objectId":"198939417"}
             */

            @JsonProperty("createdBy")
            private String createdBy;
            @JsonProperty("updatedBy")
            private String updatedBy;
            @JsonProperty("appId")
            private String appId;
            @JsonProperty("langEnv")
            private String langEnv;
            @JsonProperty("targetId")
            private String targetId;
            @JsonProperty("targetType")
            private Integer targetType;
            @JsonProperty("title")
            private String title;
            @JsonProperty("parentFolderId")
            private String parentFolderId;
            @JsonProperty("targetUserId")
            private String targetUserId;
            @JsonProperty("createdAt")
            private String createdAt;
            @JsonProperty("updatedAt")
            private String updatedAt;
            @JsonProperty("objectId")
            private String objectId;
            @JsonProperty("pids")
            private List<String> pids;
            @JsonProperty("target")
            private WordContentDTO wordContent;

            @NoArgsConstructor
            @Data
            public static class WordContentDTO {
                /**
                 * excerpt : [一类·他动] 乐，快乐；享受，欣赏。（心をよろこばせる。） 以……为消遣，使快活。（なぐさめる。）
                 * spell : 楽しむ
                 * accent : ③
                 * pron : たのしむ
                 * romaji : tanosimu
                 * createdAt : 2019-05-07T03:48:35.434Z
                 * updatedAt : 2020-08-27T10:28:57.893Z
                 * objectId : 198939417
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
                @JsonProperty("objectId")
                private String objectId;
            }
        }
    }
}
