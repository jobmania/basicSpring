package com.demo.mapper;

import com.demo.beans.ContentBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface BoardMapper {


    //    마이바티스에서 제공하는 @SelectKey를 사용해 미리 시퀀스를 사용해 게시글번호를 wirteContentBean에 입력하면서 Insert 쿼리문을 실행한다.
    //content_idx 값이 나오면 먼저(before) sql문을 실행 결과를 입력한다.
    // values 값에 content_seq.nextval 대신에 #{content_idx}를 넣는다.
    @SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx", before = true, resultType = int.class)
    @Insert("insert into content_table(content_idx, content_subject, content_text, " +
            "content_file, content_writer_idx, content_board_idx, content_date) " +
            "values (#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, " +
            "#{content_writer_idx}, #{content_board_idx}, sysdate)")
    void addContentInfo(ContentBean writeContentBean);

    @Select("select board_info_name " +
            "from board_info_table " +
            "where board_info_idx = #{board_info_idx}")
    String getBoardInfoName(int board_info_idx);

    @Select("select  t1.content_idx, t1.content_subject, t2.user_name as content_writer_name, " +
            "to_char(t1.content_date, 'YYYY-MM-DD') as content_date " +
            "from content_table t1 JOIN user_table t2 " +
            "ON t1.content_writer_idx = t2.user_idx " +
            "and t1.content_board_idx = #{board_info_idx} order by t1.content_idx desc")
    List<ContentBean> getContentList(int board_info_idx);


    @Select("select t2.user_name as content_writer_name, " +
            "to_char(t1.content_date, 'YYYY-MM-DD') as content_date," +
            "t1.content_subject, t1.content_text, t1.content_file " +
            "from content_table t1 join user_table t2 " +
            "on t1.content_writer_idx = t2.user_idx " +
            "and content_idx = #{ content_idx }")
    ContentBean getContentInfo(int content_idx);


}
