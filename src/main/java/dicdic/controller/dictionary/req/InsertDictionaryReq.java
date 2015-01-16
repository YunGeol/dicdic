package dicdic.controller.dictionary.req;

import dicdic.controller.common.req.CommonReq;
import lombok.Data;

@Data
public class InsertDictionaryReq extends CommonReq {
    private String word               ;
    private String value              ;
    private String des                ;
}
