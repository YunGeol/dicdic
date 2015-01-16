package dicdic.service;

import dicdic.controller.dictionary.req.InsertDictionaryReq;
import dicdic.controller.dictionary.req.SelectDictionaryReq;
import dicdic.controller.dictionary.res.InsertDictionaryRes;
import dicdic.controller.dictionary.res.SelectDictionaryRes;

public interface DictionaryService {
    public SelectDictionaryRes selectDictionary(SelectDictionaryReq selectDictionaryReq);
    public InsertDictionaryRes insertDictionary(InsertDictionaryReq insertDictionaryReq);
}
