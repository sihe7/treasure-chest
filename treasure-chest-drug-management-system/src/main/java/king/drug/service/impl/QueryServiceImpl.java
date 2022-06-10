package king.drug.service.impl;

import king.drug.api.dtoreq.*;
import king.drug.api.dtores.AjaxInfoResDTO;
import king.drug.api.dtores.ShowInRecordResDTO;
import king.drug.api.dtores.ShowOutRecordResDTO;
import king.drug.dal.mapper.QueryMapper;
import king.drug.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:00
 */
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private QueryMapper queryMapper;
    @Override
    public AjaxInfoResDTO queryMedicine(HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            List<MedicineReqDTO> medicines = queryMapper.queryMedicine();
            ajaxInfo.setCode(0);
            ajaxInfo.setMsg("查询成功");
            ajaxInfo.setData(medicines);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryFactory(HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            List<FactoryReqDTO> factories = queryMapper.queryFactory();
            ajaxInfo.setCode(0);
            ajaxInfo.setData(factories);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryBuyer(HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            List<BuyerReqDTO> buyers = queryMapper.queryBuyer();
            ajaxInfo.setCode(0);
            ajaxInfo.setData(buyers);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO showInRecord(MedicineTableReqDTO medicineTable,HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            int page=(medicineTable.getPage()-1)*medicineTable.getLimit();
            medicineTable.setPage(page);
            List<ShowInRecordResDTO> inRecord = queryMapper.getInRecord(medicineTable);
            ajaxInfo.setCount(queryMapper.getInRecordCount(medicineTable));
            ajaxInfo.setCode(0);
            ajaxInfo.setData(inRecord);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO showOutRecord(MedicineTableReqDTO medicineTable, HttpSession session) {

        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            int page=(medicineTable.getPage()-1)*medicineTable.getLimit();
            medicineTable.setPage(page);
            List<ShowOutRecordResDTO> outRecord = queryMapper.getOutRecord(medicineTable);
            ajaxInfo.setCount(queryMapper.getOutRecordCount(medicineTable));
            ajaxInfo.setCode(0);
            ajaxInfo.setData(outRecord);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryMedicineByName(MedicineTableReqDTO medicineTable, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        System.out.println(medicineTable);
        if (session.getAttribute("userName") != null) {
            int page=(medicineTable.getPage()-1)*medicineTable.getLimit();
            medicineTable.setPage(page);
            List<MedicineReqDTO> medicines = queryMapper.queryMedicineByName(medicineTable);
            ajaxInfo.setMsg("查询成功");
            ajaxInfo.setCount(queryMapper.queryMedicineByNameCount(medicineTable));
            ajaxInfo.setCode(0);
            ajaxInfo.setData(medicines);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryFactoryByName(MedicineTableReqDTO medicineTable, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        System.out.println(medicineTable);
        if (session.getAttribute("userName") != null) {
            int page=(medicineTable.getPage()-1)*medicineTable.getLimit();
            medicineTable.setPage(page);
            List<FactoryReqDTO> factories = queryMapper.queryFactoryByName(medicineTable);
            ajaxInfo.setMsg("查询成功");
            ajaxInfo.setCount(queryMapper.queryFactoryByNameCount(medicineTable));
            ajaxInfo.setCode(0);
            ajaxInfo.setData(factories);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryBuyerByName(MedicineTableReqDTO medicineTable, HttpSession session) {

        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        System.out.println(medicineTable);
        if (session.getAttribute("userName") != null) {
            int page=(medicineTable.getPage()-1)*medicineTable.getLimit();
            medicineTable.setPage(page);
            List<BuyerReqDTO> buyers = queryMapper.queryBuyerByName(medicineTable);
            ajaxInfo.setMsg("查询成功");
            ajaxInfo.setCount(queryMapper.queryBuyerByNameCount(medicineTable));
            ajaxInfo.setCode(0);
            ajaxInfo.setData(buyers);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryUserByName(MedicineTableReqDTO medicineTable, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        System.out.println(medicineTable);
        if (session.getAttribute("userName") != null) {
            int page=(medicineTable.getPage()-1)*medicineTable.getLimit();
            medicineTable.setPage(page);
            List<UserReqDTO> users = queryMapper.queryUserByName(medicineTable);
            ajaxInfo.setMsg("查询成功");
            ajaxInfo.setCount(queryMapper.queryUserByNameCount(medicineTable));
            ajaxInfo.setCode(0);
            ajaxInfo.setData(users);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }
}
