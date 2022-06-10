package king.drug.controller;

import king.drug.api.AdminApi;
import king.drug.api.dtoreq.FactoryReqDTO;
import king.drug.api.dtoreq.InstorageReqDTO;
import king.drug.api.dtoreq.MedicineReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import king.drug.common.constant.LogBackExEncoder;
import king.drug.common.enums.CommonEnum;
import king.drug.common.utils.VerifyUtil;
import king.drug.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 12:10
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController implements AdminApi {

    @Autowired
    private AdminService adminService;

    @Override
    @RequestMapping("/insertStorage")
    public AjaxInfoResDTO insertStroage(@RequestBody InstorageReqDTO instorage, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, instorage.getOrGenerateLogId());
            log.info("PARAMETER:[采购人采购药物数量接口请求:{}]", instorage);
            VerifyUtil.validateParams(instorage);
            AjaxInfoResDTO resDTO = adminService.insertStroage(instorage, session);
            log.info("[{}ms]RESPONSE:Result[采购人采购药物数量接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[采购人采购药物数量接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("入库失败，该药品不存在！");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }

    @Override
    @RequestMapping("/insertMedicine")
    public AjaxInfoResDTO insertMedicine(@RequestBody MedicineReqDTO medicine, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, medicine.getOrGenerateLogId());
            log.info("PARAMETER:[添加药物信息接口请求:{}]", medicine);
            VerifyUtil.validateParams(medicine);
            AjaxInfoResDTO resDTO = adminService.insertMedicine(medicine, session);
            log.info("[{}ms]RESPONSE:Result[添加药物信息接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[添加药物信息接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("该药品已存在~");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }

    @Override
    @RequestMapping("/queryMedicine")
    public AjaxInfoResDTO queryMedicine(@RequestBody MedicineReqDTO medicine, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, medicine.getOrGenerateLogId());
            log.info("PARAMETER:[查询药物信息接口请求:{}]", medicine);
            VerifyUtil.validateParams(medicine);
            AjaxInfoResDTO resDTO = adminService.queryMedicine(medicine, session);
            log.info("[{}ms]RESPONSE:Result[查询药物信息接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[查询药物信息接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("该药品不存在，请重新输入！");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }

    @Override
    @RequestMapping("/updateMedicine")
    public AjaxInfoResDTO updateMedicine(@RequestBody MedicineReqDTO medicine, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, medicine.getOrGenerateLogId());
            log.info("PARAMETER:[更新药物信息采购接口请求:{}]", medicine);
            VerifyUtil.validateParams(medicine);
            AjaxInfoResDTO resDTO = adminService.updateMedicine(medicine, session);
            log.info("[{}ms]RESPONSE:Result[更新药物信息采购接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[更新药物信息采购接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("入库失败，该药品不存在！");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }

    @Override
    @RequestMapping("/deleteMedicine")
    public AjaxInfoResDTO deleteMedicine(@RequestBody MedicineReqDTO medicine, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, medicine.getOrGenerateLogId());
            log.info("PARAMETER:[删除药物信息采购接口请求:{}]", medicine);
            VerifyUtil.validateParams(medicine);
            AjaxInfoResDTO resDTO = adminService.deleteMedicine(medicine, session);
            log.info("[{}ms]RESPONSE:Result[删除药物信息采购接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[删除药物信息采购接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("入库失败，该药品不存在！");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }

    @Override
    @RequestMapping("/insertFactory")
    public AjaxInfoResDTO insertFactory(@RequestBody FactoryReqDTO factory, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, factory.getOrGenerateLogId());
            log.info("PARAMETER:[添加药物工厂信息接口请求:{}]", factory);
            VerifyUtil.validateParams(factory);
            AjaxInfoResDTO resDTO = adminService.insertFactory(factory, session);
            log.info("[{}ms]RESPONSE:Result[添加药物工厂信息接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[添加药物工厂信息接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("该药厂已存在~");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }

    @Override
    @RequestMapping("/queryFactory")
    public AjaxInfoResDTO queryFactory(@RequestBody FactoryReqDTO factory, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, factory.getOrGenerateLogId());
            log.info("PARAMETER:[查询药物工厂信息接口请求:{}]", factory);
            VerifyUtil.validateParams(factory);
            AjaxInfoResDTO resDTO = adminService.queryFactory(factory, session);
            log.info("[{}ms]RESPONSE:Result[查询药物工厂信息接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[查询药物工厂信息接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("药厂不存在!");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }

    @Override
    @RequestMapping("/updateFactory")
    public AjaxInfoResDTO updateFactory(@RequestBody FactoryReqDTO factory, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, factory.getOrGenerateLogId());
            log.info("PARAMETER:[更新药场信息接口请求:{}]", factory);
            VerifyUtil.validateParams(factory);
            AjaxInfoResDTO resDTO = adminService.updateFactory(factory, session);
            log.info("[{}ms]RESPONSE:Result[更新药场信息接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[更新药场信息接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("更新药厂失败");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }

    @Override
    @RequestMapping("/deleteFactory")
    public AjaxInfoResDTO deleteFactory(@RequestBody FactoryReqDTO factory, HttpSession session) {
        long beginTime = System.currentTimeMillis();
        try {
            MDC.put(LogBackExEncoder.TRACE_LOG_ID, factory.getOrGenerateLogId());
            log.info("PARAMETER:[删除药场信息接口请求:{}]", factory);
            VerifyUtil.validateParams(factory);
            AjaxInfoResDTO resDTO = adminService.deleteFactory(factory, session);
            log.info("[{}ms]RESPONSE:Result[删除药场信息接口请求成功返回:{}]", (System.currentTimeMillis() - beginTime), resDTO.getData());
            return resDTO;
        } catch (Exception e) {
            log.error("[{}ms][{}][{}]RESPONSE:Result[删除药场信息接口请求接口失败返回:{}]",
                    (System.currentTimeMillis() - beginTime), CommonEnum.STATUS_FAIL.getMessage(),
                    CommonEnum.STATUS_FAIL.getCode(), e);
            AjaxInfoResDTO resDTO = new AjaxInfoResDTO();
            resDTO.setCode(-1);
            resDTO.setMsg("删除药厂失败");
            return resDTO;
        } finally {
            MDC.clear();
        }
    }
}
