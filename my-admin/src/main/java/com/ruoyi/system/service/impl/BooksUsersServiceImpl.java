package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BooksUsersMapper;
import com.ruoyi.system.domain.BooksUsers;
import com.ruoyi.system.service.IBooksUsersService;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
@Service
public class BooksUsersServiceImpl implements IBooksUsersService 
{
    @Autowired
    private BooksUsersMapper booksUsersMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    @Override
    public BooksUsers selectBooksUsersById(Long id)
    {
        return booksUsersMapper.selectBooksUsersById(id);
    }

    /**
     * 查询用户信息列表
     * 
     * @param booksUsers 用户信息
     * @return 用户信息
     */
    @Override
    public List<BooksUsers> selectBooksUsersList(BooksUsers booksUsers)
    {
        return booksUsersMapper.selectBooksUsersList(booksUsers);
    }

    /**
     * 新增用户信息
     * 
     * @param booksUsers 用户信息
     * @return 结果
     */
    @Override
    public int insertBooksUsers(BooksUsers booksUsers)
    {
        return booksUsersMapper.insertBooksUsers(booksUsers);
    }

    /**
     * 修改用户信息
     * 
     * @param booksUsers 用户信息
     * @return 结果
     */
    @Override
    public int updateBooksUsers(BooksUsers booksUsers)
    {
        return booksUsersMapper.updateBooksUsers(booksUsers);
    }

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteBooksUsersByIds(Long[] ids)
    {
        return booksUsersMapper.deleteBooksUsersByIds(ids);
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteBooksUsersById(Long id)
    {
        return booksUsersMapper.deleteBooksUsersById(id);
    }
}
