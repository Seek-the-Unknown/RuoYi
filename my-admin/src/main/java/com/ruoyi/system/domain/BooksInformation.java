package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class BooksInformation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 图书名称 */
    @Excel(name = "图书名称")
    private String bookName;

    /** 类型ID */
    @Excel(name = "类型ID")
    private Long typeId;

    /** 图书类型名称 */
    @Excel(name = "图书类型")
    private String booksTypeName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public String getBooksTypeName() {
        return booksTypeName;
    }

    public void setBooksTypeName(String booksTypeName) {
        this.booksTypeName = booksTypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bookName", getBookName())
                .append("typeId", getTypeId())
                .append("booksTypeName", getBooksTypeName())
                .toString();
    }
}