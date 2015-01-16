package dicdic.service;

import dicdic.controller.dictionary.req.InsertDictionaryReq;
import dicdic.controller.dictionary.req.SelectDictionaryReq;
import dicdic.controller.dictionary.res.InsertDictionaryRes;
import dicdic.controller.dictionary.res.SelectDictionaryRes;
import dicdic.persistence.domain.Dictionary;
import dicdic.persistence.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public SelectDictionaryRes selectDictionary(SelectDictionaryReq selectDictionaryReq) {
        Dictionary dictionary = dictionaryMapper.selectDictionary(selectDictionaryReq.getWord());
        return new SelectDictionaryRes(dictionary);
    }

    @Override
    public InsertDictionaryRes insertDictionary(InsertDictionaryReq insertDictionaryReq) {
        Dictionary dictionary = new Dictionary();
        dictionary.setWord(insertDictionaryReq.getWord());
        dictionary.setValue(insertDictionaryReq.getValue());
        dictionary.setDes(insertDictionaryReq.getDes());
        dictionaryMapper.insertDictionary(dictionary);
        return new InsertDictionaryRes();
    }
}
