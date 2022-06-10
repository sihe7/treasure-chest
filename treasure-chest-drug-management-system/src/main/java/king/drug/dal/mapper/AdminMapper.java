package king.drug.dal.mapper;

import king.drug.api.dtoreq.FactoryReqDTO;
import king.drug.api.dtoreq.InstorageReqDTO;
import king.drug.api.dtoreq.MedicineReqDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: hemenghao
 * @date: 2022/3/19 12:29
 */
@Mapper
public interface AdminMapper {

    int insertMedicine(MedicineReqDTO medicine);
    MedicineReqDTO getMedicineBymedId(int medId);
    int updateMedStorage(@Param("medId") int medId, @Param("medStorage")int medStorage);
    int insertInstorage(InstorageReqDTO instorage);
    int updateMedicine(MedicineReqDTO medicine);
    int deleteMedicine(int medId);
    int insertFactory(FactoryReqDTO factory);
    FactoryReqDTO getFactoryByfactoryId(int factoryId);
    int updateFactory(FactoryReqDTO factory);
    int deleteFactory(int factoryId);
}
