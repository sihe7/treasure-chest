package king.drug.service;

import king.drug.api.dtoreq.OutstorageReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:50
 */
public interface TakeService {
    AjaxInfoResDTO outStroage(OutstorageReqDTO outstorage, HttpSession session);
}
