package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 硬件类型对象 books_type
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
public class BooksType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 硬件类型ID */
    private Long typeId;

    /** 硬件类型名称 */
    @Excel(name = "硬件类型名称")
    private String typeName;

    /** 图书信息信息 */
    private List<BooksInformation> booksInformationList;

    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }

    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }

    public List<BooksInformation> getBooksInformationList()
    {
        return booksInformationList;
    }

    public void setBooksInformationList(List<BooksInformation> booksInformationList)
    {
        this.booksInformationList = booksInformationList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeId", getTypeId())
            .append("typeName", getTypeName())
            .append("booksInformationList", getBooksInformationList())
            .toString();
    }
}
