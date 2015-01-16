package dicdic.controller.dictionary;

import dicdic.controller.dictionary.req.InsertDictionaryReq;
import dicdic.controller.dictionary.req.SelectDictionaryReq;
import dicdic.controller.dictionary.res.InsertDictionaryRes;
import dicdic.controller.dictionary.res.SelectDictionaryRes;
import dicdic.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @RequestMapping(value = "/dic/{word}", method = RequestMethod.GET)
    public SelectDictionaryRes selectDictionary(@Valid SelectDictionaryReq selectDictionaryReq) {
        return dictionaryService.selectDictionary(selectDictionaryReq);
    }

    @RequestMapping(value = "/dic", method = RequestMethod.POST)
    public InsertDictionaryRes insertDictionary(@Valid @RequestBody InsertDictionaryReq insertDictionaryReq) {
        return dictionaryService.insertDictionary(insertDictionaryReq);
    }

}
