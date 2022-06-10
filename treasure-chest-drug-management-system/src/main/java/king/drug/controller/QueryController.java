package king.drug.controller;

import king.drug.api.QueryApi;
import king.drug.api.dtoreq.MedicineTableReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import king.drug.service.QueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 12:59
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/query")
public class QueryController implements QueryApi {
    @Autowired
    private QueryService queryService;

    @Override
    @RequestMapping("/queryMedicine")
    public AjaxInfoResDTO queryMedicine(HttpSession session) {
        return queryService.queryMedicine(session);
    }

    @Override
    @RequestMapping("/queryFactory")
    public AjaxInfoResDTO queryFactory(HttpSession session) {
        return queryService.queryFactory(session);
    }

    @Override
    @RequestMapping("/queryBuyer")
    public AjaxInfoResDTO queryBuyer(HttpSession session) {
        return queryService.queryBuyer(session);
    }

    @Override
    @RequestMapping("/showInRecord")
    public AjaxInfoResDTO showInRecord(MedicineTableReqDTO medicineTable, HttpSession session) {
        return queryService.showInRecord(medicineTable,session);
    }

    @Override
    @RequestMapping("/showOutRecord")
    public AjaxInfoResDTO showOutRecord(MedicineTableReqDTO medicineTable, HttpSession session) {
        return queryService.showOutRecord(medicineTable,session);
    }

    @Override
    @RequestMapping("/queryMedicineByName")
    public AjaxInfoResDTO queryMedicineByName(MedicineTableReqDTO medicineTable, HttpSession session) {
        return queryService.queryMedicineByName(medicineTable,session);
    }

    @Override
    @RequestMapping("/queryFactoryByName")
    public AjaxInfoResDTO queryFactoryByName(MedicineTableReqDTO medicineTable, HttpSession session) {
        return queryService.queryFactoryByName(medicineTable,session);
    }

    @Override
    @RequestMapping("/queryBuyerByName")
    public AjaxInfoResDTO queryBuyerByName(MedicineTableReqDTO medicineTable, HttpSession session) {
        return queryService.queryBuyerByName(medicineTable,session);
    }

    @Override
    @RequestMapping("/queryUserByName")
    public AjaxInfoResDTO queryUserByName(MedicineTableReqDTO medicineTable, HttpSession session) {
        return queryService.queryUserByName(medicineTable,session);
    }
}
