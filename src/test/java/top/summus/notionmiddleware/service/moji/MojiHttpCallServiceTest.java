package top.summus.notionmiddleware.service.moji;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.summus.notionmiddleware.vo.moji.MojiGetBookWordsRequestVo;
import top.summus.notionmiddleware.vo.moji.MojiGetBookWordsResponseVo;
import top.summus.notionmiddleware.vo.moji.MojiWordDetailRequestVo;
import top.summus.notionmiddleware.vo.moji.MojiWordDetailResponseVo;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MojiHttpCallServiceTest {
    @Autowired private MojiHttpCallService mojiHttpCallService;


    @Test
    void callMoji() {
        MojiGetBookWordsRequestVo getBookWordsRequestVo = new MojiGetBookWordsRequestVo();
        getBookWordsRequestVo.setFid("mXiwejAEKj");
        getBookWordsRequestVo.setPageIndex(1);
        getBookWordsRequestVo.setCount(30);
        getBookWordsRequestVo.setSortType(0);

        MojiGetBookWordsResponseVo responseVo = mojiHttpCallService.callMoji(getBookWordsRequestVo);
        System.out.println();
    }

    @Test
    void test_get_word_detail() {
        MojiWordDetailRequestVo requestVo = new MojiWordDetailRequestVo();
        requestVo.setWordIds(Arrays.asList("198939417", "198957661"));
        MojiWordDetailResponseVo mojiWordDetailResponseVo =
                mojiHttpCallService.callMoji(requestVo, MojiWordDetailResponseVo::fromResponseJson);
        System.out.println();
    }
}