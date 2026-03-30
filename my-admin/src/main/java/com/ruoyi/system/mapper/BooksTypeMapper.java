package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BooksType;
import com.ruoyi.system.domain.BooksInformation;

/**
 * 硬件类型Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
public interface BooksTypeMapper 
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
     * 删除硬件类型
     * 
     * @param typeId 硬件类型主键
     * @return 结果
     */
    public int deleteBooksTypeByTypeId(Long typeId);

    /**
     * 批量删除硬件类型
     * 
     * @param typeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBooksTypeByTypeIds(Long[] typeIds);

    /**
     * 批量删除图书信息
     * 
     * @param typeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBooksInformationByTypeIds(Long[] typeIds);
    
    /**
     * 批量新增图书信息
     * 
     * @param booksInformationList 图书信息列表
     * @return 结果
     */
    public int batchBooksInformation(List<BooksInformation> booksInformationList);
    

    /**
     * 通过硬件类型主键删除图书信息信息
     * 
     * @param typeId 硬件类型ID
     * @return 结果
     */
    public int deleteBooksInformationByTypeId(Long typeId);
}
