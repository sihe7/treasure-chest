package king.drug.api;

import king.drug.api.dtoreq.OutstorageReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;

import javax.servlet.http.HttpSession;

/**
 * 取药员模块相关API
 * @author: hemenghao
 * @date: 2022/3/19 13:46
 */
public interface TakeApi {
    /**
     * 采购人购买完以后出库
     * @param outstorage
     * @param session
     * @return
     */
    AjaxInfoResDTO outStroage(OutstorageReqDTO outstorage, HttpSession session);
}
