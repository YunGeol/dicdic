package dicdic.service.dictionary;

import dicdic.controller.dictionary.req.InsertDictionaryReq;
import dicdic.controller.dictionary.req.SelectDictionariesListReq;
import dicdic.controller.dictionary.req.SelectDictionaryReq;
import dicdic.controller.dictionary.res.InsertDictionaryRes;
import dicdic.controller.dictionary.res.SelectDictionariesListRes;
import dicdic.controller.dictionary.res.SelectDictionaryRes;

public interface DictionaryService {
    public SelectDictionariesListRes selectDictionariesList(SelectDictionariesListReq selectDictionariesListReq);
    public SelectDictionaryRes selectDictionary(SelectDictionaryReq selectDictionaryReq);
    public InsertDictionaryRes insertDictionary(InsertDictionaryReq insertDictionaryReq);
}
