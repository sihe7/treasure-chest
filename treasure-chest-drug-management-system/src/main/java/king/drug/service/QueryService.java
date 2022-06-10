package king.drug.service;

import king.drug.api.dtoreq.MedicineTableReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:00
 */
public interface QueryService {
    AjaxInfoResDTO queryMedicine(HttpSession session);

    AjaxInfoResDTO queryFactory(HttpSession session);

    AjaxInfoResDTO queryBuyer(HttpSession session);

    AjaxInfoResDTO showInRecord(MedicineTableReqDTO medicineTable, HttpSession session);

    AjaxInfoResDTO showOutRecord(MedicineTableReqDTO medicineTable, HttpSession session);

    AjaxInfoResDTO queryMedicineByName(MedicineTableReqDTO medicineTable, HttpSession session);

    AjaxInfoResDTO queryFactoryByName(MedicineTableReqDTO medicineTable, HttpSession session);

    AjaxInfoResDTO queryBuyerByName(MedicineTableReqDTO medicineTable, HttpSession session);

    AjaxInfoResDTO queryUserByName(MedicineTableReqDTO medicineTable, HttpSession session);
}
