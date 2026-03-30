package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.BooksInformation;
import com.ruoyi.system.mapper.BooksTypeMapper;
import com.ruoyi.system.domain.BooksType;
import com.ruoyi.system.service.IBooksTypeService;

/**
 * 硬件类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
@Service
public class BooksTypeServiceImpl implements IBooksTypeService 
{
    @Autowired
    private BooksTypeMapper booksTypeMapper;

    /**
     * 查询硬件类型
     * 
     * @param typeId 硬件类型主键
     * @return 硬件类型
     */
    @Override
    public BooksType selectBooksTypeByTypeId(Long typeId)
    {
        return booksTypeMapper.selectBooksTypeByTypeId(typeId);
    }

    /**
     * 查询硬件类型列表
     * 
     * @param booksType 硬件类型
     * @return 硬件类型
     */
    @Override
    public List<BooksType> selectBooksTypeList(BooksType booksType)
    {
        return booksTypeMapper.selectBooksTypeList(booksType);
    }

    /**
     * 新增硬件类型
     * 
     * @param booksType 硬件类型
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBooksType(BooksType booksType)
    {
        int rows = booksTypeMapper.insertBooksType(booksType);
        insertBooksInformation(booksType);
        return rows;
    }

    /**
     * 修改硬件类型
     * 
     * @param booksType 硬件类型
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBooksType(BooksType booksType)
    {
        booksTypeMapper.deleteBooksInformationByTypeId(booksType.getTypeId());
        insertBooksInformation(booksType);
        return booksTypeMapper.updateBooksType(booksType);
    }

    /**
     * 批量删除硬件类型
     * 
     * @param typeIds 需要删除的硬件类型主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBooksTypeByTypeIds(Long[] typeIds)
    {
        booksTypeMapper.deleteBooksInformationByTypeIds(typeIds);
        return booksTypeMapper.deleteBooksTypeByTypeIds(typeIds);
    }

    /**
     * 删除硬件类型信息
     * 
     * @param typeId 硬件类型主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBooksTypeByTypeId(Long typeId)
    {
        booksTypeMapper.deleteBooksInformationByTypeId(typeId);
        return booksTypeMapper.deleteBooksTypeByTypeId(typeId);
    }

    /**
     * 新增图书信息信息
     * 
     * @param booksType 硬件类型对象
     */
    public void insertBooksInformation(BooksType booksType)
    {
        List<BooksInformation> booksInformationList = booksType.getBooksInformationList();
        Long typeId = booksType.getTypeId();
        if (StringUtils.isNotNull(booksInformationList))
        {
            List<BooksInformation> list = new ArrayList<BooksInformation>();
            for (BooksInformation booksInformation : booksInformationList)
            {
                booksInformation.setTypeId(typeId);
                list.add(booksInformation);
            }
            if (list.size() > 0)
            {
                booksTypeMapper.batchBooksInformation(list);
            }
        }
    }
}
