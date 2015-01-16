package dicdic.controller.dictionary.res;

import dicdic.controller.common.res.CommonRes;
import dicdic.persistence.domain.Dictionary;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class SelectDictionariesListRes extends CommonRes {
    List<Dictionary> lsDictionaries;
}
