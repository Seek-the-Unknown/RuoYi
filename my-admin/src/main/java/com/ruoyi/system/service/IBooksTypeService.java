package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BooksType;

/**
 * 硬件类型Service接口
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
public interface IBooksTypeService 
{
    /**
     * 查询硬件类型
     * 
     * @param typeId 硬件类型主键
     * @return 硬件类型
     */
    public BooksType selectBooksTypeByTypeId(Long typeId);

    /**
     * 查询硬件类型列表
     * 
     * @param booksType 硬件类型
     * @return 硬件类型集合
     */
    public List<BooksType> selectBooksTypeList(BooksType booksType);

    /**
     * 新增硬件类型
     * 
     * @param booksType 硬件类型
     * @return 结果
     */
    public int insertBooksType(BooksType booksType);

    /**
     * 修改硬件类型
     * 
     * @param booksType 硬件类型
     * @return 结果
     */
    public int updateBooksType(BooksType booksType);

    /**
     * 批量删除硬件类型
     * 
     * @param typeIds 需要删除的硬件类型主键集合
     * @return 结果
     */
    public int deleteBooksTypeByTypeIds(Long[] typeIds);

    /**
     * 删除硬件类型信息
     * 
     * @param typeId 硬件类型主键
     * @return 结果
     */
    public int deleteBooksTypeByTypeId(Long typeId);
}
