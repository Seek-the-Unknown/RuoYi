package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图书信息对象 books_information
 */
public class BooksInformation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 (对应数据库 book_id) */
    private Long id;

    /** 图书名称 */
    @Excel(name = "图书名称")
    private String bookName;

    /** 图书作者 */
    @Excel(name = "图书作者")
    private String bookAuthor;

    /** 图书封面 (保存图片路径) */
    @Excel(name = "图书封面")
    private String bookImage;

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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
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
                .append("bookAuthor", getBookAuthor())
                .append("bookImage", getBookImage())
                .append("typeId", getTypeId())
                .append("booksTypeName", getBooksTypeName())
                .toString();
    }
}