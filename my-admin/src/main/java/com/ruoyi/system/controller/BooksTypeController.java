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
import com.ruoyi.system.domain.BooksType;
import com.ruoyi.system.service.IBooksTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 硬件类型Controller
 * 
 * @author ruoyi
 * @date 2026-03-29
 */
@RestController
@RequestMapping("/system/type")
public class BooksTypeController extends BaseController
{
    @Autowired
    private IBooksTypeService booksTypeService;

    /**
     * 查询硬件类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(BooksType booksType)
    {
        startPage();
        List<BooksType> list = booksTypeService.selectBooksTypeList(booksType);
        return getDataTable(list);
    }

    /**
     * 导出硬件类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:export')")
    @Log(title = "硬件类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BooksType booksType)
    {
        List<BooksType> list = booksTypeService.selectBooksTypeList(booksType);
        ExcelUtil<BooksType> util = new ExcelUtil<BooksType>(BooksType.class);
        util.exportExcel(response, list, "硬件类型数据");
    }

    /**
     * 获取硬件类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:query')")
    @GetMapping(value = "/{typeId}")
    public AjaxResult getInfo(@PathVariable("typeId") Long typeId)
    {
        return success(booksTypeService.selectBooksTypeByTypeId(typeId));
    }

    /**
     * 新增硬件类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:add')")
    @Log(title = "硬件类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BooksType booksType)
    {
        return toAjax(booksTypeService.insertBooksType(booksType));
    }

    /**
     * 修改硬件类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:edit')")
    @Log(title = "硬件类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BooksType booksType)
    {
        return toAjax(booksTypeService.updateBooksType(booksType));
    }

    /**
     * 删除硬件类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:remove')")
    @Log(title = "硬件类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeIds}")
    public AjaxResult remove(@PathVariable Long[] typeIds)
    {
        return toAjax(booksTypeService.deleteBooksTypeByTypeIds(typeIds));
    }
}
