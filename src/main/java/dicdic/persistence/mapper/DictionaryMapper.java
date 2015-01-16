package dicdic.persistence.mapper;

import dicdic.controller.dictionary.req.SelectDictionariesListReq;
import dicdic.persistence.domain.Dictionary;
import org.adrianwalker.multilinestring.Multiline;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DictionaryMapper {

    // Oracle paging query
    // select * from (
    //     select rownum as rnum, A.* from (
    //         /* SQL to do something -- start */
    //
    //         /* SQL to do something -- end   */
    //     ) A where rownum &lt;= (#{page} * #{size})
    // ) where rnum &gt;= ((#{page} * #{size}) - (#{size} - 1))

    /**
    select * from (
        select rownum as rnum, A.* from (
            -- 하고자 하는 쿼리 시작
            select
                word
                , value
                , des
                , created_date
                , created_by
                , last_modified_date
                , lasy_modified_by
            from
                dictionary
            where
            1=1
            <if test="word != null and word != ''">
                and word  like '%' || #{word}  || '%'
            </if>
            <if test="value != null and value != ''">
                and value like '%' || #{value} || '%'
            </if>
            <if test="startDate != null and startDate != '' and endDate != null and endDate != ''">
                and created_date between
                        to_date(#{startDate} || '000000' , 'YYYYMMDDHH24MISS')
                        and
                        to_date(#{endDate}   || '235959' , 'YYYYMMDDHH24MISS')
            </if>
            -- 하고자 하는 쿼리 끝
        ) A where rownum &lt;= (#{page} * #{size})
    ) where rnum &gt;= ((#{page} * #{size}) - (#{size} - 1))
    */
    @Multiline String selectDictionariesListQuery = "";
    @Select("<script>" + selectDictionariesListQuery + "</script>")
    public List<Dictionary> selectDictionariesList(SelectDictionariesListReq selectDictionariesListReq);


    /**
    select
       word
       , value
       , des
       , created_date
       , created_by
       , last_modified_date
       , lasy_modified_by
    from
       dictionary
    where
       word = #{word}
    */
    @Multiline String selectDictionarySql = "";
    @Select(selectDictionarySql)
    public Dictionary selectDictionary(String word);

    /**
    insert into dictionary(
         word
       , value
       , des
       , created_date
       , created_by
       , last_modified_date
       <if test="lasy_modified_by != null and lasy_modified_by != ''">
       , lasy_modified_by
       </if>
    ) values(
         #{word}
       , #{value}
       , #{des}
       , #{created_date}
       , #{created_by}
       , #{last_modified_date}
       <if test="lasy_modified_by != null and lasy_modified_by != ''">
       , #{lasy_modified_by}
       </if>
    )
    */
    @Multiline String insertDictionarySql = "";
    @Insert("<script>" + insertDictionarySql + "</script>")
    public void insertDictionary(Dictionary dictionary);


    @Delete("delete from dictionary where word = #{word}")
    public void deleteDictionary(String word);



}