package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BooksInformation;

/**
 * 图书信息Service接口
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
public interface IBooksInformationService 
{
    /**
     * 查询图书信息
     * 
     * @param bookId 图书信息主键
     * @return 图书信息
     */
    public BooksInformation selectBooksInformationByBookId(Long bookId);

    /**
     * 查询图书信息列表
     * 
     * @param booksInformation 图书信息
     * @return 图书信息集合
     */
    public List<BooksInformation> selectBooksInformationList(BooksInformation booksInformation);

    /**
     * 新增图书信息
     * 
     * @param booksInformation 图书信息
     * @return 结果
     */
    public int insertBooksInformation(BooksInformation booksInformation);

    /**
     * 修改图书信息
     * 
     * @param booksInformation 图书信息
     * @return 结果
     */
    public int updateBooksInformation(BooksInformation booksInformation);

    /**
     * 批量删除图书信息
     * 
     * @param bookIds 需要删除的图书信息主键集合
     * @return 结果
     */
    public int deleteBooksInformationByBookIds(Long[] bookIds);

    /**
     * 删除图书信息信息
     * 
     * @param bookId 图书信息主键
     * @return 结果
     */
    public int deleteBooksInformationByBookId(Long bookId);
}
