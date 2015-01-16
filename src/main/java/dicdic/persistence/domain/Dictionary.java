package dicdic.persistence.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Dictionary {
    private String word               ;
    private String value              ;
    private String des                ;
    private Date   created_date       ;
    private Long   created_by         ;
    private Date   last_modified_date ;
    private Long   lasy_modified_by   ;
}