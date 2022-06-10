package king.drug.controller;

import king.drug.api.TakeApi;
import king.drug.api.dtoreq.OutstorageReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import king.drug.service.AdminService;
import king.drug.service.TakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:49
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/take")
public class TakeController implements TakeApi {

    @Autowired
    private TakeService takeService;

    @Override
    @RequestMapping("/insertStorage")
    public AjaxInfoResDTO outStroage(@RequestBody OutstorageReqDTO outstorage, HttpSession session) {
        return takeService.outStroage(outstorage, session);
    }
}
