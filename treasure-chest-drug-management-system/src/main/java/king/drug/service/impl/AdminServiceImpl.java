package king.drug.service.impl;

import king.drug.api.AdminApi;
import king.drug.api.dtoreq.FactoryReqDTO;
import king.drug.api.dtoreq.InstorageReqDTO;
import king.drug.api.dtoreq.MedicineReqDTO;
import king.drug.api.dtores.AjaxInfoResDTO;
import king.drug.dal.mapper.AdminMapper;
import king.drug.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: hemenghao
 * @date: 2022/3/19 12:11
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AjaxInfoResDTO insertStroage(InstorageReqDTO instorage, HttpSession session) {
        System.out.println(instorage);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        InstorageReqDTO in = new InstorageReqDTO();
        if (session.getAttribute("userName") != null) {
            MedicineReqDTO med = adminMapper.getMedicineBymedId(instorage.getMedId());
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date();
            in.setMedId(instorage.getMedId());
            in.setBuyerId(instorage.getBuyerId());
            in.setInDate(time.format(date));
            in.setInStorageNum(instorage.getInStorageNum());
            if (med == null) {
                ajaxInfo.setCode(-1);
                ajaxInfo.setMsg("入库失败，该药品不存在！");
            } else {
                adminMapper.insertInstorage(in);
                adminMapper.updateMedStorage(instorage.getMedId(), instorage.getInStorageNum() + med.getMedStorage());
                ajaxInfo.setMsg("入库成功~");
                ajaxInfo.setCode(0);
            }

            return ajaxInfo;

        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO insertMedicine(MedicineReqDTO medicine, HttpSession session) {
        System.out.println(medicine);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            MedicineReqDTO med = adminMapper.getMedicineBymedId(medicine.getMedId());
            if (med == null) {
                adminMapper.insertMedicine(medicine);
                ajaxInfo.setMsg("插入信息成功~");
                ajaxInfo.setCode(0);
            } else {
                ajaxInfo.setMsg("该药品已存在~");
                ajaxInfo.setCode(-1);
            }
            return ajaxInfo;
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryMedicine(MedicineReqDTO medicine, HttpSession session) {
        System.out.println(medicine);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            MedicineReqDTO med = adminMapper.getMedicineBymedId(medicine.getMedId());
            if (med == null) {
                ajaxInfo.setMsg("该药品不存在，请重新输入！");
                ajaxInfo.setCode(-1);
            } else {
                ajaxInfo.setMsg("查询成功！");
                ajaxInfo.setData(med);
                ajaxInfo.setCode(0);
                System.out.println(med);
            }
            return ajaxInfo;
        } else {
            ajaxInfo.setMsg("权限不足！请先登录~");
            ajaxInfo.setCode(-2);
        }

        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO updateMedicine(MedicineReqDTO medicine, HttpSession session) {
        System.out.println(medicine);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            adminMapper.updateMedicine(medicine);
            ajaxInfo.setMsg("更新成功！");
            ajaxInfo.setCode(0);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO deleteMedicine(MedicineReqDTO medicine, HttpSession session) {
        System.out.println(medicine);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            adminMapper.deleteMedicine(medicine.getMedId());
            ajaxInfo.setMsg("删除成功！");
            ajaxInfo.setCode(0);
        } else {
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO insertFactory(FactoryReqDTO factory, HttpSession session) {
        System.out.println(factory);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            FactoryReqDTO fId = adminMapper.getFactoryByfactoryId(factory.getFactoryId());
            if (fId == null) {
                adminMapper.insertFactory(factory);
                ajaxInfo.setMsg("插入信息成功~");
                ajaxInfo.setCode(0);
            } else {
                ajaxInfo.setMsg("该药厂已存在~");
                ajaxInfo.setCode(-1);
            }
            return ajaxInfo;
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO queryFactory(FactoryReqDTO factory, HttpSession session) {
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            FactoryReqDTO fId = adminMapper.getFactoryByfactoryId(factory.getFactoryId());
            if (fId == null) {
                ajaxInfo.setMsg("该药厂不存在，请重新输入！");
                ajaxInfo.setCode(-1);
            } else {
                ajaxInfo.setMsg("查询成功！");
                ajaxInfo.setData(fId);
                ajaxInfo.setCode(0);
                System.out.println(fId);
            }
            return ajaxInfo;
        } else {
            ajaxInfo.setMsg("权限不足！请先登录~");
            ajaxInfo.setCode(-2);
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO updateFactory(FactoryReqDTO factory, HttpSession session) {
        System.out.println(factory);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            adminMapper.updateFactory(factory);
            ajaxInfo.setMsg("更新成功！");
            ajaxInfo.setCode(0);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }

    @Override
    public AjaxInfoResDTO deleteFactory(FactoryReqDTO factory, HttpSession session) {
        System.out.println(factory);
        AjaxInfoResDTO ajaxInfo = new AjaxInfoResDTO();
        if (session.getAttribute("userName") != null) {
            adminMapper.deleteFactory(factory.getFactoryId());
            ajaxInfo.setMsg("删除成功！");
            ajaxInfo.setCode(0);
        } else {
            ajaxInfo.setCode(-2);
            ajaxInfo.setMsg("权限不足！请先登录~");
        }
        return ajaxInfo;
    }
}
