package com.neu.his.cloud.service.dms.service;

public interface DmsFeeRabbitMQService {

    /**
     * 描述:草药处方超时未缴费处理（设置状态为4已过期）
     * <p>author: Peter
     */
    int herbalOutOfTime(Long prescriptionId);

    /**
     * 描述:成药处方超时未缴费处理（设置状态为4已过期）
     * <p>author: Peter
     */
    int medicineOutOfTime(Long prescriptionId);

    /**
     * 描述:非药品超时未缴费处理（设置状态为6已过期）
     * <p>author: Peter
     */
    int nonDrugOutOfTime(Long prescriptionId);

}
