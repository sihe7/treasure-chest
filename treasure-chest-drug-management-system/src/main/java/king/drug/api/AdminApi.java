package king.drug.api;

import king.drug.api.dtoreq.FactoryReqDTO;
import king.drug.api.dtoreq.InstorageReqDTO;
import king.drug.api.dtoreq.MedicineReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import javax.servlet.http.HttpSession;

/**
 * 管理员相关API
 * @author: hemenghao
 * @date: 2022/3/19 10:34
 */
public interface AdminApi {
    /**
     * 添加药物信息采购
     * @param instorage
     * @param session
     * @return
     */
    AjaxInfoResDTO insertStroage(InstorageReqDTO instorage, HttpSession session);

    /**
     * 添加药物信息
     * @param medicine
     * @param session
     * @return
     */
    AjaxInfoResDTO insertMedicine(MedicineReqDTO medicine, HttpSession session);

    /**
     * 查询药物信息
     * @param medicine
     * @param session
     * @return
     */
    AjaxInfoResDTO queryMedicine(MedicineReqDTO medicine, HttpSession session);

    /**
     * 更新药物信息
     * @param medicine
     * @param session
     * @return
     */
    AjaxInfoResDTO updateMedicine(MedicineReqDTO medicine, HttpSession session);

    /**
     * 删除药物信息
     * @param medicine
     * @param session
     * @return
     */
    AjaxInfoResDTO deleteMedicine(MedicineReqDTO medicine, HttpSession session);

    /**
     * 添加药厂信息
     * @param factory
     * @param session
     * @return
     */
    AjaxInfoResDTO insertFactory(FactoryReqDTO factory, HttpSession session);

    /**
     * 查询药厂信息
     * @param factory
     * @param session
     * @return
     */
    AjaxInfoResDTO queryFactory(FactoryReqDTO factory, HttpSession session);

    /**
     * 更新药厂信息
     * @param factory
     * @param session
     * @return
     */
    AjaxInfoResDTO updateFactory(FactoryReqDTO factory, HttpSession session);

    /**
     * 删除药厂信息
     * @param factory
     * @param session
     * @return
     */
    AjaxInfoResDTO deleteFactory(FactoryReqDTO factory, HttpSession session);

}
