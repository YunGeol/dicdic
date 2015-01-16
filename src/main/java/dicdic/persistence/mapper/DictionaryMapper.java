package dicdic.persistence.mapper;

import dicdic.persistence.domain.Dictionary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface DictionaryMapper {

    @Select("select " +
            "   word              " +
            "   , value             " +
            "   , des               " +
            "   , created_date      " +
            "   , created_by        " +
            "   , last_modified_date" +
            "   , lasy_modified_by  " +
            "from " +
            "   dictionary " +
            "where " +
            "   word = #{word}")
    public Dictionary selectDictionary(String word);


    @Insert("insert into dictionary(" +
            "     word              " +
            "   , value             " +
            "   , des               " +
            "   , created_date      " +
            "   , created_by        " +
            "   , last_modified_date" +
            "   , lasy_modified_by  " +
            ") values(" +
            "     #{word}              " +
            "   , #{value}             " +
            "   , #{des}               " +
            "   , #{created_date}      " +
            "   , #{created_by}        " +
            "   , #{last_modified_date}" +
            "   , #{lasy_modified_by}  " +
            ")")
    public void insertDictionary(Dictionary dictionary);


    @Delete("delete from dictionary where word = #{word}")
    public void deleteDictionary(String word);

}