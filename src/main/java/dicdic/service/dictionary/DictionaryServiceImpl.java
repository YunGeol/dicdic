package dicdic.service.dictionary;

import dicdic.controller.dictionary.req.InsertDictionaryReq;
import dicdic.controller.dictionary.req.SelectDictionariesListReq;
import dicdic.controller.dictionary.req.SelectDictionaryReq;
import dicdic.controller.dictionary.res.InsertDictionaryRes;
import dicdic.controller.dictionary.res.SelectDictionariesListRes;
import dicdic.controller.dictionary.res.SelectDictionaryRes;
import dicdic.persistence.domain.Dictionary;
import dicdic.persistence.mapper.DictionaryMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public SelectDictionariesListRes selectDictionariesList(SelectDictionariesListReq selectDictionariesListRes) {
        List<Dictionary> lsDictionary = dictionaryMapper.selectDictionariesList(selectDictionariesListRes);
        SelectDictionariesListRes res = new SelectDictionariesListRes();
        res.setLsDictionaries(lsDictionary);
        return res;
    }

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

        log.info("dictionary : [{}]", dictionary);

        dictionaryMapper.insertDictionary(dictionary);
        return new InsertDictionaryRes();
    }
}
