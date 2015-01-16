package dicdic.persistence.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Dictionary extends CommonDomain{
    private String word ;
    private String value;
    private String des  ;
}