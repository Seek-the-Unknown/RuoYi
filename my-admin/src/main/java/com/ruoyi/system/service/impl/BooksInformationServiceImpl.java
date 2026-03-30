package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BooksInformationMapper;
import com.ruoyi.system.domain.BooksInformation;
import com.ruoyi.system.service.IBooksInformationService;

/**
 * 图书信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
@Service
public class BooksInformationServiceImpl implements IBooksInformationService 
{
    @Autowired
    private BooksInformationMapper booksInformationMapper;

    /**
     * 查询图书信息
     * 
     * @param bookId 图书信息主键
     * @return 图书信息
     */
    @Override
    public BooksInformation selectBooksInformationByBookId(Long bookId)
    {
        return booksInformationMapper.selectBooksInformationByBookId(bookId);
    }

    /**
     * 查询图书信息列表
     * 
     * @param booksInformation 图书信息
     * @return 图书信息
     */
    @Override
    public List<BooksInformation> selectBooksInformationList(BooksInformation booksInformation)
    {
        return booksInformationMapper.selectBooksInformationList(booksInformation);
    }

    /**
     * 新增图书信息
     * 
     * @param booksInformation 图书信息
     * @return 结果
     */
    @Override
    public int insertBooksInformation(BooksInformation booksInformation)
    {
        return booksInformationMapper.insertBooksInformation(booksInformation);
    }

    /**
     * 修改图书信息
     * 
     * @param booksInformation 图书信息
     * @return 结果
     */
    @Override
    public int updateBooksInformation(BooksInformation booksInformation)
    {
        return booksInformationMapper.updateBooksInformation(booksInformation);
    }

    /**
     * 批量删除图书信息
     * 
     * @param bookIds 需要删除的图书信息主键
     * @return 结果
     */
    @Override
    public int deleteBooksInformationByBookIds(Long[] bookIds)
    {
        return booksInformationMapper.deleteBooksInformationByBookIds(bookIds);
    }

    /**
     * 删除图书信息信息
     * 
     * @param bookId 图书信息主键
     * @return 结果
     */
    @Override
    public int deleteBooksInformationByBookId(Long bookId)
    {
        return booksInformationMapper.deleteBooksInformationByBookId(bookId);
    }
}
