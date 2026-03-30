package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BooksUsers;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
public interface BooksUsersMapper 
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    public BooksUsers selectBooksUsersById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param booksUsers 用户信息
     * @return 用户信息集合
     */
    public List<BooksUsers> selectBooksUsersList(BooksUsers booksUsers);

    /**
     * 新增用户信息
     * 
     * @param booksUsers 用户信息
     * @return 结果
     */
    public int insertBooksUsers(BooksUsers booksUsers);

    /**
     * 修改用户信息
     * 
     * @param booksUsers 用户信息
     * @return 结果
     */
    public int updateBooksUsers(BooksUsers booksUsers);

    /**
     * 删除用户信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteBooksUsersById(Long id);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBooksUsersByIds(Long[] ids);
}
