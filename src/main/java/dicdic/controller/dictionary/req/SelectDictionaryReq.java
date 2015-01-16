package dicdic.controller.dictionary.req;

import dicdic.controller.common.req.CommonReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SelectDictionaryReq extends CommonReq {
    private String word;
}
