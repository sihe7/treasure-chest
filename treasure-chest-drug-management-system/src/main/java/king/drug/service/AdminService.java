package king.drug.service;

import king.drug.api.dtoreq.FactoryReqDTO;
import king.drug.api.dtoreq.InstorageReqDTO;
import king.drug.api.dtoreq.MedicineReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 12:11
 */
public interface AdminService {
    AjaxInfoResDTO insertStroage(InstorageReqDTO instorage, HttpSession session);

    AjaxInfoResDTO insertMedicine(MedicineReqDTO medicine, HttpSession session);

    AjaxInfoResDTO queryMedicine(MedicineReqDTO medicine, HttpSession session);

    AjaxInfoResDTO updateMedicine(MedicineReqDTO medicine, HttpSession session);

    AjaxInfoResDTO deleteMedicine(MedicineReqDTO medicine, HttpSession session);

    AjaxInfoResDTO insertFactory(FactoryReqDTO factory, HttpSession session);

    AjaxInfoResDTO queryFactory(FactoryReqDTO factory, HttpSession session);

    AjaxInfoResDTO updateFactory(FactoryReqDTO factory, HttpSession session);

    AjaxInfoResDTO deleteFactory(FactoryReqDTO factory, HttpSession session);
}
