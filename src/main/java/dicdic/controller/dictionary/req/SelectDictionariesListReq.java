package dicdic.controller.dictionary.req;

import dicdic.controller.common.req.CommonReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper=false)
public class SelectDictionariesListReq extends CommonReq {
    @NotNull(message = "페이지별 rows개수 누락")
    @DecimalMin(value="1", message = "페이지별 rows개수가 유효하지 않습니다.")
    private Integer size;

    @NotNull(message = "현재 페이지 번호(단, 1부터 시작함) 누락")
    @DecimalMin(value="1",message = "현재 페이지 번호(단, 1부터 시작함)가 유효하지 않습니다.")
    private Integer page;

    private String word;

    private String value;

    @Size(min=8, max=8, message="시작일자(YYYYMMDD)는 8자리만 허용합니다.")
    @Min(value=19700101, message="시작날짜(yyyymmdd)의 최소입력값은 19700101 입니다.")
    @Pattern(regexp="^[0-9]*$", message="시작일자(YYYYMMDD)는 숫자만 허용합니다.")
    private String startDate;

    @Size(min=8, max=8, message="종료일자(YYYYMMDD)는 8자리만 허용합니다.")
    @Min(value=19700101, message="종료날짜(yyyymmdd)의 최소입력값은 19700101 입니다.")
    @Pattern(regexp="^[0-9]*$", message="종료일자(YYYYMMDD)는 숫자만 허용합니다.")
    private String endDate;
}
