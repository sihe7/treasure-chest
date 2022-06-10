package king.drug.api;

import king.drug.api.dtoreq.MedicineTableReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;

import javax.servlet.http.HttpSession;

/**
 * 查询相关API
 * @author: hemenghao
 * @date: 2022/3/19 12:56
 */
public interface QueryApi {
    /**
     * 查询药物信息
     * @param session
     * @return
     */
    AjaxInfoResDTO queryMedicine(HttpSession session);

    /**
     * 查询药厂信息
     * @param session
     * @return
     */
    AjaxInfoResDTO queryFactory(HttpSession session);

    /**
     * 查询采购员信息
     * @param session
     * @return
     */
    AjaxInfoResDTO queryBuyer(HttpSession session);

    /**
     * 入库
     * @param medicineTable
     * @param session
     * @return
     */
    AjaxInfoResDTO showInRecord(MedicineTableReqDTO medicineTable, HttpSession session);

    /**
     * 出库
     * @param medicineTable
     * @param session
     * @return
     */
    AjaxInfoResDTO showOutRecord(MedicineTableReqDTO medicineTable, HttpSession session);

    /**
     * 根据名称查药物
     * @param medicineTable
     * @param session
     * @return
     */
    AjaxInfoResDTO queryMedicineByName(MedicineTableReqDTO medicineTable, HttpSession session);

    /**
     * 根据名称查药厂
     * @param medicineTable
     * @param session
     * @return
     */
    AjaxInfoResDTO queryFactoryByName(MedicineTableReqDTO medicineTable, HttpSession session);

    /**
     * 根据名称查采药者
     * @param medicineTable
     * @param session
     * @return
     */
    AjaxInfoResDTO queryBuyerByName(MedicineTableReqDTO medicineTable, HttpSession session);

    /**
     * 根据名称查管理
     * @param medicineTable
     * @param session
     * @return
     */
    AjaxInfoResDTO queryUserByName(MedicineTableReqDTO medicineTable, HttpSession session);

}
