package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit,int orderMode);

    //@Param用于给参数取别名
    //如果只有一个参数，并且用于动态SQL，则必须要加上别名
    int selectDiscussPostRows(@Param("userId") int userId);

    //插入一条帖子
    int insertDiscussPost(DiscussPost discussPost);

    //查看帖子详细信息
    DiscussPost selectDiscussPostById(int id);

    //事务增加帖子时更新帖子数量
    int updateCommentCount(int id,int commentCount);

    int updateType (int id, int type);

    int updateStatus (int id, int status);

    int updateScore(int id,double score);
}
