package dicdic.controller.dictionary.res;

import dicdic.controller.common.res.CommonRes;
import dicdic.persistence.domain.Dictionary;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SelectDictionaryRes extends CommonRes {

    private Dictionary dictionary;

    public SelectDictionaryRes(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
}
