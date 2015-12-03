package dicdic.controller.dictionary;

import dicdic.controller.dictionary.req.InsertDictionaryReq;
import dicdic.controller.dictionary.req.SelectDictionariesListReq;
import dicdic.controller.dictionary.req.SelectDictionaryReq;
import dicdic.controller.dictionary.res.InsertDictionaryRes;
import dicdic.controller.dictionary.res.SelectDictionariesListRes;
import dicdic.controller.dictionary.res.SelectDictionaryRes;
import dicdic.service.dictionary.DictionaryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.adrianwalker.multilinestring.Multiline;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/dic")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public SelectDictionariesListRes selectDictionariesList(@Valid SelectDictionariesListReq selectDictionariesListReq) {
        log.info("-- selectDictionariesList, selectDictionariesListReq : [{}]", selectDictionariesListReq);
        return dictionaryService.selectDictionariesList(selectDictionariesListReq);
    }

    /**
     <html>
        <head>
            <body>
                <p>
                    Hello<br/>
                    Multiline<br/>
                    World<br/>
                </p>
            </body>
        </head>
     </html>
     */
    @Multiline private String html;




    @ResponseBody
    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public SelectDictionaryRes selectDictionary(@Valid SelectDictionaryReq selectDictionaryReq) {
        log.info("-- selectDictionary");

        log.info("html : [{}]", html);

        return dictionaryService.selectDictionary(selectDictionaryReq);
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public InsertDictionaryRes insertDictionary(@Valid @RequestBody InsertDictionaryReq insertDictionaryReq) {
        log.info("-- insertDictionary, insertDictionaryReq : [{}]", insertDictionaryReq);
        return dictionaryService.insertDictionary(insertDictionaryReq);
    }

}
