package king.drug.dal.mapper;

import king.drug.api.dtoreq.*;
import king.drug.api.dtores.ShowInRecordResDTO;
import king.drug.api.dtores.ShowOutRecordResDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueryMapper {
    List<MedicineReqDTO> queryMedicine();
    List<FactoryReqDTO> queryFactory();
    List<BuyerReqDTO> queryBuyer();
    List<ShowInRecordResDTO> getInRecord(MedicineTableReqDTO medicineTable);
    List<ShowOutRecordResDTO> getOutRecord(MedicineTableReqDTO medicineTable);
    int getInRecordCount(MedicineTableReqDTO medicineTable);
    int getOutRecordCount(MedicineTableReqDTO medicineTable);
    int queryMedicineByNameCount(MedicineTableReqDTO medicineTable);
    List<MedicineReqDTO> queryMedicineByName(MedicineTableReqDTO medicineTable);
    int queryFactoryByNameCount(MedicineTableReqDTO medicineTable);
    List<FactoryReqDTO> queryFactoryByName(MedicineTableReqDTO medicineTable);
    int queryBuyerByNameCount(MedicineTableReqDTO medicineTable);
    List<BuyerReqDTO> queryBuyerByName(MedicineTableReqDTO medicineTable);
    int queryUserByNameCount(MedicineTableReqDTO medicineTable);
    List<UserReqDTO> queryUserByName(MedicineTableReqDTO medicineTable);

}