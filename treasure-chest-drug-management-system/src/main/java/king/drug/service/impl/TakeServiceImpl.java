package king.drug.service.impl;

import king.drug.api.dtoreq.MedicineReqDTO;
import king.drug.api.dtoreq.OutstorageReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import king.drug.common.enums.CommonEnum;
import king.drug.dal.mapper.AdminMapper;
import king.drug.dal.mapper.TakeMapper;
import king.drug.service.AdminService;
import king.drug.service.TakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: hemenghao
 * @date: 2022/3/19 13:50
 */
@Service
public class TakeServiceImpl implements TakeService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private TakeMapper takeMapper;

    @Override
    public AjaxInfoResDTO outStroage(OutstorageReqDTO outstorage, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        OutstorageReqDTO o1 = new OutstorageReqDTO();
        if (session.getAttribute("userName") != null) {
            MedicineReqDTO med = adminMapper.getMedicineBymedId(outstorage.getMedId());
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if (med == null) {
                ajaxInfo.setCode(-1);
                ajaxInfo.setMsg(CommonEnum.DRUG_NOT_EXIST.getMessage());
            } else {
                if (med.getMedStorage()>=outstorage.getOutStorageNum()) {
                    o1.setMedId(outstorage.getMedId());
                    o1.setPatientId(outstorage.getPatientId());
                    o1.setOutStorageNum(outstorage.getOutStorageNum());
                    o1.setOutDate(time.format(new Date()));
                    adminMapper.updateMedStorage(med.getMedId(), med.getMedStorage()-outstorage.getOutStorageNum());
                    ajaxInfo.setMsg("取药成功");
                    ajaxInfo.setCode(0);
                    takeMapper.insertOutStorage(o1);
                }else{
                    ajaxInfo.setCode(-1);
                    ajaxInfo.setMsg("取药数量大于库存量，请重新输入！该药品当前库存量为："+med.getMedStorage());
                }
                return ajaxInfo;
            }
            return ajaxInfo;

        } else {
            ajaxInfo.setMsg(CommonEnum.LOGIN_COMPETENCE_NO.getMessage());
        }
        return ajaxInfo;
    }
}
