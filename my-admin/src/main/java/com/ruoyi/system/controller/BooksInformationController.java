package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BooksInformation;
import com.ruoyi.system.service.IBooksInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图书信息Controller
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
@RestController
@RequestMapping("/system/information")
public class BooksInformationController extends BaseController
{
    @Autowired
    private IBooksInformationService booksInformationService;

    /**
     * 查询图书信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(BooksInformation booksInformation)
    {
        startPage();
        List<BooksInformation> list = booksInformationService.selectBooksInformationList(booksInformation);
        return getDataTable(list);
    }

    /**
     * 导出图书信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:information:export')")
    @Log(title = "图书信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BooksInformation booksInformation)
    {
        List<BooksInformation> list = booksInformationService.selectBooksInformationList(booksInformation);
        ExcelUtil<BooksInformation> util = new ExcelUtil<BooksInformation>(BooksInformation.class);
        util.exportExcel(response, list, "图书信息数据");
    }

    /**
     * 获取图书信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:query')")
    @GetMapping(value = "/{bookId}")
    public AjaxResult getInfo(@PathVariable("bookId") Long bookId)
    {
        return success(booksInformationService.selectBooksInformationByBookId(bookId));
    }

    /**
     * 新增图书信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:add')")
    @Log(title = "图书信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BooksInformation booksInformation)
    {
        return toAjax(booksInformationService.insertBooksInformation(booksInformation));
    }

    /**
     * 修改图书信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:edit')")
    @Log(title = "图书信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BooksInformation booksInformation)
    {
        return toAjax(booksInformationService.updateBooksInformation(booksInformation));
    }

    /**
     * 删除图书信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:remove')")
    @Log(title = "图书信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bookIds}")
    public AjaxResult remove(@PathVariable Long[] bookIds)
    {
        return toAjax(booksInformationService.deleteBooksInformationByBookIds(bookIds));
    }
}
